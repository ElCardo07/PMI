package pmi;

import Modelo.*;
import Controlador.*;
import Vista.*;
import java.util.List;

public class PMI {
    public static void main(String[] args) {
        
        // Instanciamos el ArchivoControlador definiendo el nombre fisico de los archivos
        ArchivoControlador archivoCtrl = new ArchivoControlador("pacientes.txt", "profesionales.txt", "estudios.txt");

        System.out.println("--- INICIANDO SISTEMA DE LABORATORIO ---");
        System.out.println("Buscando archivos de persistencia...");

        // Carga los datos desde el disco a la memoria RAM
        List<Paciente> pacientesCargados = archivoCtrl.cargarPacientes();
        List<Profesional> profesionalesCargados = archivoCtrl.cargarProfesionales();
        
        // El estudio se carga ultimo porque necesita las listas anteriores para rearmar los vinculos
        List<Estudio> estudiosCargados = archivoCtrl.cargarEstudios(pacientesCargados, profesionalesCargados);

        // Instanciamos los controladores inyectando los datos que acabamos de leer
        
        // Pacientes (Usa el constructor que recibe el objeto en blanco y la lista)
        PacienteControlador pControl = new PacienteControlador(new Paciente(), pacientesCargados);
        
        // Profesionales (Solucion al choque de estructuras: pasamos de List a HashMap)
        ProfesionalControlador profControl = new ProfesionalControlador();
        for (Profesional prof : profesionalesCargados) {
            // Usa el propio metodo para que se agreguen al mapa usando la matricula como clave
            profControl.registrarNuevoProfesional(
                prof.getMatricula(), 
                prof.getApellido(), 
                prof.getNombre(), 
                prof.getTelefono(), 
                prof.getMail()
            );
        }
        
        // Estudios
        EstudioControlador eControl = new EstudioControlador(new Estudio(), estudiosCargados);

        // Reporte de carga por consola 
        System.out.println("\n--- REPORTE DE CARGA INICIAL ---");
        System.out.println("Pacientes cargados: " + pacientesCargados.size());
        System.out.println("Profesionales cargados: " + profControl.totalProfesionales());
        System.out.println("Estudios cargados: " + estudiosCargados.size());
        System.out.println("--------------------------------\n");

        // Arranca la interfaz grafica pasandole los controladores ya llenos de datos
        VentanaPrincipal ventana = new VentanaPrincipal(pControl, profControl, eControl);
        ventana.setVisible(true);
    }
}

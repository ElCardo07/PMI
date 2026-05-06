package pmi;

import Modelo.*;
import Controlador.*;
import Vista.*;
import java.util.List;

public class PMI {
    public static void main(String[] args) {
        
        // 1. Instanciamos el ArchivoControlador definiendo el nombre físico de los archivos
        ArchivoControlador archivoCtrl = new ArchivoControlador("pacientes.txt", "profesionales.txt", "estudios.txt");

        System.out.println("--- INICIANDO SISTEMA DE LABORATORIO ---");
        System.out.println("Buscando archivos de persistencia...");

        // 2. Cargamos los datos desde el disco a la memoria RAM
        List<Paciente> pacientesCargados = archivoCtrl.cargarPacientes();
        List<Profesional> profesionalesCargados = archivoCtrl.cargarProfesionales();
        
        // El estudio se carga último porque necesita las listas anteriores para rearmar los vínculos
        List<Estudio> estudiosCargados = archivoCtrl.cargarEstudios(pacientesCargados, profesionalesCargados);

        // 3. Instanciamos los controladores inyectando los datos que acabamos de leer
        
        // A. Pacientes (Usamos tu constructor que recibe el objeto en blanco y la lista)
        PacienteControlador pControl = new PacienteControlador(new Paciente(), pacientesCargados);
        
        // B. Profesionales (Solución al choque de estructuras: pasamos de List a HashMap)
        ProfesionalControlador profControl = new ProfesionalControlador();
        for (Profesional prof : profesionalesCargados) {
            // Usamos tu propio método para que se agreguen al mapa usando la matrícula como clave
            profControl.registrarNuevoProfesional(
                prof.getMatricula(), 
                prof.getApellido(), 
                prof.getNombre(), 
                prof.getTelefono(), 
                prof.getMail()
            );
        }
        
        // C. Estudios
        EstudioControlador eControl = new EstudioControlador(new Estudio(), estudiosCargados);

        // Reporte de carga por consola (muy útil para depurar)
        System.out.println("\n--- REPORTE DE CARGA INICIAL ---");
        System.out.println("Pacientes cargados: " + pacientesCargados.size());
        System.out.println("Profesionales cargados: " + profControl.totalProfesionales());
        System.out.println("Estudios cargados: " + estudiosCargados.size());
        System.out.println("--------------------------------\n");

        // 4. Arrancamos la interfaz gráfica pasándole los controladores ya llenos de datos
        VentanaPrincipal ventana = new VentanaPrincipal(pControl, profControl, eControl);
        ventana.setVisible(true);
    }
}

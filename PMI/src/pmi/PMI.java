package pmi;

import Modelo.*;
import Controlador.*;
import java.util.List;
import Vista.*;

public class PMI {
    public static void main(String[] args) {
        // 1. Instanciamos los controladores
        PacienteControlador pControl = new PacienteControlador();
        ProfesionalControlador profControl = new ProfesionalControlador();
        EstudioControlador eControl = new EstudioControlador();
        
 
        // 2. Seteamos los datos uno por uno usando tus métodos
        pControl.setDniPaciente("40123456");
        pControl.setNombrePaciente("Juan");
        pControl.setApellidoPaciente("Gomez");
        pControl.setObraSocial(true);
        pControl.setTelefono("266400");
        pControl.setMail("juan@mail.com");
        
        // 3. Ahora que el objeto interno 'paciente' del controlador está lleno,
        // llamamos a tu método que lo mete en la lista maestra
        pControl.listaAgregarPaciente();
        
        System.out.println("Precarga terminada con exito.");
        
        // --- PRUEBA DE PROFESIONAL (HashMap) ---
        profControl.registrarNuevoProfesional(1010, "Roccuzzo", "Antonela", "2664", "anto@mail.com");
        
        // --- MOSTRAR RESULTADOS ---
        System.out.println("Pacientes en lista: " + pControl.getListaPaciente().size());
        System.out.println("Medico en mapa: " + profControl.buscarProfesional(1010).getNombre());
    
    
    // --- PRUEBA DE INTEGRACIÓN ---

// 1. Buscamos al profesional que cargamos antes (Antonela)
Profesional profAsignado = profControl.buscarProfesional(1010);

// 2. Buscamos al paciente (usando tu método getListaPaciente)
// Tomamos el primero de la lista para la prueba
Paciente pacAsignado = pControl.getListaPaciente().get(0);

// 3. Creamos el Estudio (Uniendo todas las piezas del Modelo)
Fecha hoy = new Fecha(3, 5, 2026);
Fecha entrega = new Fecha(10, 5, 2026);
List<Integer> codigosAnalisis = new java.util.ArrayList<>();
codigosAnalisis.add(246); // Agregamos Glucemia por código

Estudio nuevoEstudio = new Estudio(pacAsignado, profAsignado, hoy, entrega, "En elaboración", codigosAnalisis);

eControl.listaAgregarEstudio();
// 4. Verificamos que todo esté conectado
System.out.println("--- RESUMEN DEL ESTUDIO CREATIVO ---");
System.out.println("Paciente: " + nuevoEstudio.getPaciente().getApellido());
System.out.println("Médico: " + nuevoEstudio.getProfesional().getApellido());
System.out.println("Fecha Realización: " + nuevoEstudio.getRealizacion().getDia() + "/" + nuevoEstudio.getRealizacion().getMes());
    
 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
    
    // Vista jere
     
    VentanaPrincipal ventana = new VentanaPrincipal(pControl, profControl, eControl);
    ventana.setVisible(true);
    
    }




    
}

package pmi;

import Modelo.*;
import Controlador.*;

public class PMI {
    public static void main(String[] args) {
        // 1. Instanciamos los controladores
        PacienteControlador pControl = new PacienteControlador();
        ProfesionalControlador profControl = new ProfesionalControlador();
        
        
        // 2. Seteamos los datos uno por uno usando tus métodos
        pControl.setDniPaciente(40123456);
        pControl.setNombrePaciente("Juan");
        pControl.setApellidoPaciente("Gomez");
        pControl.setObraSocial(true);
        pControl.setTelefono(266400);
        pControl.setMail("juan@mail.com");
        
        // 3. Ahora que el objeto interno 'paciente' del controlador está lleno,
        // llamamos a tu método que lo mete en la lista maestra
        pControl.listaAgregarPaciente();
        
        System.out.println("Precarga terminada con exito.");
        
        // --- PRUEBA DE PROFESIONAL (HashMap) ---
        profControl.registrarNuevoProfesional(1010, "Roccuzzo", "Antonela", 2664, "anto@mail.com");
        
        // --- MOSTRAR RESULTADOS ---
        System.out.println("Pacientes en lista: " + pControl.getListaPaciente().size());
        System.out.println("Medico en mapa: " + profControl.buscarProfesional(1010).getNombre());
    }
}

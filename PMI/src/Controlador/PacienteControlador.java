
package Controlador;

import Modelo.Paciente;
import java.util.List;
import java.util.ArrayList;

public class PacienteControlador {
    
    private Paciente paciente;
    private List<Paciente> listaPaciente;
    
    //Constructores
    public PacienteControlador(){
        this.listaPaciente = new ArrayList<>();
        this.paciente = new Paciente();
    }
    
    public PacienteControlador(Paciente paciente){
        this.paciente = paciente;
    }
    
    public PacienteControlador(Paciente paciente, List<Paciente> listaPaciente) {
        this.paciente = paciente;
        this.listaPaciente = listaPaciente;
    }
    
    //Metodos de carga de pacientes
    public void setDniPaciente(String dni){
        paciente.setDni(dni);
    }
    
    public void setApellidoPaciente(String apellido){
        paciente.setApellido(apellido);
    }
    
    public void setNombrePaciente(String nombre){
        paciente.setNombre(nombre);
    }

    public void setObraSocial(boolean obraSocial) {
        paciente.setObraSocial(obraSocial);
    }
    
    public void setMail(String mail) {
        paciente.setMail(mail);
    }

    public void setTelefono(String telefono) {
        paciente.setTelefono(telefono);
    }

    //Metodos relativos a la lista de pacientes
    public void listaAgregarPaciente(){
        listaPaciente.add(paciente);
    }

    public void listaEliminarPaciente(Paciente paciente){
        listaPaciente.remove(paciente);
    }
    
    // Agregá esto en PacienteControlador.java
    public List<Paciente> getListaPaciente() {
        return listaPaciente;
}
    
    public void mostrar(){
        for(Paciente p : listaPaciente){
            if(p.isObraSocial()){
                p.toString();
            }else{
                if(!p.isObraSocial()){
                    p.toString();
                }
            }
        }
    }
    
    public void prepararNuevoPaciente() {
    this.paciente = new Paciente(); // Crea un paciente limpio para la próxima carga
}
    //Detalles
    
    //Verifica que el dni tenga en 7 u 8 caracteres 
    public boolean dniValido(String dni) {
    if (dni.length() != 7 && dni.length() != 8) {
        return false;
    }
    for (char c : dni.toCharArray()) {
        if (!Character.isDigit(c)) {
            return false;
        }
    }
    return true;
}   

    // verifica que el telefono sea valido
    public boolean telefonoValido(String telefono) { 
    // Verifica que tenga entre 8 y 15 caracteres
    if (telefono.length() < 8 || telefono.length() > 15) {
        return false;
    }
    // Verifica que solo tenga números (permite el 0 adelante)
    for (char c : telefono.toCharArray()) {
        if (!Character.isDigit(c)) {
            return false;
        }
    }
    return true;
}
    
    // Buscar paciente por su dni  (para vista)
    public Paciente buscarPacientePorDni(String dni) {
    for (Paciente p : listaPaciente) {
        if (p.getDni().equals(dni)) {
            return p;
        }
    }
    return null;
}
}


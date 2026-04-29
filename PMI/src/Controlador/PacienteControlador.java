
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
    public void setDniPaciente(int dni){
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

    public void setTelefono(int telefono) {
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
                p.mostrarPaciente();
            }else{
                if(!p.isObraSocial()){
                    p.mostrarPaciente();
                }
            }
        }
    }
}

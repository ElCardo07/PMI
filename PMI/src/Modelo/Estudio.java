package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Estudio{
    
    private Paciente paciente;           
    private Profesional profesional;     
    
    private Fecha realizacion;
    private Fecha entrega;
    private String estado;// "En elaboracion", "Finalizado", "Retirado", "Enviado"
    private List<Integer> analisis;//array de analisis porque tiene que ser mas de 1, el limite va a ser 99 por que no hay limete real para la cantidad de analisis que puede hacer una persona //preguntar ?
    
    //constructor 1
    public Estudio(Paciente paciente, Profesional profesional, Fecha realizacion, Fecha entrega, String estado, List<Integer> analisis) {
        this.paciente = paciente;
        this.profesional = profesional;
        this.realizacion = realizacion;
        this.entrega = entrega;
        this.estado = estado;
        this.analisis = analisis;
    }
    //constructor 2
    public Estudio(){
        this.paciente = new Paciente();
        this.profesional = new Profesional();
        this.realizacion = new Fecha();
        this.entrega = new Fecha();
        this.estado = "";
        this.analisis = new ArrayList<>();     
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public Fecha getRealizacion() {
        return realizacion;
    }

    public void setRealizacion(Fecha realizacion) {
        this.realizacion = realizacion;
    }

    public Fecha getEntrega() {
        return entrega;
    }

    public void setEntrega(Fecha entrega) {
        this.entrega = entrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Integer> getAnalisis() {
        return analisis;
    }

    public void setAnalisis(List<Integer> analisis) {
        this.analisis = analisis;
    }
    
    // Metodo para agregar un solo analisis sin tener que setear toda la lista de nuevo
    public void agregarAnalisisCodigo(int codigo) {
        this.analisis.add(codigo);
}

    // Metodo para saber cuantos analisis tiene este estudio
    public int cantidadAnalisis() {
        return this.analisis.size();
}
    //toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Paciente: ").append(paciente.getNombre()).append(" ").append(paciente.getApellido()).append("\n");
        sb.append("Profesional: ").append(profesional.getNombre()).append(" ").append(profesional.getApellido()).append("\n");
        sb.append("Fecha de realización: ").append(realizacion.toString()).append("\n");
        sb.append("Fecha de entrega: ").append(entrega.toString()).append("\n");
        sb.append("Estado: ").append(estado).append("\n");
        sb.append("Análisis: ");
        for (int codigo : analisis) {
            sb.append(codigo).append(" ");
        }
        return sb.toString();
    }
}





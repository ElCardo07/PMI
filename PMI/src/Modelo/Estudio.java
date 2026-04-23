/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Estudio{
    // relación con las clases que ya tenés
    private Paciente paciente;          // preguntar si esta es la forma de relacionarlos 
    private Profesional profesional;    //preguntar si esta es la forma de relacionarlos 
    
    private Fecha realizacion;
    private Fecha entrega;
    private String estado;// "En elaboracion", "Finalizado", "Retirado", "Enviado"
    private List<String> analisis;//array de analisis porque tiene que ser mas de 1, el limite va a ser 99 por que no hay limete real para la cantidad de analisis que puede hacer una persona //preguntar ?
    
    //constructor 1
    public Estudio(Paciente paciente, Profesional profesional, Fecha realizacion, Fecha entrega, String estado, List<String> analisis) {
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

    public List<String> getAnalisis() {
        return analisis;
    }

    public void setAnalisis(List<String> analisis) {
        this.analisis = analisis;
    }
}

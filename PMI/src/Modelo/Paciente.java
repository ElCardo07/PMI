/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class Paciente extends Persona {
    private String obraSocial;
    
    
    public Paciente() {
        super();
        this.obraSocial = "";
    }

    
    public Paciente(int dni, String nombre, String obraSocial) {
        super(dni, nombre);
        this.obraSocial = obraSocial;
    }

    public String getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(String obraSocial) {
        this.obraSocial = obraSocial;
    }
    
    
}

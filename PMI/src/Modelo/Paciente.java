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
   private boolean ObraSocial;
   private int dni;

   
   
   
   
   
   
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
   
    public boolean getObraSocial() {
        return ObraSocial;
    }

    public void setObraSocial(boolean ObraSocial) {
        this.ObraSocial = ObraSocial;
    }
}

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
    //variables
    private boolean obraSocial;
    private int dni;
    
    //Constructores
    public Paciente(boolean obraSocial, int dni, String apellido, String nombre, int telefono, String mail) {
        super(apellido, nombre, telefono, mail);
        this.obraSocial = obraSocial;
        this.dni = dni;
    }
    public Paciente() {   
        super();
        this.obraSocial = false;
        this.dni = 0;
    }

    //gets y sets
    public boolean isObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(boolean obraSocial) {
        this.obraSocial = obraSocial;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
    @Override
    public String toString() {
        return "Paciente:\nApellido: " + getApellido() + "\nNombre: " + getNombre() + "\nTelefono: "+ getTelefono() + "\nMail: " + getMail() + "\nObraSocial: " + obraSocial + "\nDni: " + dni;
    }
    @Override 
    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.println("\nObra social: " + obraSocial);
        System.out.println("Dni: " + dni);
    }
}

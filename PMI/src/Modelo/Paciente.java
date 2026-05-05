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
    private String dni;
    
    //Constructores
    public Paciente(boolean obraSocial, String dni, String apellido, String nombre, int telefono, String mail) {
        super(apellido, nombre, telefono, mail);
        this.obraSocial = obraSocial;
        this.dni = dni;
    }
    public Paciente() {   
        super();
        this.obraSocial = false;
        this.dni = "";
    }

    //gets y sets
    public boolean isObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(boolean obraSocial) {
        this.obraSocial = obraSocial;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    @Override
    public String toString() {
        return "Paciente:\nApellido: " + getApellido() + "\nNombre: " + getNombre() + "\nTelefono: "+ getTelefono() + "\nMail: " + getMail() + "\nObraSocial: " + obraSocial + "\nDni: " + dni;
    }
    //muestra los datos de paciente, conecta los datos de persona y paciente(obrasocial y dni) con el super para mostrar todo junto
    @Override 
    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.println("\nObra social: " + obraSocial);
        System.out.println("Dni: " + dni);
    }
    
    //muestro un paciente
    public void mostrarPaciente() {
        System.out.println("Dni: " + dni);
        System.out.println("Apellido: " + getApellido());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Telefono : " + getTelefono());
        System.out.println("Mail: " + getMail());
        if(obraSocial){
            System.out.println("Obra social: Si");
        }else{
            System.out.println("Obra social: No");
        }
    }
}

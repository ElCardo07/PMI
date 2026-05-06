/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Profesional extends Persona {
    
   //Variables
    private int matricula;

    //Constructores
    public Profesional(int matricula, String apellido, String nombre, String telefono, String mail) {
        super(apellido, nombre, telefono, mail);
        this.matricula = matricula;
    }
    
    public Profesional() {    
        matricula = 0;
    }

    //Gets y sets
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    //toString
    @Override
    public String toString() {
        return "\nMatricula: " + matricula;
    }
    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Matricula: "+ matricula);
    }
    
}

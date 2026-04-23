/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class Profesional extends Persona {
    
   private int matricula;

    public Profesional(int matricula, String apellido, String nombre, int telefono, String mail) {
        super(apellido, nombre, telefono, mail);
        this.matricula = matricula;
    }

    public Profesional(int matricula) {
        this.matricula = matricula;
    }
   
   
    

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    
    
}

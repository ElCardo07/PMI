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

   
   public Profesional() {
        super();
        this.matricula = 0;
    }
   
   
    public Profesional(int matricula, int dni, String nombre) {
        super(dni, nombre);
        this.matricula = matricula;
    
            }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Fecha {
    private int dia;
    private int mes;
    private int anio;

    // constructor por defecto
    public Fecha() {
        this.dia = 0;
        this.mes = 0;
        this.anio = 0;
    }
    
    // constructor con parámetros
    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }
    

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    
    public int cantDias(Fecha d){
        int diasFecha1 = (this.anio * 365) + (this.mes * 30) + this.dia;
        int diasFecha2 = (d.getAnio() * 365) + (d.getMes() * 30) + d.getDia();
        
        return Math.abs(diasFecha1 - diasFecha2);
    }

    @Override
    public String toString() {
        return "Fecha: " + dia + "/" + mes + "/" + anio;
    }
   
   
    public boolean esIgual(Fecha otraFecha) {
    return this.dia == otraFecha.getDia() && 
           this.mes == otraFecha.getMes() && 
           this.anio == otraFecha.getAnio();
}
    
}
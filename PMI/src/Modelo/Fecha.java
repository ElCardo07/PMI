/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Fecha {
    private int dia;
    private int mes;
    private int año;

    // constructor por defecto
    public Fecha() {
        this.dia = 1;
        this.mes = 1;
        this.año = 2000;
    }
    
    // constructor con parámetros
    public Fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
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

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }
    
    public int cantDias(Fecha d){
        int diasFecha1 = (this.año * 365) + (this.mes * 30) + this.dia;
        int diasFecha2 = (d.getAño() * 365) + (d.getMes() * 30) + d.getDia();
        
        return Math.abs(diasFecha1 - diasFecha2);
    }

    @Override
    public String toString() {
        return "Fecha: " + dia + "/" + mes + "/" + año;
    }
    
}
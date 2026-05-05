package Controlador;

import Modelo.Estudio;
import Modelo.Paciente;
import Modelo.Profesional;

import java.io.BufferedWriter;
import java.io.File; //crea archivos verifica si existen
import java.io.FileNotFoundException; //da exception cuando el archivo no existe
import java.io.FileWriter; //escribir en archivos
import java.io.IOException; //da error si no entra ni sale del archivo
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException; //error cuando queres leer algo q no existe
import java.util.Scanner;

public class ArchivoControlador{
    private String nombreDeArchivoPa;
    private String nombreDeArchivoPr;
    private String nombreDeArchivoEs;
    
    public ArchivoControlador() {}

    public ArchivoControlador(String nombreDeArchivoPa, String nombreDeArchivoPr, String nombreDeArchivoEs) {
        this.nombreDeArchivoPa = nombreDeArchivoPa;
        this.nombreDeArchivoPr = nombreDeArchivoPr;
        this.nombreDeArchivoEs = nombreDeArchivoEs;
    }
    
    //hacer en una linea un paciente
    private String construirLineaPaciente(Paciente p){
        return p.getNombre() + ";" + p.getApellido() + ";" + p.getDni() + ";" + p.getTelefono() + ";" + p.getMail() + ";" + p.isObraSocial();
    }
    
    public void guardarPaciente(List<Paciente> listaPaciente){
        System.out.println("Debug: Ruta del archivo: " + nombreDeArchivoPa); //verifica la ruta
        System.out.println("Debug: Tamaño de listaPaciente: " + listaPaciente.size());
        
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(nombreDeArchivoPa))){
            
            System.out.println("Debug: Iniciando escritura de pacientes... "); //verifica q el bucle se ejecuta
            
            for(Paciente p: listaPaciente){
                String linea = construirLineaPaciente(p);
                System.out.println("Debug: linea a escribir: " + linea);
                
                writer.write(linea);
                writer.newLine();
                writer.flush();
            }
            System.out.println("Debug: Archivo guardado correctamente.");
        }catch(IOException e){
            System.err.println("Error crítico al guardar:");
            e.printStackTrace();
        }
    }
    
    //hacer linea un profesional
    private String construirLineaProfesional(Profesional p){
        return p.getNombre() + ";" + p.getApellido() + ";" + p.getTelefono() + ";" + p.getMail() + ";" + p.getMatricula();
    }
    
    public void guardarProfesional(List<Profesional> listaProfesional){
        System.out.println("Debug: Ruta del archivo: " + nombreDeArchivoPr); //verifica la ruta
        System.out.println("Debug: Tamaño de listaProfecional: " + listaProfesional.size());
        
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(nombreDeArchivoPr))){
            
            System.out.println("Debug: Iniciando escritura de profesional... "); //verifica q el bucle se ejecuta
            
            for(Profesional p: listaProfesional){
                String linea = construirLineaProfesional(p);
                System.out.println("Debug: linea a escribir: " + linea);
                
                writer.write(linea);
                writer.newLine();
                writer.flush();
            }
            System.out.println("Debug: Archivo guardado correctamente.");
        }catch(IOException e){
            System.err.println("Error crítico al guardar:");
            e.printStackTrace();
        }
    }
    
    //hacer linea un estudio
    private String construirLineaEstudio(Estudio es){
        return es.getRealizacion() + ";" + es.getEntrega() + ";" + es.getEstado() + ";" + es.getAnalisis();
    }
    
    public void guardarEstudio(List<Estudio> listaEstudio){
        System.out.println("Debug: Ruta del archivo: " + nombreDeArchivoEs); //verifica la ruta
        System.out.println("Debug: Tamaño de listaEstudio: " + listaEstudio.size());
        
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(nombreDeArchivoEs))){
            
            System.out.println("Debug: Iniciando escritura de estudio... "); //verifica q el bucle se ejecuta
            
            for(Estudio es: listaEstudio){
                String linea = construirLineaEstudio(es);
                System.out.println("Debug: linea a escribir: " + linea);
                
                writer.write(linea);
                writer.newLine();
                writer.flush();
            }
            System.out.println("Debug: Archivo guardado correctamente.");
        }catch(IOException e){
            System.err.println("Error crítico al guardar:");
            e.printStackTrace();
        }
    }
    
    
    
}

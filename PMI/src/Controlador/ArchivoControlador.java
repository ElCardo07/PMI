package Controlador;

import Modelo.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoControlador {
    private String nombreDeArchivoPa;
    private String nombreDeArchivoPr;
    private String nombreDeArchivoEs;

    public ArchivoControlador(String nombreDeArchivoPa, String nombreDeArchivoPr, String nombreDeArchivoEs) {
        this.nombreDeArchivoPa = nombreDeArchivoPa;
        this.nombreDeArchivoPr = nombreDeArchivoPr;
        this.nombreDeArchivoEs = nombreDeArchivoEs;
    }

    // ==========================================
    // SECCIÓN PACIENTES 
    // ==========================================
    
    public void guardarPacientes(List<Paciente> listaPaciente) {
        File escribir = new File(nombreDeArchivoPa);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(escribir))) {
            for (Paciente p : listaPaciente) {
                bw.append(p.isObraSocial() + "\n");
                bw.append(p.getDni() + "\n"); // Se guarda directamente
                bw.append(p.getApellido() + "\n");
                bw.append(p.getNombre() + "\n");
                bw.append(p.getTelefono() + "\n");
                bw.append(p.getMail() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error al guardar pacientes: " + e.getMessage());
        }
    }

    public List<Paciente> cargarPacientes() {
        List<Paciente> lista = new ArrayList<>();
        File f = new File(nombreDeArchivoPa);
        if (!f.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                boolean obra = Boolean.parseBoolean(linea);
                String dni = br.readLine(); // Leemos el DNI como String directamente
                String apellido = br.readLine();
                String nombre = br.readLine();
                String tel = br.readLine();
                String mail = br.readLine();

                lista.add(new Paciente(obra, dni, apellido, nombre, tel, mail));
            }
        } catch (IOException e) {
            System.err.println("Error al cargar pacientes");
        }
        return lista;
    }

    // ==========================================
    // SECCIÓN PROFESIONALES
    // ==========================================

    public void guardarProfesionales(List<Profesional> listaProfesional) {
        File escribir = new File(nombreDeArchivoPr);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(escribir))) {
            for (Profesional p : listaProfesional) {
                bw.append(p.getNombre() + "\n");
                bw.append(p.getApellido() + "\n");
                bw.append(p.getTelefono() + "\n");
                bw.append(p.getMail() + "\n");
                bw.append(p.getMatricula() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error al guardar profesionales");
        }
    }

    public List<Profesional> cargarProfesionales() {
        List<Profesional> lista = new ArrayList<>();
        File f = new File(nombreDeArchivoPr);
        if (!f.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String nom;
            while ((nom = br.readLine()) != null) {
                String ape = br.readLine();
                String tel = br.readLine();
                String mail = br.readLine();
                int mat = Integer.parseInt(br.readLine());

                lista.add(new Profesional(mat, ape, nom, tel, mail));
            }
        } catch (IOException e) {
            System.err.println("Error al cargar profesionales");
        }
        return lista;
    }

    // ==========================================
    // SECCIÓN ESTUDIOS
    // ==========================================

    public void guardarEstudios(List<Estudio> listaEstudio) {
        File escribir = new File(nombreDeArchivoEs);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(escribir))) {
            for (Estudio es : listaEstudio) {
                // 1. IDs para la vinculación
                bw.append(es.getPaciente().getDni() + "\n");
                bw.append(es.getProfesional().getMatricula() + "\n");
                
                // 2. Fecha de Realización (3 líneas)
                bw.append(es.getRealizacion().getDia() + "\n");
                bw.append(es.getRealizacion().getMes() + "\n");
                bw.append(es.getRealizacion().getAnio() + "\n");
                
                // 3. Fecha de Entrega (3 líneas)
                bw.append(es.getEntrega().getDia() + "\n");
                bw.append(es.getEntrega().getMes() + "\n");
                bw.append(es.getEntrega().getAnio() + "\n");
                
                // 4. Estado
                bw.append(es.getEstado() + "\n");
                
                // 5. Análisis (Guardamos los códigos separados por coma en una sola línea)
                String codigos = "";
                for (Integer cod : es.getAnalisis()) {
                    codigos += cod + ",";
                }
                if (codigos.isEmpty()) {
                    bw.append("vacio\n");
                } else {
                    bw.append(codigos + "\n");
                }
            }
        } catch (IOException e) {
            System.err.println("Error al guardar estudios");
        }
    }

    public List<Estudio> cargarEstudios(List<Paciente> pacientesCargados, List<Profesional> profesionalesCargados) {
        List<Estudio> lista = new ArrayList<>();
        File f = new File(nombreDeArchivoEs);
        if (!f.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String dniBuscado;
            
            while ((dniBuscado = br.readLine()) != null) {
                int matBuscada = Integer.parseInt(br.readLine());
                
                // Reconstruimos Fecha Realización
                int rDia = Integer.parseInt(br.readLine());
                int rMes = Integer.parseInt(br.readLine());
                int rAnio = Integer.parseInt(br.readLine());
                Fecha realizacion = new Fecha(rDia, rMes, rAnio);
                
                // Reconstruimos Fecha Entrega
                int eDia = Integer.parseInt(br.readLine());
                int eMes = Integer.parseInt(br.readLine());
                int eAnio = Integer.parseInt(br.readLine());
                Fecha entrega = new Fecha(eDia, eMes, eAnio);

                String estado = br.readLine();
                
                // Reconstruimos la lista de Análisis
                String lineaAnalisis = br.readLine();
                List<Integer> analisis = new ArrayList<>();
                if (!lineaAnalisis.equals("vacio")) {
                    String[] partes = lineaAnalisis.split(",");
                    for (String parte : partes) {
                        if (!parte.isEmpty()) {
                           analisis.add(Integer.valueOf(parte));
                        }
                    }
                }

                // --- LÓGICA DE VINCULACIÓN ---
                Paciente pacEncontrado = null;
                for (Paciente p : pacientesCargados) {
                    if (p.getDni().equals(dniBuscado)) {
                        pacEncontrado = p;
                        break; 
                    }
                }

                Profesional profEncontrado = null;
                for (Profesional pr : profesionalesCargados) {
                    if (pr.getMatricula() == matBuscada) {
                        profEncontrado = pr;
                        break;
                    }
                }

                // Si todo está correcto, creamos el estudio con el orden exacto de tu constructor
                if (pacEncontrado != null && profEncontrado != null) {
                    Estudio nuevoEstudio = new Estudio(pacEncontrado, profEncontrado, realizacion, entrega, estado, analisis);
                    lista.add(nuevoEstudio);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar estudios: " + e.getMessage());
        }
        return lista;
    }

}

/*
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
    
    
    
}*/

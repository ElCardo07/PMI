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

    // Seccion pacientes 
    
    public void guardarPacientes(List<Paciente> listaPaciente) {
        File escribir = new File(nombreDeArchivoPa);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(escribir))) {
            for (Paciente p : listaPaciente) {
                bw.append(p.isObraSocial() + "\n");
                bw.append(p.getDni() + "\n"); 
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
                String dni = br.readLine(); 
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

    // Seccion profesionales

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
               
                
                // Leemos la línea y la convertimos 
                int mat = convertirAEntero(br.readLine());

                lista.add(new Profesional(mat, ape, nom, tel, mail));
            }
        } catch (IOException e) {
            System.err.println("Error al cargar profesionales");
        }
        return lista;
    }

    // Seccion estudios

    public void guardarEstudios(List<Estudio> listaEstudio) {
        File escribir = new File(nombreDeArchivoEs);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(escribir))) {
            for (Estudio es : listaEstudio) {
                
                bw.append(es.getPaciente().getDni() + "\n");
                bw.append(es.getProfesional().getMatricula() + "\n");
                
                bw.append(es.getRealizacion().getDia() + "\n");
                bw.append(es.getRealizacion().getMes() + "\n");
                bw.append(es.getRealizacion().getAnio() + "\n");
                
                bw.append(es.getEntrega().getDia() + "\n");
                bw.append(es.getEntrega().getMes() + "\n");
                bw.append(es.getEntrega().getAnio() + "\n");
                
                bw.append(es.getEstado() + "\n");
                
                //Análisis (Guardamos los códigos separados por coma en una sola línea)
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
                
                //convertimos
                int matBuscada = convertirAEntero(br.readLine());
                
                // Crea una fecha para realización
                int rDia = Integer.parseInt(br.readLine());
                int rMes = Integer.parseInt(br.readLine());
                int rAnio = Integer.parseInt(br.readLine());
                Modelo.Fecha realizacion = new Modelo.Fecha(rDia, rMes, rAnio);
                
                // Crea una fecha para entrega 
                int eDia = Integer.parseInt(br.readLine());
                int eMes = Integer.parseInt(br.readLine());
                int eAnio = Integer.parseInt(br.readLine());
                Modelo.Fecha entrega = new Modelo.Fecha(eDia, eMes, eAnio);

                String estado = br.readLine();
                
                // Crea una lista de Análisis
                String lineaAnalisis = br.readLine();
                List<Integer> analisis = new ArrayList<>();
                if (!lineaAnalisis.equals("vacio")) {
                    String[] partes = lineaAnalisis.split(",");
                    for (String parte : partes) {
                        if (!parte.trim().isEmpty()) {
                            // --- REGLA DEL PROFE: Código NO es fecha, usamos método propio ---
                            analisis.add(convertirAEntero(parte));
                        }
                    }
                }

                // Busca paciente por dni
                Modelo.Paciente pacEncontrado = null;
                for (Modelo.Paciente p : pacientesCargados) {
                    if (p.getDni().equals(dniBuscado)) {
                        pacEncontrado = p;
                        break; 
                    }
                }
                
                // Busca profesional por matricula
                Modelo.Profesional profEncontrado = null;
                for (Modelo.Profesional pr : profesionalesCargados) {
                    if (pr.getMatricula() == matBuscada) {
                        profEncontrado = pr;
                        break;
                    }
                }

                // Si todo está bien se crea el estudio con el orden exacto del constructor
                if (pacEncontrado != null && profEncontrado != null) {
                    Modelo.Estudio nuevoEstudio = new Modelo.Estudio(pacEncontrado, profEncontrado, realizacion, entrega, estado, analisis);
                    lista.add(nuevoEstudio);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar estudios: " + e.getMessage());
        }
        return lista;
    }
    
    private int convertirAEntero(String texto) {
        int numero = 0;
        // Evitamos espacios en blanco extraños que puedan venir del archivo de texto
        texto = texto.trim(); 
        for (int i = 0; i < texto.length(); i++) {
            char digito = texto.charAt(i);
            numero = (numero * 10) + (digito - '0');
        }
        return numero;
    }

}
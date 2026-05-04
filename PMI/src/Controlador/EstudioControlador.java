package Controlador;

import Modelo.Estudio;
import Modelo.Fecha;
import Modelo.Paciente;
import Modelo.Profesional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EstudioControlador {

    private Estudio estudio;
    private List<Estudio> listaEstudios;
    private Map<Integer, String> catalogo;

    // Constructores 

    public EstudioControlador() {//controlador vasio
        this.estudio = new Estudio();
        this.listaEstudios = new ArrayList<>();
        this.catalogo = new HashMap<>();
        cargarCatalogo();
    }

    public EstudioControlador(Estudio estudio) {//Constructor con estudiante
        this.estudio = estudio;
        this.listaEstudios = new ArrayList<>();
        this.catalogo = new HashMap<>();
        cargarCatalogo();
    }

    public EstudioControlador(Estudio estudio, List<Estudio> listaEstudios) {//Constructor con estudiante y lista de estudiante
        this.estudio = estudio;
        this.listaEstudios = listaEstudios;
        this.catalogo = new HashMap<>();
        cargarCatalogo();
    }

    private void cargarCatalogo() {
        catalogo.put(246, "Glucemia");
        catalogo.put(135, "Hemograma");
        catalogo.put(468, "Colesterol");
        catalogo.put(357, "Orina Completa");
        catalogo.put(680, "Perfil Hepático");
        catalogo.put(579, "Creatinina");
        catalogo.put(802, "Plaquetas");
        catalogo.put(791, "Tiroides");
        catalogo.put(242,  "Ferritina");
        catalogo.put(913, "Insulina");
    }
    
    
    // Setters del estudio interno 
    public void setPaciente(Paciente paciente) {
        estudio.setPaciente(paciente);
    }
    public void setProfesional(Profesional profesional) {
        estudio.setProfesional(profesional);
    }
    public void setFechaRealizacion(Fecha fecha) {
        estudio.setRealizacion(fecha);
    }
    public void setFechaEntrega(Fecha fecha) {
        estudio.setEntrega(fecha);
    }
    public void setEstado(String estado) {
        estudio.setEstado(estado);
    }
    public void agregarAnalisis(int codigo) {
        estudio.agregarAnalisisCodigo(codigo);
    }

    
    //  Geters del estudio interno 
    public Paciente getPaciente() {
        return estudio.getPaciente();
    }
    public Profesional getProfesional() {
        return estudio.getProfesional();
    }
    public Fecha getFechaRealizacion() {
        return estudio.getRealizacion();
    }
    public Fecha getFechaEntrega() {
        return estudio.getEntrega();
    }
    public String getEstado() {
        return estudio.getEstado();
    }
    public List<Integer> getAnalisis() {
        return estudio.getAnalisis();
    }
    public List<Estudio> getListaEstudios() {
        return listaEstudios;
    }

    
    // Metodos de la lista 

    public void listaAgregarEstudio() {
        listaEstudios.add(estudio);
    }

    public void listaEliminarEstudio(Estudio e) {
        listaEstudios.remove(e);
    }

    public void prepararNuevoEstudio() {
        this.estudio = new Estudio();
    }
    
    // Catálogo 

    public boolean existeCodigo(int codigo) {
        return catalogo.containsKey(codigo);
    }

    public String obtenerNombre(int codigo) {
        return catalogo.get(codigo);
    }

    public Map<Integer, String> getCatalogo() {
        return catalogo;
    }
    
    // Consultas del TP
    
    public int cant_estudio_paciente(int dniBuscado){ // devuelve la cantidad de estudio que hizo un paciente para poder mostrarlo en vista
        
        int cant = 0;
        
        for(Estudio e: listaEstudios){
            if(e.getPaciente().getDni() == dniBuscado){
               cant++;
            }
        }
        return cant;
    }
    
    public List<Estudio> obtenerEstudiosPorEstado(String estado) {// Devuelve los estudios de un estado pasado por parametro
        List<Estudio> resultado = new ArrayList<>();
        for (Estudio e : listaEstudios) {
            if (e.getEstado().equalsIgnoreCase(estado)) {
                resultado.add(e);
            }
        }
        return resultado;
    }
    
    public List<Estudio> filtrarPorProfesional(int matricula) {// Filtar por profesional
    List<Estudio> filtrados = new ArrayList<>();
    for (Estudio e : listaEstudios) {
        // Comparamos la matrícula del profesional del estudio con la que buscamos
        if (e.getProfesional().getMatricula() == matricula) {
            filtrados.add(e);
        }
    }
    return filtrados;
}

    public List<Estudio> filtrarEstudiosPorFecha(Fecha fechaBuscada) {// Filtrar estudios por fecha
    List<Estudio> filtrados = new ArrayList<>();
    
    for (Estudio e : listaEstudios) {
        // Usamos el método que creamos en la clase Fecha
        if (e.getRealizacion().esIgual(fechaBuscada)) {
            filtrados.add(e);
        }
    }
    return filtrados;
}

}


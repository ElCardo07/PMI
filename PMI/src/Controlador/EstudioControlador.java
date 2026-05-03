package Controlador;

import Modelo.Estudio;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EstudioControlador {
    private Map<Integer, String> catalogo = new HashMap<>();
    
    //Analisis
    private List<Estudio> listaEstudios = new ArrayList<>();

    public EstudioControlador() {
       //Carga de analisis
        catalogo.put(246, "Glucemia");
        catalogo.put(135, "Hemograma");
        catalogo.put(468, "Colesterol");
        catalogo.put(357, "Orina Completa");
        catalogo.put(680, "Perfil Hepático");
        catalogo.put(579, "Creatinina");
        catalogo.put(802, "Plaquetas");
        catalogo.put(791, "Tiroides");
        catalogo.put(024, "Ferritina");
        catalogo.put(913, "Insulina");
    }
    public List<Estudio> getListaEstudios() {
        return listaEstudios;
    }

    //////////////////////////METODOS//////////////////////////////////
    
    public void agregarEstudio(Estudio nuevo) {
        this.listaEstudios.add(nuevo);
    }
    
    public boolean existeCodigo(int codigo) {
        return catalogo.containsKey(codigo);
    }

    public String obtenerNombre(int codigo) {
        return catalogo.get(codigo);
    }
}


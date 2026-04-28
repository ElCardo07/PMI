package Controlador;
import java.util.HashMap;
import java.util.Map;


public class EstudioControlador {
    private Map<Integer, String> catalogo = new HashMap<>();

    
    public EstudioControlador () {
        // Carga inicial
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

    // Método fácil para que el Paciente "vea" el catálogo
    public boolean existeCodigo(int codigo) {
        return catalogo.containsKey(codigo);
    }

    // Método para obtener el nombre real del análisis
    public String obtenerNombre(int codigo) {
        return catalogo.get(codigo);
    }
}



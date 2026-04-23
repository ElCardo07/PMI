
package Controlador;
import java.util.HashMap;
import java.util.Map;
public class AnalisisControlador {
    private Map<String, String> catalogo = new HashMap<>();

    public AnalisisControlador() {
        // Carga inicial
        catalogo.put("GLU", "Glucemia");
        catalogo.put("HEM", "Hemograma");
        catalogo.put("CHO", "Colesterol");
        catalogo.put("URI", "Orina Completa");
        catalogo.put("HEP", "Perfil Hepático");
        catalogo.put("CRE", "Creatinina");
        catalogo.put("PLA", "Plaquetas");
        catalogo.put("TCH", "Tiroides");
        catalogo.put("FER", "Ferritina");
        catalogo.put("INS", "Insulina");
    }

    // Método fácil para que el Paciente "vea" el catálogo
    public boolean existeCodigo(String codigo) {
        return catalogo.containsKey(codigo);
    }

    // Método para obtener el nombre real del análisis
    public String obtenerNombre(String codigo) {
        return catalogo.get(codigo);
    }
}


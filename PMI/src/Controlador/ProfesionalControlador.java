
package Controlador;

import Modelo.Profesional;
import java.util.HashMap;
import java.util.Map;

public class ProfesionalControlador {
    
    private final Map<Integer, Profesional> mapaProfesionales = new HashMap<>();

    // Este es el método que vas a usar desde la Vista
    public void registrarNuevoProfesional(int matricula, String apellido, String nombre, int telefono, String mail) {
        
        // 1. Creamos la instancia del Modelo con los datos que nos pasaron
        Profesional nuevoPro = new Profesional(matricula, apellido, nombre, telefono, mail);
        
        // 2. Lo registramos en el HashMap usando la matrícula como CLAVE
        mapaProfesionales.put(matricula, nuevoPro);
        
        System.out.println("Profesional " + nombre + " registrado con éxito.");
    }
    
    // Método para buscar un médico (esto quita el aviso de "never read")
    public Profesional buscarProfesional(int matricula) {
        return mapaProfesionales.get(matricula);
    }

    // Método para saber cuántos médicos hay registrados
    public int totalProfesionales() {
        return mapaProfesionales.size();
    }
}

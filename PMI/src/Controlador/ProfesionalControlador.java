
package Controlador;

import Modelo.Profesional;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;



public class ProfesionalControlador {
    
    private final Map<Integer, Profesional> mapaProfesionales = new HashMap<>();

    // Este es el método que vas a usar desde la Vista
    public void registrarNuevoProfesional(int matricula, String apellido, String nombre, String telefono, String mail) {
        
        // 1. Creamos la instancia del Modelo con los datos que nos pasaron
        Profesional nuevoPro = new Profesional(matricula, apellido, nombre, telefono, mail);
        
        // 2. Lo registramos en el HashMap usando la matrícula como CLAVE
        mapaProfesionales.put(matricula, nuevoPro);
        
        System.out.println("Profesional " + nombre + " registrado con exito.");
    }
    
    // Método para buscar un médico (esto quita el aviso de "never read")
    public Profesional buscarProfesional(int matricula) {
        return mapaProfesionales.get(matricula);
    }

    // Método para saber cuántos médicos hay registrados
    public int totalProfesionales() {
        return mapaProfesionales.size();
    }
    
    public boolean telefonoValido(String telefono) { // verifica que el telefono sea valido
    // Verifica que tenga entre 8 y 15 caracteres
    if (telefono.length() < 8 || telefono.length() > 15) {
        return false;
    }
    // Verifica que solo tenga números (permite el 0 adelante)
    for (char c : telefono.toCharArray()) {
        if (!Character.isDigit(c)) {
            return false;
        }
    }
    return true;
}
        public List<Profesional> getListaProfesionales() {
        return new ArrayList<>(mapaProfesionales.values());
    }
   public void eliminarProfesional(int matricula) {
        mapaProfesionales.remove(matricula);
    }
}


package Controlador;

import Modelo.Profesional;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;



public class ProfesionalControlador {
    
    private final Map<Integer, Profesional> mapaProfesionales = new HashMap<>();

    // Este es el metodo que se usa en la vista
    public void registrarNuevoProfesional(int matricula, String apellido, String nombre, String telefono, String mail) {
        
        // Crea la instancia del modelo 
        Profesional nuevoPro = new Profesional(matricula, apellido, nombre, telefono, mail);
        
        //  Se agrega en el HashMap usando la matricula como clave
        mapaProfesionales.put(matricula, nuevoPro);
        
        System.out.println("Profesional " + nombre + " registrado con exito.");
    }
    
    // Metodo para buscar un profesional
    public Profesional buscarProfesional(int matricula) {
        return mapaProfesionales.get(matricula);
    }

    // Metodo para saber cuantos profesionales hay registrados
    public int totalProfesionales() {
        return mapaProfesionales.size();
    }
    
    // Verifica que el telefono sea valido
    public boolean telefonoValido(String telefono) { 
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

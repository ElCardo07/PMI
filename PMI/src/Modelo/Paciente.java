package Modelo;

public class Paciente extends Persona {
    //variables
    private boolean obraSocial;
    private String dni;
    
    //Constructores
    public Paciente(boolean obraSocial, String dni, String apellido, String nombre, String telefono, String mail) {
        super(apellido, nombre, telefono, mail);
        this.obraSocial = obraSocial;
        this.dni = dni;
    }
    public Paciente() {   
        super();
        this.obraSocial = false;
        this.dni = "";
    }

    //gets y sets
    public boolean isObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(boolean obraSocial) {
        this.obraSocial = obraSocial;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    @Override
    public String toString() {
        // Usamos una variable auxiliar para traducir el booleano a texto
        String textoObraSocial;
        if (this.obraSocial) {
            textoObraSocial = "Sí";
        } else {
            textoObraSocial = "No";
        }
        
        return "Paciente:\n" +
               "Apellido: " + getApellido() + "\n" +
               "Nombre: " + getNombre() + "\n" +
               "Telefono: "+ getTelefono() + "\n" +
               "Mail: " + getMail() + "\n" +
               "Obra Social: " + textoObraSocial + "\n" +
               "Dni: " + dni;
    }

    
}
   


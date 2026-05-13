package Modelo;

public class Profesional extends Persona {
    
   //Variables
    private int matricula;

    //Constructores
    public Profesional(int matricula, String apellido, String nombre, String telefono, String mail) {
        super(apellido, nombre, telefono, mail);
        this.matricula = matricula;
    }
    
    public Profesional() {    
        matricula = 0;
    }

    //Gets y sets
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    //toString
    @Override
    
    public String toString() {
        return "Profesional:\n" +
               "Apellido: " + getApellido() + "\n" +
               "Nombre: " + getNombre() + "\n" +
               "Telefono: " + getTelefono() + "\n" +
               "Mail: " + getMail() + "\n" +
               "Matricula: " + matricula;
    }
    
    
}

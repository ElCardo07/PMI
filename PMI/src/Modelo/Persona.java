package Modelo;

public abstract class Persona {
    
    private String apellido;
    private String nombre;
    private int telefono;
    private String mail;

    public Persona(String apellido, String nombre, int telefono, String mail) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono = telefono;
        this.mail = mail;
    }

   public Persona (){
       this.apellido = "";
       this.mail = "";
       this.nombre= "";
       this.telefono = 0;
       
   }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Apellido: " + apellido + "\nNombre: " + nombre + "\nNumero de telefono: "+ telefono + "\nMain: " + mail;
    }
    public void mostrarDatos() {
    System.out.println(this.toString());
    // o simplemente: System.out.println(this);
    
    
}  
}
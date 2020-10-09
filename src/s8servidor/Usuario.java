package s8servidor;

public class Usuario {
 
    private String nombre;
    //CONSTRUCTOR

    public Usuario(String nombre) {
    	super();
        this.nombre = nombre;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

package s8servidor;


public class Usuario {
    private String nombre;
    private String type = "usser";


    //CONSTRUCTOR

    public Usuario(String nombre) {
        this.nombre = nombre;

    }


    //ATRIBUTOS


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

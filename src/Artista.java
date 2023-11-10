public class Artista {

    private String nombre;
    private String nacionalidad;
    private  int edad;
    Artista sig;

    public Artista(String nombre, String nacionalidad, int edad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.sig = null;
    }

    public Artista() {
        this.nombre = "";
        this.nacionalidad = "";
        this.edad = 0;
        this.sig = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Artista getSig() {
        return sig;
    }

    public void setSig(Artista sig) {
        this.sig = sig;
    }

    @Override
    public String toString() {
        return "\nNombre: " + nombre +
                "\nNacionalidad: " + nacionalidad +
                "\nEdad: " + edad;
    }
}

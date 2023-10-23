public class Artista {

    private String nombre;
    private String nacionalidad;
    private  String fecha;
    Artista sig;

    public Artista(String nombre, String nacionalidad, String fecha) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fecha = fecha;
        this.sig = null;
    }

    public Artista() {
        this.nombre = "";
        this.nacionalidad = "";
        this.fecha = "";
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Artista getSig() {
        return sig;
    }

    public void setSig(Artista sig) {
        this.sig = sig;
    }

    @Override
    public String toString() {
        return "Artista{" +
                "nombre='" + nombre + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", fecha='" + fecha + '\'' +
                ", sig=" + sig +
                '}';
    }
}

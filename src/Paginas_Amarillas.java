public class Paginas_Amarillas {

    Paginas_Amarillas anterior;
    private String nombre;
    private String direccion;
    private String telefono;
    Paginas_Amarillas siguiente;

    public Paginas_Amarillas(String nombre, String direccion, String telefono) {
        this.anterior = null;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.siguiente = null;
    }

    public Paginas_Amarillas() {
        this.anterior = null;
        this.nombre = "";
        this.direccion = "";
        this.telefono = "";
        this.siguiente = null;
    }

    public Paginas_Amarillas getAnterior() {
        return anterior;
    }

    public void setAnterior(Paginas_Amarillas anterior) {
        this.anterior = anterior;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Paginas_Amarillas getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Paginas_Amarillas siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "Paginas_Amarillas{" +
                "anterior=" + anterior +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", siguiente=" + siguiente +
                '}';
    }
}

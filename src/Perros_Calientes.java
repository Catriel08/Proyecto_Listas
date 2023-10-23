public class Perros_Calientes {

    private String nombre;
    private String nacionalidad;
    private double peso;
    private double velocidadIngestion;
    private int perrosConsumidos;
    private String categoria;
    Perros_Calientes siguiente;

    public Perros_Calientes(String nombre, String nacionalidad, double peso, double velocidadIngestion, int perrosConsumidos, String categoria) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.peso = peso;
        this.velocidadIngestion = velocidadIngestion;
        this.perrosConsumidos = perrosConsumidos;
        this.categoria = categoria;
        this.siguiente = null;
    }

    public Perros_Calientes() {
        this.nombre = "";
        this.nacionalidad = "";
        this.peso = 0;
        this.velocidadIngestion = 0;
        this.perrosConsumidos = 0;
        this.categoria = "";
        this.siguiente = null;
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getVelocidadIngestion() {
        return velocidadIngestion;
    }

    public void setVelocidadIngestion(double velocidadIngestion) {
        this.velocidadIngestion = velocidadIngestion;
    }

    public int getPerrosConsumidos() {
        return perrosConsumidos;
    }

    public void setPerrosConsumidos(int perrosConsumidos) {
        this.perrosConsumidos = perrosConsumidos;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Perros_Calientes getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Perros_Calientes siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "Perros_Calientes{" +
                "nombre='" + nombre + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", peso=" + peso +
                ", velocidadIngestion=" + velocidadIngestion +
                ", perrosConsumidos=" + perrosConsumidos +
                ", categoria='" + categoria + '\'' +
                ", siguiente=" + siguiente +
                '}';
    }
}

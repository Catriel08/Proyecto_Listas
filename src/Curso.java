public class Curso {

    Curso anterior;
    private int codigo;
    private String asignatura;
    private double nota;
    Curso siguiente;

    public Curso(int codigo, String asignatura, double nota) {
        this.anterior = null;
        this.codigo = codigo;
        this.asignatura = asignatura;
        this.nota = nota;
        this.siguiente = null;
    }

    public Curso() {
        this.anterior = null;
        this.codigo = 0;
        this.asignatura = "";
        this.nota = 0;
        this.siguiente = null;
    }

    public Curso getAnterior() {
        return anterior;
    }

    public void setAnterior(Curso anterior) {
        this.anterior = anterior;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Curso getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Curso siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "anterior=" + anterior +
                ", codigo=" + codigo +
                ", asignatura='" + asignatura + '\'' +
                ", nota=" + nota +
                ", siguiente=" + siguiente +
                '}';
    }
}

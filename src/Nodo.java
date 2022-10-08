public class Nodo implements Cloneable{
    private final Object informacionDelNodo;
    private Nodo siguienteNodo;

    public Nodo(Object informacionDelNodo, Nodo siguienteNodo) {
        this.informacionDelNodo = informacionDelNodo;
        this.siguienteNodo = siguienteNodo;
    }

    public Nodo(Object objeto) {
        this.informacionDelNodo = objeto;
    }

    public Nodo obtenerSiguienteNodo() {
        return siguienteNodo;
    }

    public Object obtenerObjeto() {
        return informacionDelNodo;
    }

    public void borrarSiguienteNodo() {
        siguienteNodo =null;
    }

    public void ponerObjeto(Object objeto) {
        this.siguienteNodo = new Nodo(objeto);
    }

    @Override
    public String toString() {
        return informacionDelNodo.toString();
    }

    @Override
    public Nodo clone() {
        try {
            Nodo clone = (Nodo) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            System.out.println("Se cagó todo");
            throw new AssertionError();
        }
    }
}

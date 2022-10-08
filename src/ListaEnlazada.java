import java.util.ArrayList;

public class ListaEnlazada {
    private String nombreDeLaRama;
    private Nodo primerNodo;
    private ArrayList<ListaEnlazada> ramas;

    public ListaEnlazada() {
        this.ramas = new ArrayList<>();
        this.primerNodo = null;
    }

    public ListaEnlazada(String nombreDeLaRama, Nodo primerNodo) {
        this.ramas = new ArrayList<>();
        this.nombreDeLaRama = nombreDeLaRama;
        this.primerNodo = primerNodo;
    }

    public void gitCommit(Object objeto) {
        if (laListaEstaVacia()) {
            this.primerNodo = new Nodo(objeto);
        } else {
            Nodo auxiliarParaEncontrarElUltimoNodo = primerNodo;

            while (auxiliarParaEncontrarElUltimoNodo.obtenerSiguienteNodo() != null) {
                auxiliarParaEncontrarElUltimoNodo = auxiliarParaEncontrarElUltimoNodo.obtenerSiguienteNodo();
            }

            auxiliarParaEncontrarElUltimoNodo.ponerObjeto(objeto);
        }
    }

    private boolean laListaEstaVacia() {
        return primerNodo == null;
    }

    public void gitStatus() {
        Nodo auxiliarParaObtenerTodosLosNodos = primerNodo;
        String auxiliarParaPasarElContenidoDeLosNodos = nombreDeLaRama + "\n[";
        while (auxiliarParaObtenerTodosLosNodos != null) {
            auxiliarParaPasarElContenidoDeLosNodos += auxiliarParaObtenerTodosLosNodos.obtenerObjeto().toString() + ", ";
            auxiliarParaObtenerTodosLosNodos = auxiliarParaObtenerTodosLosNodos.obtenerSiguienteNodo();
        }

        auxiliarParaPasarElContenidoDeLosNodos = auxiliarParaPasarElContenidoDeLosNodos.substring(0, Math.abs(auxiliarParaPasarElContenidoDeLosNodos.length() - 2));

        auxiliarParaPasarElContenidoDeLosNodos += "]";

        System.out.println(auxiliarParaPasarElContenidoDeLosNodos);
    }


    public void gitRevert() {
        if (primerNodo.obtenerSiguienteNodo() == null || laListaEstaVacia()) {
            shift();
        } else {
            Nodo auxiliarParaEncontrarElUltimoValor = primerNodo;
            Nodo auxiliarParaEncontrarElValorAnteriorAlUltimo = primerNodo;

            while (auxiliarParaEncontrarElUltimoValor.obtenerSiguienteNodo() != null) {
                auxiliarParaEncontrarElValorAnteriorAlUltimo = auxiliarParaEncontrarElUltimoValor;
                auxiliarParaEncontrarElUltimoValor = auxiliarParaEncontrarElUltimoValor.obtenerSiguienteNodo();
            }

            auxiliarParaEncontrarElValorAnteriorAlUltimo.borrarSiguienteNodo();
        }
    }

    public void shift() {
        if (!laListaEstaVacia()) {
            primerNodo = primerNodo.obtenerSiguienteNodo();
        }
    }


    public void unshift(Object objeto) {
        primerNodo = new Nodo(objeto, primerNodo);
    }

    public void gitBranch(String nombreDeLaRama, Object objeto) {
        Nodo auxiliarParaEncontrarElUltimoNodo = primerNodo;

        while (auxiliarParaEncontrarElUltimoNodo.obtenerSiguienteNodo() != null) {
            auxiliarParaEncontrarElUltimoNodo = auxiliarParaEncontrarElUltimoNodo.obtenerSiguienteNodo();
        }

        ListaEnlazada ramaAuxiliar = new ListaEnlazada(nombreDeLaRama, auxiliarParaEncontrarElUltimoNodo.clone());
        ramaAuxiliar.agregarRama(this);
        ramaAuxiliar.gitCommit(objeto);

        this.agregarRama(ramaAuxiliar);
    }

    private void agregarRama(ListaEnlazada ramaNueva) {
        ramas.add(ramaNueva);
    }

    public ListaEnlazada gitCheckout(int numeroDeRama) {
        return ramas.get(numeroDeRama - 1);
    }

    public void enumerarRamas() {
        for (int i = 0; i < ramas.size(); i++) {
            System.out.println("Rama #" + (i + 1) + ": " + ramas.get(i));
        }
    }

    @Override
    public String toString() {
        return nombreDeLaRama;
    }

    public void gitMerge(int numeroDeRama) {
        Nodo nodoAuxiliar = ramas.get(numeroDeRama-1).obtenerPrimerNodo();
        this.gitCommit(nodoAuxiliar.obtenerSiguienteNodo());
    }

    private Nodo obtenerPrimerNodo() {
        return primerNodo;
    }
}

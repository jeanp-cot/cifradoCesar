public class ListaEnlazada {
    private String nombreDeLaRama;
    private Nodo primerNodo;
    private ListaEnlazada ramaExtra;

    public ListaEnlazada() {
        this.primerNodo = null;
    }

    public ListaEnlazada(String nombreDeLaRama, Nodo primerNodo) {
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

    public String gitStatus() {
        Nodo auxiliarParaObtenerTodosLosNodos = primerNodo;
        String auxiliarParaPasarElContenidoDeLosNodos = nombreDeLaRama + "\n[";
        while (auxiliarParaObtenerTodosLosNodos != null) {
            auxiliarParaPasarElContenidoDeLosNodos += auxiliarParaObtenerTodosLosNodos.obtenerObjeto()+", ";
            auxiliarParaObtenerTodosLosNodos = auxiliarParaObtenerTodosLosNodos.obtenerSiguienteNodo();
        }

        auxiliarParaPasarElContenidoDeLosNodos = auxiliarParaPasarElContenidoDeLosNodos.substring(0,Math.abs(auxiliarParaPasarElContenidoDeLosNodos.length()-2));

        auxiliarParaPasarElContenidoDeLosNodos += "]";

        return auxiliarParaPasarElContenidoDeLosNodos;
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

        ramaExtra = new ListaEnlazada(nombreDeLaRama, auxiliarParaEncontrarElUltimoNodo.clone());
        ramaExtra.agregarRama(this);
        ramaExtra.gitCommit(objeto);
    }

    private void agregarRama(ListaEnlazada ramaExtra) {
        this.ramaExtra = ramaExtra;
    }

    public ListaEnlazada gitCheckout() {
        return ramaExtra;
    }
}

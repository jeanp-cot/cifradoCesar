import Errores.ListaSinNodos;

public class ListaEnlazada {
    private final String nombreDeLaRama;
    private Nodo primerNodo;
    private ListaEnlazada ramasEnlazadas;
    public ListaEnlazada(String nombreDeLaRama) {
        this.nombreDeLaRama = nombreDeLaRama;
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

            auxiliarParaEncontrarElUltimoNodo.colocarSiguienteNodo(new Nodo(objeto));

            //auxiliarParaEncontrarElUltimoNodo.colocarSiguienteNodo(objeto);
        }
    }

    public void gitCommit(Nodo nodo) {
        if (laListaEstaVacia()) {
            this.primerNodo = nodo;
        } else {
            Nodo auxiliarParaEncontrarElUltimoNodo = primerNodo;

            while (auxiliarParaEncontrarElUltimoNodo.obtenerSiguienteNodo() != null) {
                auxiliarParaEncontrarElUltimoNodo = auxiliarParaEncontrarElUltimoNodo.obtenerSiguienteNodo();
            }

            auxiliarParaEncontrarElUltimoNodo.colocarSiguienteNodo(nodo);
        }
    }

    private boolean laListaEstaVacia() {
        return primerNodo == null;
    }

    public void gitStatus() throws ListaSinNodos {

        if (primerNodo == null){
            throw new ListaSinNodos("Esta rama no tiene ningun commit");
        }
        Nodo auxiliarParaObtenerTodosLosNodos = primerNodo;

        System.out.println(this + ":");

        while (auxiliarParaObtenerTodosLosNodos != null) {
            System.out.printf("[%s]->", auxiliarParaObtenerTodosLosNodos.obtenerObjeto());
            auxiliarParaObtenerTodosLosNodos = auxiliarParaObtenerTodosLosNodos.obtenerSiguienteNodo();
        }

        System.out.println('\n');

        /*
        Codigo que usaba antes por no saber formatos XDDDDDDDDDDDDDDD

        while (auxiliarParaObtenerTodosLosNodos != null) {
            auxiliarParaPasarElContenidoDeLosNodos += auxiliarParaObtenerTodosLosNodos.obtenerObjeto().toString() + ", ";
            auxiliarParaObtenerTodosLosNodos = auxiliarParaObtenerTodosLosNodos.obtenerSiguienteNodo();
        }

        auxiliarParaPasarElContenidoDeLosNodos = auxiliarParaPasarElContenidoDeLosNodos.substring(0, Math.abs(auxiliarParaPasarElContenidoDeLosNodos.length() - 2));

        auxiliarParaPasarElContenidoDeLosNodos += "]";

        System.out.println(auxiliarParaPasarElContenidoDeLosNodos);*/
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
        ramaAuxiliar.gitCommit(objeto);
        ramaAuxiliar.gitBranch(this);

        if (ramasEnlazadas == null) {
            ramasEnlazadas = new ListaEnlazada("Ramas de la rama " + this, new Nodo(ramaAuxiliar));
        } else {
            ramasEnlazadas.gitCommit(ramaAuxiliar);
        }

        /*ListaEnlazada ramaAuxiliar = new ListaEnlazada(nombreDeLaRama, auxiliarParaEncontrarElUltimoNodo.clone());
        ramaAuxiliar.agregarRama(this);
        ramaAuxiliar.gitCommit(objeto);

        this.agregarRama(ramaAuxiliar);*/
    }

    public void gitBranch(ListaEnlazada listaEnlazada) {
        listaEnlazada.gitCommit(obtenerUltimoNodo().clone());
        listaEnlazada.colocarRamaMaestra(this);

        if (ramasEnlazadas == null) {
            ramasEnlazadas = new ListaEnlazada("Ramas de la " + this, new Nodo(listaEnlazada));
        } else {
            ramasEnlazadas.gitCommit(listaEnlazada);
        }
    }

    private void colocarRamaMaestra(ListaEnlazada listaEnlazada) {
        ramasEnlazadas = new ListaEnlazada("Ramas de la " + this, new Nodo(listaEnlazada));
    }

    private Nodo obtenerUltimoNodo() {
        Nodo auxiliarParaEncontrarElUltimoNodo = primerNodo;

        while (auxiliarParaEncontrarElUltimoNodo.obtenerSiguienteNodo() != null) {
            auxiliarParaEncontrarElUltimoNodo = auxiliarParaEncontrarElUltimoNodo.obtenerSiguienteNodo();
        }

        return auxiliarParaEncontrarElUltimoNodo;
    }


    public ListaEnlazada gitCheckout(int numeroDeRama) {
        System.out.println("La rama seleccionada es: " + ramasEnlazadas.obtenerInformacionDelCommit(numeroDeRama - 1));
        return (ListaEnlazada) ramasEnlazadas.obtenerInformacionDelCommit(numeroDeRama - 1);
    }

    private Object obtenerInformacionDelCommit (int posicionDelCommitEnLaRama)throws NullPointerException {
        Nodo auxiliarParaEncontrarNodo = primerNodo;
        for (int i = 0; i < posicionDelCommitEnLaRama; i++) {
            if (auxiliarParaEncontrarNodo == null){
                throw new NullPointerException("No existe ese nodo");
            }
            auxiliarParaEncontrarNodo = auxiliarParaEncontrarNodo.obtenerSiguienteNodo();
        }
        return auxiliarParaEncontrarNodo.obtenerObjeto();
    }

    public void enumerarRamas() throws ListaSinNodos {
        if (ramasEnlazadas == null){
            throw new ListaSinNodos("Esta rama no tiene otras ramas");
        }

        Nodo auxiliarParaMostrarTodasLasRamas = ramasEnlazadas.primerNodo;
        int contador = 1;
        System.out.println(ramasEnlazadas + ":");
        while (auxiliarParaMostrarTodasLasRamas != null) {
            //System.out.println("Rama #" + contador++ + ": " + ((ListaEnlazada) auxiliarParaMostrarTodasLasRamas.obtenerObjeto()).gitStatus();
            System.out.printf("\tRama #%s: %s\n", contador++,auxiliarParaMostrarTodasLasRamas.obtenerObjeto());
            //System.out.println(auxiliarParaMostrarTodasLasRamas.obtenerObjeto());
            auxiliarParaMostrarTodasLasRamas = auxiliarParaMostrarTodasLasRamas.obtenerSiguienteNodo();
        }
        System.out.print('\n');
    }

    @Override
    public String toString() {
        return nombreDeLaRama;
    }

    public void gitMerge(int numeroDeRama) throws ListaSinNodos, NullPointerException {
        System.out.println("La rama seleccionada es: ");
        ((ListaEnlazada) ramasEnlazadas.obtenerInformacionDelCommit(numeroDeRama - 1)).gitStatus();
        Nodo nodoAuxiliar = ((ListaEnlazada) ramasEnlazadas.obtenerInformacionDelCommit(numeroDeRama - 1)).primerNodo;

        gitCommit(nodoAuxiliar.obtenerSiguienteNodo());
    }
}

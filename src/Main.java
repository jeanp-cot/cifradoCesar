public class Main {
    public static void main(String[] args) {
        //Creamos la rama
        ListaEnlazada ramaSeleccionada = new ListaEnlazada("Rama Principal", new Nodo(1));

        //Realizamos unos commits
        ramaSeleccionada.gitCommit(2);
        ramaSeleccionada.gitCommit(3);
        ramaSeleccionada.gitCommit(4);

        //Mostramos la rama
        System.out.println(ramaSeleccionada.gitStatus());

        //Creamos una rama apartir del ultimo commit
        ramaSeleccionada.gitBranch("Rama Secundaria",5);

        //Mostramos la rama seleccionada para ver que el commit en la rama secundaria solo se encuantra en la secundaria
        System.out.println(ramaSeleccionada.gitStatus());

        //Cambiamos de rama
        ramaSeleccionada = ramaSeleccionada.gitCheckout();

        //Mostramos la rama
        System.out.println(ramaSeleccionada.gitStatus());

        //Borramos el ultimo commit que hicimos en esa rama
        ramaSeleccionada.gitRevert();

        //Mostramos la rama
        System.out.println(ramaSeleccionada.gitStatus());

        //Cambiamos de rama
        ramaSeleccionada = ramaSeleccionada.gitCheckout();

        //Mostramos la rama seleccionada
        System.out.println(ramaSeleccionada.gitStatus());
    }
}
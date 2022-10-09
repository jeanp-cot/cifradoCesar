public class Main {
    public static void main(String[] args) {
        //Creamos la rama
        ListaEnlazada ramaSeleccionada = new ListaEnlazada("Rama Principal", new Nodo(1));
        //Realizamos unos commits
        ramaSeleccionada.gitCommit(new Nodo(2));
        ramaSeleccionada.gitCommit(new Nodo(3));
        ramaSeleccionada.gitCommit(new Nodo(4));

        //Mostramos la rama
        ramaSeleccionada.gitStatus();

        //Creamos una rama apartir del ultimo commit
        ramaSeleccionada.gitBranch("Rama Secundaria",5);
        ramaSeleccionada.gitBranch("Rama 3",6);
        ramaSeleccionada.gitBranch("Rama 4",7);
        ramaSeleccionada.gitBranch("Rama 5",8);

        ramaSeleccionada.enumerarRamas();

        //Mostramos la rama seleccionada para ver que el commit en la rama secundaria solo se encuantra en la secundaria
        ramaSeleccionada.gitStatus();

        //Cambiamos de rama
        ramaSeleccionada = ramaSeleccionada.gitCheckout(1);
        ramaSeleccionada.gitCommit(2);
        ramaSeleccionada.gitCommit(2);
        ramaSeleccionada.gitCommit(2);

        //Mostramos la rama
        ramaSeleccionada.gitStatus();

        //Borramos el ultimo commit que hicimos en esa rama
        ramaSeleccionada.gitRevert();

        //Mostramos la rama
        ramaSeleccionada.gitStatus();


        ramaSeleccionada.enumerarRamas();

        //Cambiamos de rama
        ramaSeleccionada = ramaSeleccionada.gitCheckout(1);


        //Mostramos la rama seleccionada
        ramaSeleccionada.gitStatus();
        ramaSeleccionada.enumerarRamas();

        ramaSeleccionada.gitMerge(1);

        ramaSeleccionada.gitStatus();
    }
}
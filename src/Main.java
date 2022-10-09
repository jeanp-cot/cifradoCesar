import Errores.ListaSinNodos;

public class Main {
    public static void main(String[] args) {
        //Creamos la rama principal
        ListaEnlazada ramaActiva = new ListaEnlazada("Rama Principal");
        try {
            //Mostramos que la rama esta vacia
            ramaActiva.gitStatus();
        } catch (ListaSinNodos error) {
            System.out.println(error.getMessage());
        }

        try {
            //Hacemos el primer commit
            ramaActiva.gitCommit(1);

            //Mostramos la rama con sus nodos
            ramaActiva.gitStatus();

            //Creamos varios commits
            ramaActiva.gitCommit(2);
            ramaActiva.gitCommit(3);
            ramaActiva.gitCommit(4);

            //Mostramos los nuevos commits
            ramaActiva.gitStatus();

            //Creamos una rama
            ramaActiva.gitBranch(new ListaEnlazada("Rama 2"));

            //Enumeramos las ramas
            ramaActiva.enumerarRamas();

            //Seleccionamos otra rama
            ramaActiva = ramaActiva.gitCheckout(1);

            //Mostramos los commits de la nueva rama
            ramaActiva.gitStatus();

            //Creamos un commit en la nueva rama
            ramaActiva.gitCommit(5);
            ramaActiva.gitCommit(6);

            //Mostramos como el commit se guardo correctamente
            ramaActiva.gitStatus();

            //Quitamos el ultimo commit
            ramaActiva.gitRevert();

            //Mostramos como se borro el ultimo commit
            ramaActiva.gitStatus();

            //Mostramos que podemos regresar a la anterior rama
            ramaActiva.enumerarRamas();

            //Seleccionamos la otra rama
            ramaActiva = ramaActiva.gitCheckout(1);

            //Mostramos que es la rama anterior
            ramaActiva.gitStatus();

            //Nuevo comando: gitMerge
            ramaActiva.gitMerge(1);

            ramaActiva.gitStatus();


        }catch (ListaSinNodos | NullPointerException error) {
            System.out.println(error.getMessage());
        }

    }
}
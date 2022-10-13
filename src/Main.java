public class Main {
    //Ingresar todos los caracteres que vas a usar
    public static String caracteres = "abcdefghijklmnopqrstuvwxyz123456789!@#$%^&*()_><:;\"\'";
    public static int posicionesQueSeDesplazaParaCifrar = 20;
    public static void main(String[] args) {
        String mensajeCifrado = cifrarCadenaConCifradoCesar("Sigueme en instagram @jeanp_cot 19 :)", posicionesQueSeDesplazaParaCifrar);

        System.out.println(mensajeCifrado);

        System.out.println(descifrarMensaje(mensajeCifrado, posicionesQueSeDesplazaParaCifrar));
    }

    private static String descifrarMensaje(String mensajeCifrado, int posicionesQueSeDesplaza) {
        String aux = caracteres.substring(posicionesQueSeDesplaza) + caracteres.substring(0, posicionesQueSeDesplaza);
        mensajeCifrado = mensajeCifrado.toLowerCase();
        String mensajeDescifrado = "";
        for (int i =0; i<mensajeCifrado.length();i++){
            if (mensajeCifrado.charAt(i) == ' '){
                mensajeDescifrado += ' ';
                continue;
            }
            mensajeDescifrado += caracteres.charAt(aux.indexOf(mensajeCifrado.charAt(i)));
        }

        return mensajeDescifrado;
    }

    private static String cifrarCadenaConCifradoCesar(String mensaje, int posicionesQueSeDesplaza) {
        String aux = caracteres.substring(posicionesQueSeDesplaza) + caracteres.substring(0, posicionesQueSeDesplaza);
        mensaje = mensaje.toLowerCase();
        String mensajeCifrado = "";
        for (int i =0; i<mensaje.length();i++){
            if (mensaje.charAt(i) == ' '){
                mensajeCifrado += ' ';
                continue;
            }
            mensajeCifrado += aux.charAt(caracteres.indexOf(mensaje.charAt(i)));
        }

        return mensajeCifrado;
    }
}
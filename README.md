# sistemaGIT
Ejercicio #10 del #30DaysOfCodeByAEIS

Lenguaje: Java

Objetivo: 
1.  Implementar los siguientes metodos:
  - git commint: Este comando nos permite añadir un elemento a la lista de nuestro repositorio.
  - git branch: Crear una rama
  - git checkout: Cambiar de una rama a otra
  - git status: Mostrar la informacion de los nodos
  - git revert: Deshace los cambios efectuados en el ultimo nodo
2.	Consulta sobre git e implementa un comando nuevo, explícanos el funcionamiento en git y el funcionamiento en tu código.
  - git merge: Fusiona una rama dentro de la rama que tienes activa
3.	Opcional: si manejas git sabrás que estos comandos al ejecutarlos muestran una salida, de ser posible, implementa esta salida cada que ejecutes tu comando

Usé las funciones creadas el dia #9, para guardar las ramas creadas utilicé una ListaEnlazada esto me servía para luego enumerarlas y seleccionar la que quisiera al momento de hacer el merge o checkout (tambien pudo haber servido para borrar las ramas). 
El merge fue el comando nuevo que implementé.

También tuve que crear un metodo que pudiera regresarme un nodo en concreto de la ListaEnlazada.

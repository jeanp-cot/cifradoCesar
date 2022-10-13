# sistemaGIT
Ejercicio #13 del #30DaysOfCodeByAEIS

Lenguaje: Java

Objetivo: 

•	🧑‍💻👩‍💻Programa un bloque o función que reciba como parámetro una cadena de texto y un número que indique cuántas posiciones se tiene que desplazar desde la posición original.

•	🧑‍💻👩‍💻Programa un bloque o función que reciba como parámetro una cadena cifrada y un número n, con la finalidad de que se puede la cadena Original

•	[OPCIONAL] En este caso el cifrado para los anteriores problemas es únicamente para el alfabeto, que pasa si un usuario quiere añadir números y caracteres especiales en un orden dado, ¿Cómo solucionarías el problema?, Pon un ejemplo haga uso de números y caracteres especiales.

Primero ingresé todos los caracteres que se iban a usar en una variable ya sean letras, números, caracteres especiales o lo que sea. En las funciones para cifrar y descifrar usé un auxiliar para desplazar los caracteres. Los desplazaba de la siguiente manera:
La variable donde se encuentran todos los caracteres la dividia en 2 partes, la primera parte iba desde el inicio de la cadena hasta el numero de espacios a desplazar y la segunda todo lo que sobrara. Luego para desplazarlos agarraba la segunda parte y la ponia de primero en la variable auxiliar, para luego agregar la primera parte al final.

Use un for para leer cada caracter del mensaje, para saber que caracter era usé charAt() y para saber su indice usé indexOf(). Le decía al programa dame el índice de esta letra en la lista de caracteres, luego regresame la letra que se encuentra en ese indicie en la variable auxiliar donde estan los caracteres desplazados. Así cifré el mensaje y para descifrarlo solo era el proceso inverso.

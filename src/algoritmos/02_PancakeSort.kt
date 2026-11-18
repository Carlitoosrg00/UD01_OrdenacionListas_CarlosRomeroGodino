package algoritmos

import datos.GenerarDatos

// Función principal del programa.
fun main() {

    // Se crea una copia de la lista de vehículos.
    val vehiculos = GenerarDatos.vehiculos.toMutableList()

    // Se crea una copia de la lista de números.
    val numeros = GenerarDatos.numeros.toMutableList()

    println("===== PANCAKE SORT =====")

    // Mostrar vehículos originales.
    println("\nLista de vehículos original:")
    println(vehiculos)

    // Inicio de la medición.
    val inicioVehiculos = System.nanoTime()

    // Ordenación de vehículos.
    pancakeSortStrings(vehiculos)

    // Fin de la medición.
    val finVehiculos = System.nanoTime()

    // Mostrar vehículos ordenados.
    println("\nLista de vehículos ordenada:")
    println(vehiculos)

    println("Tiempo vehículos: ${finVehiculos - inicioVehiculos} ns")

    println("\n================================")

    // Mostrar números originales.
    println("\nLista numérica original:")
    println(numeros)

    // Inicio de la medición.
    val inicioNumeros = System.nanoTime()

    // Ordenación de números.
    pancakeSortInts(numeros)

    // Fin de la medición.
    val finNumeros = System.nanoTime()

    // Mostrar números ordenados.
    println("\nLista numérica ordenada:")
    println(numeros)

    println("Tiempo números: ${finNumeros - inicioNumeros} ns")
}

/*
 * PANCAKE SORT PARA STRINGS
 */

// Ordena una lista de texto utilizando Pancake Sort.
fun pancakeSortStrings(lista: MutableList<String>) {

    for (tamanoActual in lista.size downTo 2) {

        var indiceMaximo = 0

        for (i in 1 until tamanoActual) {

            if (lista[i] > lista[indiceMaximo]) {

                indiceMaximo = i
            }
        }

        if (indiceMaximo != tamanoActual - 1) {

            voltearStrings(lista, indiceMaximo)

            voltearStrings(lista, tamanoActual - 1)
        }
    }
}

// Invierte parte de la lista.
fun voltearStrings(lista: MutableList<String>, fin: Int) {

    var inicio = 0
    var ultimo = fin

    while (inicio < ultimo) {

        val temporal = lista[inicio]
        lista[inicio] = lista[ultimo]
        lista[ultimo] = temporal

        inicio++
        ultimo--
    }
}

/*
 * PANCAKE SORT PARA ENTEROS
 */

// Ordena una lista de números utilizando Pancake Sort.
fun pancakeSortInts(lista: MutableList<Int>) {

    for (tamanoActual in lista.size downTo 2) {

        var indiceMaximo = 0

        for (i in 1 until tamanoActual) {

            if (lista[i] > lista[indiceMaximo]) {

                indiceMaximo = i
            }
        }

        if (indiceMaximo != tamanoActual - 1) {

            voltearInts(lista, indiceMaximo)

            voltearInts(lista, tamanoActual - 1)
        }
    }
}

// Invierte una parte de la lista.
fun voltearInts(lista: MutableList<Int>, fin: Int) {

    var inicio = 0
    var ultimo = fin

    while (inicio < ultimo) {

        val temporal = lista[inicio]
        lista[inicio] = lista[ultimo]
        lista[ultimo] = temporal

        inicio++
        ultimo--
    }
}
package algoritmos

// Importamos el objeto GenerarDatos para acceder a las listas.
import datos.GenerarDatos

// Función principal que se ejecuta al iniciar el programa.
fun main() {

    // Creamos una copia de la lista de vehículos.
    // Así no modificamos la lista original almacenada en GenerarDatos.
    val vehiculos = GenerarDatos.vehiculos.toMutableList()

    // Creamos una copia de la lista de números.
    val numeros = GenerarDatos.numeros.toMutableList()

    println("===== QUICKSORT =====")

    // Mostramos la lista original de vehículos.
    println("\nLista de vehículos original:")
    println(vehiculos)

    // Guardamos el instante inicial para medir el tiempo de ejecución.
    val inicioVehiculos = System.nanoTime()

    // Ejecutamos QuickSort sobre la lista de vehículos.
    quickSortStrings(vehiculos, 0, vehiculos.size - 1)

    // Guardamos el instante final.
    val finVehiculos = System.nanoTime()

    // Mostramos la lista ya ordenada.
    println("\nLista de vehículos ordenada:")
    println(vehiculos)

    // Calculamos cuánto ha tardado la ordenación.
    println("Tiempo vehículos: ${finVehiculos - inicioVehiculos} ns")

    println("\n================================")

    // Mostramos la lista original de números.
    println("\nLista numérica original:")
    println(numeros)

    // Comenzamos la medición.
    val inicioNumeros = System.nanoTime()

    // Ordenamos la lista numérica.
    quickSortInts(numeros, 0, numeros.size - 1)

    // Finalizamos la medición.
    val finNumeros = System.nanoTime()

    // Mostramos los números ordenados.
    println("\nLista numérica ordenada:")
    println(numeros)

    // Mostramos el tiempo empleado.
    println("Tiempo números: ${finNumeros - inicioNumeros} ns")
}

/*
 * QUICKSORT PARA VEHÍCULOS (STRINGS)
 */

// Función recursiva que aplica QuickSort a una lista de texto.
fun quickSortStrings(lista: MutableList<String>, inicio: Int, fin: Int) {

    // Si la zona tiene más de un elemento se puede seguir ordenando.
    if (inicio < fin) {

        // Coloca el pivote en su posición correcta
        // y devuelve dicha posición.
        val indicePivote = particionStrings(lista, inicio, fin)

        // Ordena la parte izquierda del pivote.
        quickSortStrings(lista, inicio, indicePivote - 1)

        // Ordena la parte derecha del pivote.
        quickSortStrings(lista, indicePivote + 1, fin)
    }
}

// Función que divide la lista en dos partes usando un pivote.
fun particionStrings(
    lista: MutableList<String>,
    inicio: Int,
    fin: Int
): Int {

    // Elegimos el último elemento como pivote.
    val pivote = lista[fin]

    // Variable que marcará la posición de los elementos menores.
    var i = inicio - 1

    // Recorremos todos los elementos excepto el pivote.
    for (j in inicio until fin) {

        // Si el elemento actual es menor o igual al pivote.
        if (lista[j] <= pivote) {

            // Avanzamos una posición.
            i++

            // Guardamos temporalmente el valor de la posición i.
            val temporal = lista[i]

            // Colocamos el elemento actual en la posición correcta.
            lista[i] = lista[j]

            // Recuperamos el valor guardado.
            lista[j] = temporal
        }
    }

    // Intercambiamos el pivote y lo colocamos en su posición definitiva.

    val temporal = lista[i + 1]

    lista[i + 1] = lista[fin]

    lista[fin] = temporal

    // Devolvemos la posición final del pivote.
    return i + 1
}

/*
 * QUICKSORT PARA NÚMEROS
 */

// Función recursiva que aplica QuickSort a una lista de enteros.
fun quickSortInts(lista: MutableList<Int>, inicio: Int, fin: Int) {

    // Si todavía quedan elementos para ordenar.
    if (inicio < fin) {

        // Se obtiene la posición del pivote.
        val indicePivote = particionInts(lista, inicio, fin)

        // Ordenación de la parte izquierda.
        quickSortInts(lista, inicio, indicePivote - 1)

        // Ordenación de la parte derecha.
        quickSortInts(lista, indicePivote + 1, fin)
    }
}

// Divide la lista alrededor de un pivote.
fun particionInts(
    lista: MutableList<Int>,
    inicio: Int,
    fin: Int
): Int {

    // El pivote será el último elemento.
    val pivote = lista[fin]

    // Posición de referencia para elementos menores.
    var i = inicio - 1

    // Se recorren todos los elementos menos el pivote.
    for (j in inicio until fin) {

        // Si el elemento es menor o igual al pivote.
        if (lista[j] <= pivote) {

            // Avanzamos la posición.
            i++

            // Intercambio mediante una variable temporal.
            val temporal = lista[i]

            lista[i] = lista[j]

            lista[j] = temporal
        }
    }

    // Colocamos el pivote en su lugar definitivo.
    val temporal = lista[i + 1]

    lista[i + 1] = lista[fin]

    lista[fin] = temporal

    // Devolvemos la posición final del pivote.
    return i + 1
}
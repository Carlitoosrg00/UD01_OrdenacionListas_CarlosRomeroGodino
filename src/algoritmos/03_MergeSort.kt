package algoritmos

// Importa el objeto GenerarDatos para acceder
// a las listas de vehículos y números.
import datos.GenerarDatos

// Función principal que inicia la ejecución del programa.
fun main() {

    // Crea una copia de la lista de vehículos para no
    // modificar la lista original almacenada en GenerarDatos.
    val vehiculos = GenerarDatos.vehiculos.toMutableList()

    // Crea una copia de la lista de números para trabajar
    // sobre ella sin alterar los datos originales.
    val numeros = GenerarDatos.numeros.toMutableList()

    // Muestra el nombre del algoritmo que se está ejecutando.
    println("===== MERGE SORT =====")

    // Muestra el texto informativo.
    println("\nLista de vehículos original:")

    // Muestra la lista antes de ordenarla.
    println(vehiculos)

    // Guarda el instante inicial para medir el tiempo de ejecución.
    val inicioVehiculos = System.nanoTime()

    // Llama al algoritmo MergeSort para ordenar los vehículos.
    mergeSortStrings(vehiculos)

    // Guarda el instante final de ejecución.
    val finVehiculos = System.nanoTime()

    // Muestra la lista ya ordenada.
    println("\nLista de vehículos ordenada:")
    println(vehiculos)

    // Calcula y muestra el tiempo empleado.
    println("Tiempo vehículos: ${finVehiculos - inicioVehiculos} ns")

    // Línea separadora visual.
    println("\n================================")

    // Muestra la lista numérica original.
    println("\nLista numérica original:")
    println(numeros)

    // Comienza la medición del tiempo.
    val inicioNumeros = System.nanoTime()

    // Ordena la lista numérica utilizando MergeSort.
    mergeSortInts(numeros)

    // Finaliza la medición.
    val finNumeros = System.nanoTime()

    // Muestra la lista ordenada.
    println("\nLista numérica ordenada:")
    println(numeros)

    // Muestra el tiempo empleado.
    println("Tiempo números: ${finNumeros - inicioNumeros} ns")
}

/*
 * MERGESORT PARA STRINGS
 */

// Función principal de MergeSort para listas de texto.
fun mergeSortStrings(lista: MutableList<String>) {

    // Si la lista tiene 0 o 1 elementos ya está ordenada.
    if (lista.size <= 1) return

    // Calcula la mitad de la lista.
    val mitad = lista.size / 2

    // Copia los elementos de la parte izquierda.
    val izquierda = lista.subList(0, mitad).toMutableList()

    // Copia los elementos de la parte derecha.
    val derecha = lista.subList(mitad, lista.size).toMutableList()

    // Ordena recursivamente la parte izquierda.
    mergeSortStrings(izquierda)

    // Ordena recursivamente la parte derecha.
    mergeSortStrings(derecha)

    // Fusiona ambas partes ya ordenadas.
    fusionarStrings(lista, izquierda, derecha)
}

// Une dos listas ordenadas en una sola lista ordenada.
fun fusionarStrings(
    lista: MutableList<String>,
    izquierda: MutableList<String>,
    derecha: MutableList<String>
) {

    // Índice de recorrido de la lista izquierda.
    var i = 0

    // Índice de recorrido de la lista derecha.
    var j = 0

    // Índice de la lista resultado.
    var k = 0

    // Mientras queden elementos en ambas listas.
    while (i < izquierda.size && j < derecha.size) {

        // Si el elemento izquierdo es menor o igual.
        if (izquierda[i] <= derecha[j]) {

            // Lo coloca en la lista final.
            lista[k] = izquierda[i]

            // Avanza al siguiente elemento izquierdo.
            i++

        } else {

            // Si no, coloca el elemento derecho.
            lista[k] = derecha[j]

            // Avanza al siguiente elemento derecho.
            j++
        }

        // Avanza la posición de escritura.
        k++
    }

    // Copia los elementos restantes de la lista izquierda.
    while (i < izquierda.size) {

        lista[k] = izquierda[i]

        i++
        k++
    }

    // Copia los elementos restantes de la lista derecha.
    while (j < derecha.size) {

        lista[k] = derecha[j]

        j++
        k++
    }
}

/*
 * MERGESORT PARA ENTEROS
 */

// Función principal de MergeSort para números.
fun mergeSortInts(lista: MutableList<Int>) {

    // Si tiene 0 o 1 elementos ya está ordenada.
    if (lista.size <= 1) return

    // Calcula la mitad de la lista.
    val mitad = lista.size / 2

    // Obtiene la parte izquierda.
    val izquierda = lista.subList(0, mitad).toMutableList()

    // Obtiene la parte derecha.
    val derecha = lista.subList(mitad, lista.size).toMutableList()

    // Ordena recursivamente la mitad izquierda.
    mergeSortInts(izquierda)

    // Ordena recursivamente la mitad derecha.
    mergeSortInts(derecha)

    // Fusiona ambas mitades ordenadas.
    fusionarInts(lista, izquierda, derecha)
}

// Fusiona dos listas numéricas previamente ordenadas.
fun fusionarInts(
    lista: MutableList<Int>,
    izquierda: MutableList<Int>,
    derecha: MutableList<Int>
) {

    // Índice de la lista izquierda.
    var i = 0

    // Índice de la lista derecha.
    var j = 0

    // Índice de la lista resultado.
    var k = 0

    // Mientras existan elementos en ambas listas.
    while (i < izquierda.size && j < derecha.size) {

        // Comprueba cuál es el menor elemento.
        if (izquierda[i] <= derecha[j]) {

            // Copia el elemento izquierdo.
            lista[k] = izquierda[i]

            // Avanza en la lista izquierda.
            i++

        } else {

            // Copia el elemento derecho.
            lista[k] = derecha[j]

            // Avanza en la lista derecha.
            j++
        }

        // Avanza la posición de escritura.
        k++
    }

    // Copia los elementos sobrantes de la lista izquierda.
    while (i < izquierda.size) {

        lista[k] = izquierda[i]

        i++
        k++
    }

    // Copia los elementos sobrantes de la lista derecha.
    while (j < derecha.size) {

        lista[k] = derecha[j]

        j++
        k++
    }
}
package algoritmos

// Importa las listas generadas en GenerarDatos.
import datos.GenerarDatos

// Función principal que inicia el programa.
fun main() {

    // Crea una copia de la lista de vehículos para no modificar la original.
    val vehiculos = GenerarDatos.vehiculos.toMutableList()

    // Crea una copia de la lista de números para no modificar la original.
    val numeros = GenerarDatos.numeros.toMutableList()

    // Muestra el nombre del algoritmo que se va a ejecutar.
    println("===== SHELL SORT =====")

    // Muestra la lista de vehículos antes de ordenarla.
    println("\nLista de vehículos original:")
    println(vehiculos)

    // Guarda el instante inicial para medir el tiempo.
    val inicioVehiculos = System.nanoTime()

    // Ordena la lista de vehículos utilizando ShellSort.
    shellSortStrings(vehiculos)

    // Guarda el instante final.
    val finVehiculos = System.nanoTime()

    // Muestra la lista de vehículos ya ordenada.
    println("\nLista de vehículos ordenada:")
    println(vehiculos)

    // Muestra el tiempo empleado en la ordenación.
    println("Tiempo vehículos: ${finVehiculos - inicioVehiculos} ns")

    // Línea separadora visual.
    println("\n================================")

    // Muestra la lista numérica original.
    println("\nLista numérica original:")
    println(numeros)

    // Guarda el instante inicial.
    val inicioNumeros = System.nanoTime()

    // Ordena la lista numérica utilizando ShellSort.
    shellSortInts(numeros)

    // Guarda el instante final.
    val finNumeros = System.nanoTime()

    // Muestra la lista numérica ordenada.
    println("\nLista numérica ordenada:")
    println(numeros)

    // Muestra el tiempo empleado.
    println("Tiempo números: ${finNumeros - inicioNumeros} ns")
}

/*
 * SHELL SORT PARA STRINGS
 */

// Función que ordena una lista de texto mediante ShellSort.
fun shellSortStrings(lista: MutableList<String>) {

    // Inicializa el gap con la mitad del tamaño de la lista.
    var gap = lista.size / 2

    // Continúa mientras el gap sea mayor que cero.
    while (gap > 0) {

        // Recorre todos los elementos desde la posición gap.
        for (i in gap until lista.size) {

            // Guarda temporalmente el elemento actual.
            val temporal = lista[i]

            // Guarda la posición actual.
            var j = i

            // Desplaza elementos mientras sean mayores que el actual.
            while (j >= gap && lista[j - gap] > temporal) {

                // Mueve el elemento anterior una posición hacia delante.
                lista[j] = lista[j - gap]

                // Retrocede tantas posiciones como indique el gap.
                j -= gap
            }

            // Coloca el elemento temporal en su posición correcta.
            lista[j] = temporal
        }

        // Reduce el gap a la mitad para seguir refinando la ordenación.
        gap /= 2
    }
}

// Función que ordena una lista de números mediante ShellSort.
fun shellSortInts(lista: MutableList<Int>) {

    // Inicializa el gap con la mitad del tamaño de la lista.
    var gap = lista.size / 2

    // Continúa ejecutándose mientras exista separación entre elementos.
    while (gap > 0) {

        // Recorre la lista desde la posición gap.
        for (i in gap until lista.size) {

            // Guarda el valor actual temporalmente.
            val temporal = lista[i]

            // Guarda la posición actual.
            var j = i

            // Compara elementos separados por la distancia gap.
            while (j >= gap && lista[j - gap] > temporal) {

                // Desplaza el elemento mayor hacia delante.
                lista[j] = lista[j - gap]

                // Retrocede tantas posiciones como indique el gap.
                j -= gap
            }

            // Inserta el valor temporal en su posición correcta.
            lista[j] = temporal
        }

        // Reduce el gap para realizar comparaciones más cercanas.
        gap /= 2
    }
}
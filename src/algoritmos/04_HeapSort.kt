package algoritmos

// Importa las listas generadas en GenerarDatos.
import datos.GenerarDatos

// Función principal que inicia el programa.
fun main() {

    // Crea una copia de la lista de vehículos.
    val vehiculos = GenerarDatos.vehiculos.toMutableList()

    // Crea una copia de la lista numérica.
    val numeros = GenerarDatos.numeros.toMutableList()

    // Muestra el nombre del algoritmo.
    println("===== HEAP SORT =====")

    // Muestra la lista de vehículos antes de ordenarla.
    println("\nLista de vehículos original:")
    println(vehiculos)

    // Guarda el instante inicial para medir el tiempo.
    val inicioVehiculos = System.nanoTime()

    // Ordena los vehículos mediante HeapSort.
    heapSortStrings(vehiculos)

    // Guarda el instante final.
    val finVehiculos = System.nanoTime()

    // Muestra el resultado ordenado.
    println("\nLista de vehículos ordenada:")
    println(vehiculos)

    // Muestra el tiempo de ejecución.
    println("Tiempo vehículos: ${finVehiculos - inicioVehiculos} ns")

    // Línea separadora.
    println("\n================================")

    // Muestra la lista numérica original.
    println("\nLista numérica original:")
    println(numeros)

    // Guarda el instante inicial.
    val inicioNumeros = System.nanoTime()

    // Ordena la lista numérica.
    heapSortInts(numeros)

    // Guarda el instante final.
    val finNumeros = System.nanoTime()

    // Muestra la lista numérica ordenada.
    println("\nLista numérica ordenada:")
    println(numeros)

    // Muestra el tiempo consumido.
    println("Tiempo números: ${finNumeros - inicioNumeros} ns")
}

/*
 * HEAPSORT PARA STRINGS
 */

// Función principal que aplica HeapSort a una lista de texto.
fun heapSortStrings(lista: MutableList<String>) {

    // Guarda el tamaño de la lista.
    val n = lista.size

    // Construye el Heap inicial.
    for (i in n / 2 - 1 downTo 0) {

        // Ajusta cada rama para que cumpla la propiedad Heap.
        heapifyStrings(lista, n, i)
    }

    // Extrae uno a uno los elementos del Heap.
    for (i in n - 1 downTo 1) {

        // Guarda temporalmente la raíz.
        val temp = lista[0]

        // Mueve el último elemento a la raíz.
        lista[0] = lista[i]

        // Coloca el mayor elemento al final.
        lista[i] = temp

        // Reconstruye el Heap.
        heapifyStrings(lista, i, 0)
    }
}

// Mantiene la estructura Heap después de cada modificación.
fun heapifyStrings(
    lista: MutableList<String>,
    n: Int,
    raiz: Int
) {

    // Considera inicialmente la raíz como el elemento mayor.
    var mayor = raiz

    // Calcula la posición del hijo izquierdo.
    val izquierda = 2 * raiz + 1

    // Calcula la posición del hijo derecho.
    val derecha = 2 * raiz + 2

    // Comprueba si el hijo izquierdo es mayor que la raíz.
    if (izquierda < n && lista[izquierda] > lista[mayor]) {

        // Actualiza la posición del elemento mayor.
        mayor = izquierda
    }

    // Comprueba si el hijo derecho es mayor.
    if (derecha < n && lista[derecha] > lista[mayor]) {

        // Actualiza la posición del elemento mayor.
        mayor = derecha
    }

    // Si el mayor no está en la raíz se intercambian posiciones.
    if (mayor != raiz) {

        // Guarda temporalmente el valor de la raíz.
        val temp = lista[raiz]

        // Coloca el mayor elemento en la raíz.
        lista[raiz] = lista[mayor]

        // Completa el intercambio.
        lista[mayor] = temp

        // Revisa recursivamente la rama modificada.
        heapifyStrings(lista, n, mayor)
    }
}

/*
 * HEAPSORT PARA ENTEROS
 */

// Función principal que aplica HeapSort a números enteros.
fun heapSortInts(lista: MutableList<Int>) {

    // Guarda el tamaño de la lista.
    val n = lista.size

    // Construye el Heap inicial.
    for (i in n / 2 - 1 downTo 0) {

        // Convierte cada rama en un Heap válido.
        heapifyInts(lista, n, i)
    }

    // Extrae los elementos ordenadamente.
    for (i in n - 1 downTo 1) {

        // Guarda temporalmente el valor de la raíz.
        val temp = lista[0]

        // Intercambia la raíz con el último elemento.
        lista[0] = lista[i]

        // Coloca el valor mayor en su posición definitiva.
        lista[i] = temp

        // Reconstruye el Heap.
        heapifyInts(lista, i, 0)
    }
}

// Mantiene la estructura Heap para listas numéricas.
fun heapifyInts(
    lista: MutableList<Int>,
    n: Int,
    raiz: Int
) {

    // Considera la raíz como el valor mayor inicialmente.
    var mayor = raiz

    // Posición del hijo izquierdo.
    val izquierda = 2 * raiz + 1

    // Posición del hijo derecho.
    val derecha = 2 * raiz + 2

    // Comprueba si el hijo izquierdo es mayor.
    if (izquierda < n && lista[izquierda] > lista[mayor]) {
        mayor = izquierda
    }

    // Comprueba si el hijo derecho es aún mayor.
    if (derecha < n && lista[derecha] > lista[mayor]) {
        mayor = derecha
    }

    // Si la raíz no contiene el mayor valor se intercambian.
    if (mayor != raiz) {

        // Guarda temporalmente la raíz.
        val temp = lista[raiz]

        // Coloca el mayor elemento en la raíz.
        lista[raiz] = lista[mayor]

        // Completa el intercambio.
        lista[mayor] = temp

        // Repite el proceso en la rama modificada.
        heapifyInts(lista, n, mayor)
    }
}
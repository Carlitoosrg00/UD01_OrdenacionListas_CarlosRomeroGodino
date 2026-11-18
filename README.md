🚀 Implementación de Algoritmos de Ordenación en Kotlin
Proyecto desarrollado para la asignatura Programación Multimedia y Dispositivos Móviles (PMDM).

📋 Descripción
En esta práctica se han implementado diferentes algoritmos de ordenación utilizando Kotlin, con el objetivo de analizar su funcionamiento, comparar su rendimiento y medir sus tiempos de ejecución.

Todos los algoritmos trabajan sobre dos conjuntos de datos:

- 🚗 Lista de 40 vehículos desordenados.
- 🔢 Lista de 100 números enteros aleatorios sin repetir.
  
Cada algoritmo:

- Obtiene los mismos datos de partida.
- Trabaja sobre una copia de las listas.
- Ordena los elementos sin utilizar funciones integradas como sort() o sorted().
- Mide el tiempo de ejecución mediante System.nanoTime().
-----------------------------------------------------------------------------------------------------------------------------------------------------

🧠 Algoritmos implementados

1️⃣ QuickSort
Algoritmo recursivo basado en la técnica Divide y Vencerás. Utiliza un pivote para dividir la lista en elementos menores y mayores.

2️⃣ Pancake Sort
Algoritmo inspirado en el proceso de ordenar una pila de tortitas mediante volteos sucesivos.

3️⃣ MergeSort
Algoritmo recursivo que divide la lista en partes más pequeñas y posteriormente las fusiona de forma ordenada.

4️⃣ HeapSort
Algoritmo basado en una estructura de datos tipo Heap (montículo) que permite colocar rápidamente el elemento de mayor valor en su posición correcta.

5️⃣ ShellSort
Mejora del algoritmo Insertion Sort mediante comparaciones realizadas a diferentes distancias (gaps).
-----------------------------------------------------------------------------------------------------------------------------------------------------

📁 Estructura del proyecto
src
│
├── datos
│   └── GenerarDatos.kt
│
└── algoritmos
    ├── 01_QuickSort.kt
    ├── 02_PancakeSort.kt
    ├── 03_MergeSort.kt
    ├── 04_HeapSort.kt
    └── 05_ShellSort.kt
-----------------------------------------------------------------------------------------------------------------------------------------------------

⚙️ Tecnologías utilizadas
Kotlin
IntelliJ IDEA
Git
GitHub
-----------------------------------------------------------------------------------------------------------------------------------------------------

▶️ Ejecución
Abrir el proyecto en IntelliJ IDEA.
Ejecutar cualquiera de los archivos .kt situados en la carpeta algoritmos.
Observar la lista original, la lista ordenada y el tiempo de ejecución obtenido.
-----------------------------------------------------------------------------------------------------------------------------------------------------

📊 Resultados obtenidos
Algoritmo	Vehículos (ns)	Números (ns)
QuickSort	124500	152900
Pancake Sort	338900	1001000
MergeSort	245300	343900
HeapSort	210300	199700
ShellSort	152000	126300
✅ Todos los algoritmos ordenan correctamente las listas.

🏆 ShellSort obtuvo el mejor tiempo de ejecución en las pruebas realizadas.

👨‍💻 Autor
Carlos Romero Godino

Curso 2026/2027
Programación Multimedia y Dispositivos Móviles (PMDM)
-----------------------------------------------------------------------------------------------------------------------------------------------------

📚 Bibliografía
https://kotlinlang.org/docs
https://www.geeksforgeeks.org
https://www.programiz.com
https://docs.oracle.com
https://es.wikipedia.org

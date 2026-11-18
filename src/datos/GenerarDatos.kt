package datos

// Objeto que almacena los datos que utilizarán todos los algoritmos.
object GenerarDatos {

    // Lista de vehículos desordenados.
    val vehiculos = mutableListOf(
        "Ford", "BMW", "Audi", "Toyota", "Honda",
        "Mercedes", "Opel", "Seat", "Volkswagen", "Kia",
        "Hyundai", "Mazda", "Peugeot", "Renault", "Citroen",
        "Fiat", "Chevrolet", "Nissan", "Jeep", "Volvo",
        "Skoda", "Dacia", "Tesla", "Subaru", "Suzuki",
        "Lexus", "Jaguar", "Ferrari", "Lamborghini", "Porsche",
        "Mini", "Alfa Romeo", "Mitsubishi", "Chrysler", "Cadillac",
        "Bentley", "Aston Martin", "Bugatti", "McLaren", "Rolls Royce"
    )

    // Lista de números enteros aleatorios sin repetir.
    val numeros = mutableListOf<Int>().apply {

        // Mientras la lista tenga menos de 100 números.
        while (size < 100) {

            // Genera un número aleatorio entre 1 y 10000.
            val numero = (1..10000).random()

            // Comprueba que no esté repetido.
            if (!contains(numero)) {

                // Añade el número a la lista.
                add(numero)
            }
        }
    }
}
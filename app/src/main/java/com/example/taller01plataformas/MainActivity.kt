package com.example.taller01plataformas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Taller Plataformas Moviles
        //Pregunta 1: Validar si una persona es mayor o menor de edad
        validarEdad(21)

        //Pregunta 2: Presentar una tabla de multiplicar de n numero de forma ascendente
        // y descendente
        tablaMultiplicar(5)

        //Pregunta 3: Mostrar listado de paralelo de la materia de Plataformas Moviles y los
        // subgrupos por proyectos(mostrar resultados ordenados)
        listadoParalelo()

        //Pregunta 4: Propiedades las propiedades de un vehiculo utilizando clases
        propiedadesVehiculo()

        //Taller en Clases

        //Algoritmo para ordenar un array
        ordenarArray()

        //Validador de cedula
        validadorDeCedulaEcuador("1150633335")
    }

    private fun validarEdad(edad: Int) {

        if (edad >= 18) {
            println("La persona es mayor de edad\n")
        } else {
            println("La persona es menor de edad\n")
        }
    }

    private fun tablaMultiplicar(num: Int) {

        var listado = arrayListOf<Int>()
        for (i in 0..9) {
            var r = num * i
            listado.add(r)
        }
        println("Orden ascendente: $listado\n")
        /*
        sortedDescending() hace exactamente lo mismo que sorted(), solo que con un orden
        descendente en los elementos
         */
        listado.sortDescending()
        println("Orden descendente: $listado\n")
    }

    private fun listadoParalelo() {

        var grupoEstudiantes = listOf(
            1 to "Shomira Rosales",
            2 to "David Salazar",
            3 to "Erick Jaramillo",
            1 to "Luis Quishpe",
            2 to "David Pilco",
            3 to "Jordy Esparza",
            1 to "Santiago Garcia",
            2 to "Jeferson Cueva",
            3 to "David Morales"
        )

        println("Listado de Plataformas Móviles \n $grupoEstudiantes\n")
        println("Grupos de trabajo\n")
        var grupos = grupoEstudiantes.groupBy({ it.first }, { it.second })
        println(grupos)

    }

    private fun propiedadesVehiculo() {

        var vehiculo =
            Vehiculo(traccion = "delantera", motor = "1600", tipo = "sedan", capacidad = 5)

        println(
            "Propiedades del vehículo\nTracción: ${vehiculo.traccion}\n Motor: ${vehiculo.motor}\n" +
                    " Tipo de vehiculo: ${vehiculo.tipo}\n Capacidad: ${vehiculo.capacidad}\n"
        )
    }

    private fun ordenarArray() {

        var nums = arrayListOf<Int>(12, 15, 2, 5, 8, 9, 10, 3, 1, 7, 6)
        println("Lista de numeros a ordenar: $nums \n")

        // Metodo burbuja

        for (i in (0 until nums.size - 1)) {
            for (j in (0 until nums.size - 1)) {
                if (nums[j + 1] < nums[j]) {
                    var aux = nums[j + 1]
                    nums[j + 1] = nums[j]
                    nums[j] = aux
                }
            }
        }
        println("Listado de numeros ordenados: $nums\n")

    }

    private fun validadorDeCedulaEcuador(cedula: String) {
        var cedulaCorrecta = false
        if (cedula.length == 10) // ConstantesApp.LongitudCedula
        {
            val tercerDigito = cedula.substring(2, 3).toInt()
            if (tercerDigito < 6) {
                val coefValCedula = intArrayOf(2, 1, 2, 1, 2, 1, 2, 1, 2)
                val verificador = cedula.substring(9, 10).toInt()
                var suma = 0
                var digito = 0
                for (i in 0 until cedula.length - 1) {
                    digito = cedula.substring(i, i + 1).toInt() * coefValCedula[i]
                    suma += digito % 10 + digito / 10
                }
                cedulaCorrecta = if (suma % 10 == 0 && suma % 10 == verificador) {
                    true
                } else 10 - suma % 10 == verificador
            } else {
                cedulaCorrecta = false
            }
        } else {
            cedulaCorrecta = false
        }
        if (!cedulaCorrecta) {
            println("La Cédula ingresada ${cedula} es Incorrecta")
        } else {
            println("La Cédula ingresada ${cedula} es Correcta")
        }
    }
}
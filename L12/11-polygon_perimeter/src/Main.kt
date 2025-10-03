import java.util.Scanner
import kotlin.math.pow
import kotlin.math.sqrt

// Functie care citeste coordonatele punctelor de la tastatura
fun getPolygonPoints(numberOfPoints: Int) : MutableList<Pair<Int,Int>> {
    val sc = Scanner(System.`in`)
    var listOfPoints : MutableList<Pair<Int, Int>> = mutableListOf()

    for(i in 1..numberOfPoints) {
        val x = sc.nextInt()
        val y = sc.nextInt()
        // Adaugam fiecare punct ca o pereche (x, y)
        listOfPoints.add(Pair(x, y))
    }

    // Adaugam primul punct la final pentru a inchide poligonul
    listOfPoints.add(listOfPoints.first())

    return listOfPoints
}

// Functie care calculeaza distanta dintre doua puncte
fun distanceCalculus(pair1: Pair<Int,Int>, pair2: Pair<Int,Int>) : Double {
    return sqrt(
        ((pair2.first - pair1.first).toDouble()).pow(2.0) +
                ((pair2.second - pair1.second).toDouble()).pow(2.0)
    )
}

fun main() {
    val sc = Scanner(System.`in`)

    println("Number of polygon points: ")
    val points = sc.nextInt()

    // Citim lista punctelor
    val listOfPoints = getPolygonPoints(points)

    // Folosim zipWithNext pentru a crea perechi consecutive si sumOf pentru a calcula suma distantelor
    val perimeter = listOfPoints.zipWithNext().sumOf { (x, y) -> distanceCalculus(x, y) } 

    println(perimeter)
}

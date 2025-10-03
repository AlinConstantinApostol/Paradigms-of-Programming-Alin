fun main() {
    val result = listOf(1, 21, 75, 39, 7, 2, 35, 3, 31, 7, 8)
        // Filtram elementele care sunt mai mici ca 5
        .filter { it >= 5 }
        // Grupam lista in subliste de cate 2 elemente
        .chunked(2)
        // Inmultim fiecare pereche de elemente
        .map { (x, y) -> x * y }
        // Adunam toate produsele obtinute
        .fold(0) { acc, i -> acc + i }

    println(result)
}

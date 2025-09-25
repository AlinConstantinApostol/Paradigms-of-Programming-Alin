fun main() {
    val builder = ConcreteANDBuilder() // Creăm un obiect Builder pentru construcția portii AND
    builder.buildAND2Gate() // Construim o poarta AND cu 2 intrari
    val gate = builder.getProductResult() // Obtinem poarta AND construita

    val controlGate = ControlLogicGate(gate) // Cream un ControlLogicGate pentru a manipula poarta AND

    // Cream o lista de intrari pentru poarta AND
    val list: MutableList<Boolean> = mutableListOf()
    list.add(true) // Adaugam intrarea 1
    list.add(false) // Adaugam intrarea 2
    list.add(false) // Adaugam intrarea 3
    list.add(true) // Adaugam intrarea 4

    // Calculam si afisam rezultatul
    println("Output is: " + controlGate.createOutput(list))

    // Afisam lista de intrari
    builder.getProductResult().printInputsList()
}

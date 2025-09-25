interface Builder {
    fun resetBuild() // Reseteaza construcția
    fun buildAND2Gate() // Construieste o poarta AND cu 2 intrari
    fun buildAND3Gate() // Construieste o poarta AND cu 3 intrari
    fun buildAND4Gate() // Construieste o poarta AND cu 4 intrari
    fun buildAND8Gate() // Construieste o poarta AND cu 8 intrari
}

class ConcreteANDBuilder : Builder {
    private var buildResult: ANDGate = ANDGate() // Obiectul care va fi construit

    override fun resetBuild() {
        buildResult = ANDGate() // Reseteaza poarta AND la un obiect gol
    }

    override fun buildAND2Gate() {
        for (i in 1..2) {
            buildResult.addInput() // Adauga 2 intrari la poarta AND
        }
        println("2-inputs AND-Gate was built!") // Afiseaza mesajul
    }

    override fun buildAND3Gate() {
        for (i in 1..3) {
            buildResult.addInput() // Adauga 3 intrari
        }
        println("3-inputs AND-Gate was built!") // Afiseaza mesajul
    }

    override fun buildAND4Gate() {
        for (i in 1..4) {
            buildResult.addInput() // Adauga 4 intrari
        }
        println("4-inputs AND-Gate was built!") // Afiseaza mesajul
    }

    override fun buildAND8Gate() {
        for (i in 1..8) {
            buildResult.addInput() // Adauga 8 intrari
        }
        println("8-inputs AND-Gate was built!") // Afiseaza mesajul
    }

    fun getProductResult(): ANDGate {
        return buildResult // Returneaza poarta construita
    }
}

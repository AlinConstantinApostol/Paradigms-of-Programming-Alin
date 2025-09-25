class ANDGate : LogicGate {
    private var listOfInputs: MutableList<Boolean> = mutableListOf() // Lista de intrari
    private var output: Boolean = false // Rezultatul final al portii
    private var currentState: State = StateFalse() // Starea curenta a portii (initial este false)

    // Adauga o intrare la poarta AND
    override fun addInput() {
        listOfInputs.add(false) // Intrarea se adauga ca false
    }

    // Seteaza o intrare la true
    override fun setTrue(index: Int) {
        try {
            listOfInputs[index] = true
            changeState() // Modifica starea in funcaie de intrarile actualizate
        } catch (e : Exception) {
            // Gestionarea exceptiilor pentru un index invalid
        }
    }

    // Seteaza o intrare la false
    override fun setFalse(index: Int) {
        try {
            listOfInputs[index] = false
            changeState() // Modifica starea in functie de intrarile actualizate
        } catch (e : Exception) {
            // Gestionarea exceptiilor pentru un index invalid
        }
    }

    // Afiseaza lista de intrari
    override fun printInputsList() {
        listOfInputs.forEach {
            print("$it ") // Afiseaza fiecare intrare din lista
        }
    }

    // Schimba starea poraii logice pe baza valorilor din listOfInputs
    override fun changeState() {
        currentState = if (listOfInputs.contains(false)) {
            StateFalse() // Daca exista cel puain un false, starea va fi false
        } else {
            StateTrue() // Daca toate intrarile sunt true, starea va fi true
        }
    }

    // Returneaza rezultatul final al portii AND
    override fun getResult(): Boolean {
        output = currentState is StateTrue // Daca starea este true, output este true, altfel false
        return output
    }
}

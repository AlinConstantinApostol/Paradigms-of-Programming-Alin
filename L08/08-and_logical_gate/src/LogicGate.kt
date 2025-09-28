// Interfata LogicGate care defineste metodele comune pentru orice poarta logica.
interface LogicGate {
    fun addInput() // Adauga o intrare la poarta logica
    fun setTrue(index: Int) // Seteaza valoarea true la o intrare
    fun setFalse(index: Int) // Seteaza valoarea false la o intrare
    fun printInputsList() // Afiseaza lista de intrari
    fun changeState() // Schimba starea portii in functie de intrari
    fun getResult(): Boolean // Returneaza rezultatul final al portii logice
}

class ControlLogicGate(private val logicGate : LogicGate) { // La crearea unui ControlLogicGate, trebuie sa primesti o poarta logica

    // Metoda creaza rezultatul pe baza intrarilor furnizate
    fun createOutput(inputs: List<Boolean>): Boolean {
        var output = false
        inputs.forEachIndexed() { i, it -> // Parcurgem fiecare intrare
            if(it)
                logicGate.setTrue(i) // Daca intrarea este true, seteaza acea intrare la true
            else
                logicGate.setFalse(i) // Daca intrarea este false, seteaza acea intrare la false
        }
        output = logicGate.getResult() // Obtine rezultatul final al portii logice
        return output
    }
}



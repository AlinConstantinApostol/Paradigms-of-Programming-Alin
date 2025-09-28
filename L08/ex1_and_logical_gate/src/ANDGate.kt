
class ANDGate : LogicGate {
    private var listOfInputs: MutableList<Boolean> = mutableListOf()
    private var output: Boolean = false
    private var currentState: State = StateFalse()

    override fun addInput() {
        listOfInputs.add(false)
    }

    override fun setTrue(index: Int) {
        try {
            listOfInputs[index] = true
            changeState()
        } catch (e : Exception) {
            //println("Index $index out of bounds for this type of AND Gate. Last element won't be added.")
        }
    }

    override fun setFalse(index: Int) {
        try {
            listOfInputs[index] = false
            changeState()
        } catch (e : Exception) {
            //println("Index $index out of bounds for this type of AND Gate. Last element won't be added.")
        }
    }

    override fun printInputsList() {
        listOfInputs.forEach {
            print("${it} ")
        }
    }

    override fun changeState() {
        currentState = if (listOfInputs.contains(false)) {
            StateFalse()
        } else {
            StateTrue()
        }
    }

    override fun getResult(): Boolean {
        if(currentState is StateTrue) {
            output = true
        }
        else {
            output = false
        }
        return output
    }

}
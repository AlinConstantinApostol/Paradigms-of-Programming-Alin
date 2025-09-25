interface LogicGate {
    fun addInput()
    fun setTrue(index: Int)
    fun setFalse(index: Int)
    fun printInputsList()
    fun changeState()
    fun getResult(): Boolean
}

class ControlLogicGate(private val logicGate : LogicGate) {

    fun createOutput(inputs: List<Boolean>): Boolean {
        var output = false
        inputs.forEachIndexed() { i,it ->
            if(it)
                logicGate.setTrue(i)
            else
                logicGate.setFalse(i)
        }
        output = logicGate.getResult()
        return output
    }
}


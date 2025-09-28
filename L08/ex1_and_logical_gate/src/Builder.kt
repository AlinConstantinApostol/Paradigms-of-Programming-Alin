interface Builder {
    fun resetBuild()
    fun buildAND2Gate()
    fun buildAND3Gate()
    fun buildAND4Gate()
    fun buildAND8Gate()
}

class ConcreteANDBuilder : Builder {

    private var buildResult: ANDGate = ANDGate()

    override fun resetBuild() {
        buildResult = ANDGate()
    }

    override fun buildAND2Gate() {
        for (i in 1..2) {
            buildResult.addInput()
        }
        println("2-inputs AND-Gate was built!")
    }

    override fun buildAND3Gate() {
        for (i in 1..3) {
            buildResult.addInput()
        }
        println("3-inputs AND-Gate was built!")
    }

    override fun buildAND4Gate() {
        for (i in 1..4) {
            buildResult.addInput()
        }
        println("4-inputs AND-Gate was built!")
    }


    override fun buildAND8Gate() {
        for (i in 1..8) {
            buildResult.addInput()
        }
        println("8-inputs AND-Gate was built!")
    }

    fun getProductResult(): ANDGate {
        return buildResult
    }
}




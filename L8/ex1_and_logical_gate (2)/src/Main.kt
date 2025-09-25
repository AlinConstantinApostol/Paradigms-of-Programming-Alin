fun main() {

    val builder = ConcreteANDBuilder()
    builder.buildAND2Gate()
    val gate = builder.getProductResult()
    val controlGate = ControlLogicGate(gate)

    val list : MutableList<Boolean> = mutableListOf()
    list.add(true)
    list.add(true)
    list.add(false)
    list.add(true)


    println("Output is: " + controlGate.createOutput(list))
    builder.getProductResult().printInputsList()



    /*builder.resetBuild()
    builder.buildAND8Gate()
    gate = builder.getProductResult()
    for (i in 0..7) {
        gate.setTrue(i)
    }
    gate.printInputsList()
    println("\n" + gate.getResult())*/

}


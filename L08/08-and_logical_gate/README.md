AND Gate Builder
Descriere

Această aplicație implementează porți logice AND cu 2, 3, 4 și 8 intrări folosind:

Bridge Pattern – decuplează abstractizarea porții logice (ControlLogicGate) de implementarea efectivă (ANDGate).

Builder Pattern – permite construcția portelor AND cu un număr variabil de intrări.

Finite State Machine (FSM) – starea porții AND (StateTrue / StateFalse) este calculată pe baza intrărilor.

Aplicația permite:

Construirea portelor AND cu diferite numere de intrări

Setarea intrărilor la true sau false

Calcularea rezultatului final al porții
Structura proiectului
ANDGateBuilder/
│
├── out/                     # folder generat automat la compilare
├── src/                     # conține toate fișierele sursă Kotlin
│   ├── Main.kt
│   ├── State.kt
│   ├── LogicGate.kt
│   ├── Builder.kt
│   ├── ANDGate.kt
│
├── .idea/
├── ex1_and_logical_gate.iml
├── .gitignore
Arhitectura și pattern-uri
Bridge

LogicGate – interfața care definește metodele comune pentru orice poartă logică (addInput, setTrue, setFalse, getResult)

ANDGate – implementarea concretă a porții AND

ControlLogicGate – clasă care folosește un obiect LogicGate pentru a calcula rezultatul (decuplarea abstractizare-implementare)

Builder

Builder – interfață pentru construcția porților AND

ConcreteANDBuilder – implementarea Builder, poate construi porți AND cu 2, 3, 4 sau 8 intrări

Metode:

buildAND2Gate()

buildAND3Gate()

buildAND4Gate()

buildAND8Gate()

getProductResult() – returnează obiectul construit

Finite State Machine

State – interfață pentru starea porții

StateTrue / StateFalse – stările posibile ale unei porți AND

ANDGate.changeState() – determină starea porții pe baza intrărilor

Exemplu de utilizare
fun main() {
    val builder = ConcreteANDBuilder()
    builder.buildAND4Gate() // Construiește poarta AND cu 4 intrări

    val gate = builder.getProductResult()
    val controlGate = ControlLogicGate(gate)

    val inputs = mutableListOf(true, false, false, true)
    println("Output is: " + controlGate.createOutput(inputs))

    // Afișarea stării intrărilor
    builder.getProductResult().printInputsList()
}

Output posibil:

4-inputs AND-Gate was built!
Output is: false
true false false true 

Detalii implementare
ANDGate.kt

    Lista de intrări: listOfInputs: MutableList<Boolean>

    Metode:

        addInput() – adaugă intrări default false

        setTrue(index) / setFalse(index) – setează intrarea la true/false

        changeState() – determină starea finală (StateTrue sau StateFalse)

        getResult() – returnează rezultatul logic final

ControlLogicGate (Bridge)

    Primește un obiect LogicGate

    createOutput(inputs: List<Boolean>) – iterează intrările, le setează pe poartă și returnează rezultatul final

ConcreteANDBuilder (Builder)

    Metode de construcție pentru 2, 3, 4 sau 8 intrări


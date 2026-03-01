import TextProcessing.*
import java.io.File


    fun main(args : Array<String>) {
        val text = File("src/data.txt").readText()
        val obj = TextProcessing()

        println(obj.removePunctuation(text) + '\n')
        println(obj.removePunctuation(obj.lowerToUpper(text)) + '\n')
        println(obj.upperToLower(obj.removePunctuation(text)) + '\n')
    }

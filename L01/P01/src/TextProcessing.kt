class TextProcessing {
    fun removePunctuation(text: String): String {
        var modifiedText = text
        for (ch in "!@#$%^&*()-_[]{}:;',.?/")
        {
            modifiedText = modifiedText.replace(ch.toString(),"")
        }
        return modifiedText
    }

    fun upperToLower(text:String):String {
        var modifiedText = text

        for (ch in modifiedText)
        {
            if(ch.isUpperCase())
            {
                modifiedText = modifiedText.replace(ch.toString(), ch.lowercaseChar().toString())
            }
        }

        return modifiedText
    }

    fun lowerToUpper(text:String):String {
        var modifiedText = text

        for (ch in modifiedText)
        {
            if(ch.isLowerCase())
            {
                modifiedText = modifiedText.replace(ch.toString(), ch.uppercaseChar().toString())
            }
        }

        return modifiedText
    }
}
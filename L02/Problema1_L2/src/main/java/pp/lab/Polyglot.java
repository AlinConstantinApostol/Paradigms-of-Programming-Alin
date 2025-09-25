//package pp.lab;
//
//import org.graalvm.polyglot.*;
//import java.util.List;
//import java.util.Arrays;
//import java.util.Map;
//
//class Polyglot
//{
//    // Pastreaza metodele statice pentru acces direct
//    public static String RToUpper(String token) {
//        Context polyglot = Context.newBuilder().allowAllAccess(true).build();
//        Value result = polyglot.eval("ruby", "\"" + token + "\".upcase;");
//        String resultString = result.asString();
//        polyglot.close();
//        return resultString;
//    }
//
//    public static int SumCRC(String token) {
//        Context polyglot = Context.newBuilder().allowAllAccess(true).build();
//        Value result = polyglot.eval("python", "sum(ord(ch) for ch in '" + token + "')");
//        int resultInt = result.asInt();
//        polyglot.close();
//        return resultInt;
//    }
//
//    public static void main(String[] args) {
//
//        Context polyglot = Context.newBuilder().allowAllAccess(true).build();
//        List<String> words = Arrays.asList("Hello", "World", "Java", "Python", "Programming", "Control");
//
//        Value pyModule = polyglot.eval("python", "import sum_control; sum_control");
//
//        Value pyFunction = pyModule.getMember("words_with_same_checksum");
//        Value pyResult = pyFunction.execute(words);
//
//        for(String key : pyResult.getMemberKeys())
//        {
//            System.out.println("Checksum" + key + ": " + pyResult.getMember(key));
//        }
////        for(int i = 0; i < array.getArraySize(); i++){
////            String element = array.getArrayElement(i).asString();
////            // Apelezi metodele statice direct din clasa Polyglot
////            String upper = RToUpper(element);
////            int crc = SumCRC(upper);
////            System.out.println(upper + " -> " + crc);
////        }
//        polyglot.close();
//    }
//}

package pp.lab;

import org.graalvm.polyglot.*; // clasele necesare pentru utilizarea GraalVM Polyglot

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Polyglot {

    // Metoda pentru calculul sumei de control folosind Python
    public static int polynomialChecksum(String text) {
        try (Context polyglot = Context.newBuilder().allowAllAccess(true).build()) { // creaza un context pentru executia codului GraalVM, permitand sa ruleze cod Python
        // bloc try-with-resources => polyglot va fi automat inchis la sfarsitul executarii
        // asigurandu-se ca toate resursele sunt eliberate corespunzator
            String pythonCode =
                    "def polynomial_checksum(text):\n" +
                            "    if len(text) <= 2:\n" +
                            "        return 0\n" +
                            "    text = text[1:-1]\n" +
                            "    return sum((ord(ch) ** 5) % 997 for ch in text)\n" +
                            "\n" +
                            "polynomial_checksum('" + text + "')";

            Value result = polyglot.eval("python", pythonCode); // evalueaza si executa codul Python in interiorul
                                                                          // contextului GraalVM Polyglot, returnand un obiect Value
            return result.asInt(); // convertim rezultatul la int, noua fiindu-ne de folos un keyIndex
        }
    }

    // Metoda pentru gruparea cuvintelor dupa suma de control folosind Python
    public static void wordsWithSameChecksum(List<String> words) {
        try (Context polyglot = Context.newBuilder().allowAllAccess(true).build()) {
            // Cream un sir care reprezinta lista de cuvinte in format Python
            String wordsPythonList = "[" + String.join(", ", words.stream().map(word -> "\"" + word + "\"").toArray(String[]::new)) + "]";
            // stream converteste lista Java intr-un flux de elemente Stream<String> permitand procesarea elementelor din lista folosind operatiuni precum map
            // map -> adauaga pentru fiecare cuvant din lista caracterele " inainte si dupa
            // toArray -> transforma fluxul de elemente intr un array de tip String[]
            // String.join - delimiteaza cuvintele prin virgula
            String pythonCode =
                    "def polynomial_checksum(text):\n" +
                            "    if len(text) <= 2:\n" +
                            "        return 0\n" +
                            "    text = text[1:-1]\n" +
                            "    return sum((ord(ch) ** 5) % 997 for ch in text)\n" +
                            "\n" +
                            "def words_with_same_checksum(words):\n" +
                            "    checksum_dict = {}\n" + // dictionar gol care stocheaza perechei cheie-valoare, cheie care reprezinta checksum
                                                        // o lista de cuvinte care au acelasi checksum
                            "    for word in words:\n" +
                            "        cs = polynomial_checksum(word)\n" +
                            "        if cs in checksum_dict:\n" +
                            "            checksum_dict[cs].append(word)\n" +
                            "        else:\n" +
                            "            checksum_dict[cs] = [word]\n" +
                            "    return checksum_dict\n" +
                            "\n" +
                            "words_with_same_checksum(" + wordsPythonList + ")";  // Folosim lista Python corect formatata

            // Executam codul Python
            Value result = polyglot.eval("python", pythonCode);

            // Iteram prin dicționarul rezultat
            Map<Long, Value> checksumDict = result.as(Map.class); // result -> valoarea returnata de
                                                                  // interpretorul Python
                                                                  // as(Map.class) -> metoda GraalVM converteste rezultatul
                                                                  // value intr-un obiect de tip Java care este un dictionar Python
                                                                  // convertit intr o hartaJava cu cheia Long si valoarea de tip Value
            for (Map.Entry<Long, Value> entry : checksumDict.entrySet()) {
                // Converteste cheia Long in String
                String checksumKey = entry.getKey().toString();  // Conversie de la Long la String
                System.out.println("Checksum " + checksumKey + ": " + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "World", "Java", "Python", "Programming", "Control" , "avaJ");

        // Calculam suma de control pentru fiecare cuvânt
//        for (String word : words) {
//            int checksum = polynomialChecksum(word);
//            System.out.println("Checksum for \"" + word + "\": " + checksum);
//        }

        // Grupam cuvintele dupa suma de control
        wordsWithSameChecksum(words);
    }
}





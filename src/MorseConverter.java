import java.util.HashMap;

public class MorseConverter {

    private String[] morse;
    private String[] alphabet;
    private HashMap<String, String> alphabetToMorse;
    private HashMap<String, String> morseToAlphabet;


    public MorseConverter() {

        morseToAlphabet = new HashMap<>();
        alphabetToMorse = new HashMap<>();

        alphabet = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
                "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".", ",", "?"};

        morse = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
                "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
                "-----", ".-.-.-", "--..--", "..--.."};

        for (int i = 0; i < alphabet.length; i++) {
            alphabetToMorse.put(alphabet[i], morse[i]);
            morseToAlphabet.put(morse[i], alphabet[i]);
        }
    }


    public boolean validateInput(String testdata, int language) {
        String[] englishToValidate = testdata.toLowerCase().split("");
        String[] morseToValidate = testdata.toLowerCase().split("\\s");
        boolean inputCheck = false;

        if (language == 1) {
            for (String item : englishToValidate)
                if (!alphabetToMorse.containsKey(item) && !item.equals(" ")) {
                    inputCheck = true;
                }
        }else {

            for (String item : morseToValidate)
                if (!morseToAlphabet.containsKey(item) && !item.equals(" ")) {
                    inputCheck = true;
                }
        }

        return inputCheck;
    }

    public String convertToMorse(String testdata) {
        String inputToConvert = testdata.replaceAll("\\s","");

        String[] charToConvert = inputToConvert.toLowerCase().split("");
        StringBuilder convertedToMorse = new StringBuilder(); //IntelliJ ändrade från detta String convertedToMorse = "";
        // vilket var bra för då vågade jag mig på denna själv testdata.replaceAll("\\s",""); vad är skillnaden på "\\s" och " ".
        // varför är den ena bättre än den andra. och vilken skillnad gör \s och vad gör + som ibland läggs till? 


        for (int i = 0; i < charToConvert.length; i++) {

                if (i == (charToConvert.length - 1)) {

                    convertedToMorse.append(alphabetToMorse.get(charToConvert[i])); //här tycker IntelliJ att convertedToMorse += alphabetToMorse.get(i); inte är tillräckligt bra

                } else {

                    convertedToMorse.append(alphabetToMorse.get(charToConvert[i])).append(" ");

                }
        }
        return convertedToMorse.toString(); // det här är också IntelliJ som ändrat från convertedToMorse

    }

    public String convertToEnglish(String testdata) {
        String[] charToConvert = testdata.toLowerCase().split("\\s");
        StringBuilder convertedToEnglish = new StringBuilder();

        for (int i = 0; i < charToConvert.length; i++) {

            convertedToEnglish.append(morseToAlphabet.get(charToConvert[i])+ " ");
        }
        return convertedToEnglish.toString();
    }

    public String[] getMorse() {
        return morse;
    }

    public String[] getAlphabet() {
        return alphabet;
    }
}

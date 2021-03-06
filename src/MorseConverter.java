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
        StringBuilder convertedToMorse = new StringBuilder(); //IntelliJ ??ndrade fr??n detta String convertedToMorse = "";
        // vilket var bra f??r d?? v??gade jag mig p?? denna sj??lv testdata.replaceAll("\\s",""); vad ??r skillnaden p?? "\\s" och " ".
        // varf??r ??r den ena b??ttre ??n den andra. och vilken skillnad g??r \s och vad g??r + som ibland l??ggs till? 


        for (int i = 0; i < charToConvert.length; i++) {

                if (i == (charToConvert.length - 1)) {

                    convertedToMorse.append(alphabetToMorse.get(charToConvert[i])); //h??r tycker IntelliJ att convertedToMorse += alphabetToMorse.get(i); inte ??r tillr??ckligt bra

                } else {

                    convertedToMorse.append(alphabetToMorse.get(charToConvert[i])).append(" ");

                }
        }
        return convertedToMorse.toString(); // det h??r ??r ocks?? IntelliJ som ??ndrat fr??n convertedToMorse

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

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MorseConverterTest {

    @Test
    public void test() {

        //arrange

        MorseConverter myObj = new MorseConverter();


        //act


        //assert


    }

    @Test
    public void testConvertToMorse() {

        //arrange

        MorseConverter myObj = new MorseConverter();
        String testdata = "a";


        //act
        String actual = myObj.convertToMorse(testdata);

        //assert
        String expected = ".-";
        assertEquals(expected, actual);

    }

    @Test
    public void testConvertToEnglish() {

        //arrange

        MorseConverter myObj = new MorseConverter();
        String testdata = ".-";


        //act
        String actual = myObj.convertToEnglish(testdata);

        //assert
        String expected = "a ";
        assertEquals(expected, actual);

    }

    @Test
    public void testConvertToMorseDifferentChar() {

        //arrange

        MorseConverter myObj = new MorseConverter();
        String testdata = "b";


        //act
        String actual = myObj.convertToMorse(testdata);

        //assert
        String expected = "-...";
        assertEquals(expected, actual);

    }

    @Test
    public void testGetAlphabet() {

        //arrange

        MorseConverter myObj = new MorseConverter();


        //act
        String[] actual = myObj.getAlphabet();
        for (String item : actual)
            System.out.println(item);
        //assert
        String[] expected = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
                "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".", ",", "?"};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void testGetMorse() {

        //arrange

        MorseConverter myObj = new MorseConverter();


        //act
        String[] actual = myObj.getMorse();
        for (String item : actual)
            System.out.println(item);
        //assert
        String[] expected = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
                "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
                "-----", ".-.-.-", "--..--", "..--.."};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void testConvertWordToMorse() {

        //arrange

        MorseConverter myObj = new MorseConverter();
        String testdata = "hej";


        //act
        String actual = myObj.convertToMorse(testdata);

        //assert
        String expected = ".... . .---";
        assertEquals(expected, actual);


    }

    @Test
    public void testConvert2WordsToMorse() {

        //arrange

        MorseConverter myObj = new MorseConverter();
        String testdata = "hej sos";


        //act
        String actual = myObj.convertToMorse(testdata);

        //assert
        String expected = ".... . .--- ... --- ...";
        assertEquals(expected, actual);


    }

    @Test
    public void testUsingUpperCaseLetter() {

        //arrange

        MorseConverter myObj = new MorseConverter();
        String testdata = "Hej";


        //act
        String actual = myObj.convertToMorse(testdata);

        //assert
        String expected = ".... . .---";
        assertEquals(expected, actual);


    }

   /* @Test
    public void testUsingInvalidAlphabetCharacter() {

        //arrange

        MorseConverter myObj = new MorseConverter();
        String testdata = "hej på";


        //act
        String actual = myObj.convertToMorse(testdata);

        //assert
        String expected = ".... . .--- .---. å";
        assertEquals(expected, actual);


    }*/

    @Test
    public void testValidateInput() {

        //arrange

        MorseConverter myObj = new MorseConverter();
        String testdata = "hej";
        int number = 1;


        //act
        boolean actual = myObj.validateInput(testdata, number);

        //assert
        boolean expected = false;
        assertEquals(expected, actual);


    }

    @Test
    public void testValidateIncorrectInput() {

        //arrange

        MorseConverter myObj = new MorseConverter();
        String testdata = "på";
        int number = 1;


        //act
        boolean actual = myObj.validateInput(testdata, number);

        //assert
        boolean expected = true;
        assertEquals(expected, actual);


    }

    @Test
    public void testValidateInputBlankSpace() {

        //arrange

        MorseConverter myObj = new MorseConverter();
        String testdata = "hej du";
        int number = 1;

        //act
        boolean actual = myObj.validateInput(testdata, number);

        //assert
        boolean expected = false;
        assertEquals(expected, actual);


    }

    @Test
    public void testConvertWordToEnglish() {

        //arrange

        MorseConverter myObj = new MorseConverter();
        String testdata = ".... . .---";


        //act
        String actual = myObj.convertToEnglish(testdata);

        //assert
        String expected = "h e j ";
        assertEquals(expected, actual);

    }

    @Test
    public void testConvert2WordsToEnglish() {

        //arrange

        MorseConverter myObj = new MorseConverter();
        String testdata = ".... . .--- ... --- ...";


        //act
        String actual = myObj.convertToEnglish(testdata);

        //assert
        String expected = "h e j s o s ";
        assertEquals(expected, actual);

    }
}

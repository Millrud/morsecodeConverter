import java.util.Scanner;

public class MorseMain {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        MorseConverter myObj = new MorseConverter();

        // Ask user for language input
        System.out.println("Welcome to this converter");
        System.out.println("Choose to convert from morse code or English");
        System.out.println("(1) English (2) Morse ");
        int number =0;
        boolean choosingLanguage = true;

        while(choosingLanguage)
        try {
            number = Integer.parseInt(scan.nextLine());
            if (number == 1 || number == 2) {
                choosingLanguage = false;
            } else{
                System.out.println("Whoops, you only get to choose between number 1 and 2, try again");
            }
        }catch (Exception e){

            System.out.println("Whoops, you only get to choose between number 1 and 2, try again");
        }

        // two flows one for each language
        // ask for input
        //
        System.out.println("Please type the message you want to transcribe");
        String inputToConvert = scan.nextLine();
        // validate input
        // continue asking until input is valid
        while (myObj.validateInput(inputToConvert, number)) {

            System.out.println("Only use correct values, type again");
            inputToConvert = scan.nextLine();

        }

        // convert input
        //print input
        if (number == 1){
            System.out.println(inputToConvert + " in morse code is: ");
            System.out.println(myObj.convertToMorse(inputToConvert));
            System.out.println("Thank you for using my program");

        }else {
            System.out.println(inputToConvert + " in English is: ");
            System.out.println(myObj.convertToEnglish(inputToConvert));
            System.out.println("Thank you for using my program");
        }




    }


}

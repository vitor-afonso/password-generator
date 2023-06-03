import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***** Welcome to Password Generator *****");

        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        char[] symbols = {'@','#', '$', '%', '&', '!', '^', '?'};
        char[] ambiguous = {'{','}','[',']','(',')','/','\\','*',';',':','.','~',',','<','>'};

        int passwordLength = getPasswordLength();
        boolean shouldIncludeNumbers = getYesOrNoAnswer("Include numbers (y/n): ");
        boolean shouldIncludeSymbols = getYesOrNoAnswer( "Include symbols (@ # $ %) (y/n): ");
        boolean shouldIncludeLowercased = getYesOrNoAnswer("Include lowercased (y/n): "); 
        boolean shouldIncludeUppercased = getYesOrNoAnswer("Include uppercased (y/n): ");
        boolean shouldExcludeAmbiguous = getYesOrNoAnswer("Exclude ambiguous characters ({} [] () /\\ \" ' * ; : . ~ , <> ) (y/n): "); 
        
        Random randomNum = new Random();
        
        String newPass = "";
        while (true) {

            newPass += letters[randomNum.nextInt(letters.length)];
            if(shouldIncludeNumbers){
                newPass += numbers[randomNum.nextInt(numbers.length)];
            }

            if (newPass.length() == passwordLength) {
                System.out.println("generated password =>" + newPass);
                break;
            }
        }


    }

    static int getPasswordLength() throws Exception {
        Scanner scanner = new Scanner(System.in);
        int passwordLength = 0;
        while (true){
            try {
                System.out.print("Please enter password length: ");
                passwordLength = scanner.nextInt();
        
                if (passwordLength > 5 && passwordLength <= 20){
                    return passwordLength;
                }
                System.out.println("-------------------------------------------------------");
                System.out.println("Invalid length! Please enter a number between 6 and 20.");
                System.out.println("-------------------------------------------------------");
            } catch (Exception e) {
                System.out.println("******************************************");
                System.out.println("Invalid type of character!");
                System.out.println("******************************************");
                // Clear scanner buffer
                scanner.nextLine();
            }
        }
    }

    static boolean getYesOrNoAnswer(String question) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String userAnswer;
        while (true){
            System.out.print(question);
            userAnswer = scanner.nextLine();
            
            if (userAnswer.equals("y") || userAnswer.equals("n")){
                return userAnswer.equals("y") ? true : false;
            }
            System.out.println("----------------------------------------");
            System.out.println("Invalid letter! Please enter 'y' or 'n'.");
            System.out.println("----------------------------------------");
        }
    }
}

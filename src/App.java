import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***** Welcome to Password Generator *****");

        int passwordLength = 0;
        while (true){
            try {
                System.out.print("Please enter password length: ");
                passwordLength = scanner.nextInt();
        
                if (passwordLength > 5 && passwordLength <= 20){
                    break;
                }
    
                System.out.println("Invalid length. Please enter a number between 5 and 20");
            } catch (Exception e) {
                System.out.println("******************************************");
                System.out.println("Invalid character! Input must be a number.");
                System.out.println("******************************************");
                // Clear scanner buffer
                scanner.nextLine();
            }
        }

        System.out.println("Getting out!");

    }
}

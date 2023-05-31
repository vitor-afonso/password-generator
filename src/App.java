import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***** Welcome to Password Generator *****");

        int passwordLength = getPasswordLength(scanner);

        String shouldHaveSymbols = getShouldHaveSymbols(scanner);

        System.out.println("Getting out! " + shouldHaveSymbols);

    }

    static int getPasswordLength(Scanner scanner) throws Exception {
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
                System.out.println("Invalid character! Input must be a number.");
                System.out.println("******************************************");
                // Clear scanner buffer
                scanner.nextLine();
            }
        }
    }

    static String getShouldHaveSymbols(Scanner scanner) throws Exception {
        
        while (true){
            try {
                System.out.print("Include symbols (@ # $ %) ? (y/n): ");
                // Clear scanner buffer
                scanner.nextLine();
                String shouldHaveSymbols = scanner.nextLine();

                if (shouldHaveSymbols.equals("y") || shouldHaveSymbols.equals("n")){
                    return shouldHaveSymbols;
                }
                
                System.out.println("-------------------------------------------------------");
                System.out.println("Invalid letter! Please enter 'y' or 'n'.");
                System.out.println("-------------------------------------------------------");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("******************************************");
                System.out.println("Invalid character! Input must be a letter.");
                System.out.println("******************************************");
                // Clear scanner buffer
                scanner.nextLine();
            }
        }
    }
}

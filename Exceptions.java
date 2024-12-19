
import java.util.InputMismatchException;
import java.util.Scanner;


public class Exceptions {
    Scanner scanner = new Scanner(System.in);
    public int check_range(int lower, int upper){
        int choice;
        try {
                choice = scanner.nextInt();
                if (choice < lower || choice > upper) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid choice. Please try again.");
                return -1;
            }catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                return -1;
            }
        return choice;
    }
        
    
}

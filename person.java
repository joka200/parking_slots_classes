
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class person {

    public static void login() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("press 1: to login");
            System.out.println("press 2: to Sign up");
            System.out.println("Press 3: to exit");
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            if (choice == 3) {
                Sign_up.Update_Customer_File();
                Sign_up.Update_bikeSlots_File();
                Sign_up.Update_NormalSlots_File();
                Sign_up.Update_LargeSlots_File();
                System.exit(0);
            } else if (choice == 1) {
                int ans;
                System.out.println("press 1 to log in as an admin ");
                System.out.println("press 2 to log in as user ");
                try {
                    ans = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    continue;
                }
                switch (ans) {
                    case 1:
                        String name,
                         Password;
                        System.out.println("please enter your username");
                        name = scanner.next();
                        System.out.println("please enter your password");
                        Password = scanner.next();
                        if (log_in.login_as_admin(name, Password)) {
                            Admin admin = new Admin();
                            admin.main_menu();
                        } else {
                            continue;
                        }
                        break;
                    case 2:
                        System.out.println("please enter your name");
                        String username;
                        String password;
                        username = scanner.next();
                        System.out.println("please enter your password");
                        password = scanner.next();
                        int index = log_in.login_for_user(username, password);
                        if (index != -1) {
                            main.users.get(index).mainMenu();
                        }
                        break;
                    default:
                        System.out.println("invalid input.");
                        break;
                }
            } else if (choice == 2) {
                Sign_up s = new Sign_up();
                s.Registration_user();
            } else {
                System.out.println("Invalid input");
                continue;
            }
        }
    }

}

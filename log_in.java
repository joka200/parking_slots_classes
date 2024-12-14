package youssef;
import java.lang.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
public class log_in {

    private static final String name = "Admin";
    private static final String password = "Admin";

    //  boolean islogedin;


    public static boolean login_as_admin(String enterdname, String enterdpassword) {
        if (Admin.name.equals(name) && Admin.password.equals(password)) {
            System.out.println("log in successfully");
            return true;
        } else {
            System.out.println("login failed");
            return false;

        }
    }
    public static void loadcostumerFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("registration.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userInfo = line.split(" ");

                Customer user = new Customer(
                        (userInfo[0]),
                        userInfo[1],
                        userInfo[2],
                        userInfo[3],
                        userInfo[4],
                        userInfo[5],
                        userInfo[6]

                );
                Main.customer_data.add(user);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static int login_for_user (String username,String password){

        for (int i = 0; i < 10; i++) {
            if (main.users.get(i).getName().equals(username) && main.users.get(i).getName().equals(password)) {

                System.out.println("Login successful. Welcome, " + main.users.get(i).getName());
                return i;
            }
        }
        System.out.println("Login failed. user: " + username + " not found.");
        return -1;

    }

    public static boolean isvalid_user_id (String filePath, String enteredUserId) {
        Path codes = Paths.get(filePath);
        try {
            for (String fileids : Files.readAllLines(codes)) {
                if (enteredUserId.equals(fileids.trim())) {
                    return true; // id is correct
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}

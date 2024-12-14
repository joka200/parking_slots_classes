package youssef;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Sign_up {

    private int id;
    private String name;
    private String password;
    private String e_mail;
    private int Phone_number;
    private int age;
    private String address;
    private String gender;
    
    public void Registration_user() {
        boolean wronganswer = true;
        while (wronganswer) {
            wronganswer = false;
            try {
                Scanner input = new Scanner(System.in);
                System.out.println("please enter your name");
                name = input.next();
                System.out.println("please enter your password");
                password = input.next();
                System.out.println("please enter your e-mail");
                e_mail = input.next();
                System.out.println("please enter your phone number");
                Phone_number = input.nextInt();
                System.out.println("please enter your address");
                address = input.next();
                System.out.println("please enter your age");
                age = input.nextInt();
                System.out.println("please enter your gender");
                gender = input.next();
                id = user.starting_id;
                main.users.add(new user(name, password,e_mail,Phone_number, age,address, gender,id));
                System.out.println("you have registered your account successfully");
                System.out.println("Now you can login");
            } catch (InputMismatchException e) {
                System.out.println("Input invalid");
                wronganswer = true;
            }
        }
    }
}

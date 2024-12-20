

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
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
    
    public void Registration_user()
    {
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
                user.starting_id++;
                System.out.println("you have registered your account successfully");
                System.out.println("Now you can login");
            } catch (InputMismatchException e) {
                System.out.println("Input invalid");
                wronganswer = true;
            }
        }
    }
    public static void Update_Customer_File()
    {
        try
        {
            BufferedWriter writer = Files.newBufferedWriter
                    (
                    Path.of("C:/Users/Lenovo/Documents/users.txt"),
                    StandardOpenOption.WRITE,
                    StandardOpenOption.TRUNCATE_EXISTING
                    );

            for(int i=0;i<main.users.size();i++)
            {
                writer.write(String.valueOf(
                        main.users.get(i).getName() + " " +
                        main.users.get(i).getPassword() + " " +
                        main.users.get(i).getE_mail() + " " +
                        main.users.get(i).getPhone_number() + " " +
                        main.users.get(i).getAge() + " " +
                        main.users.get(i).getAddress() + " " +
                        main.users.get(i).getGender() + " " +
                        main.users.get(i).getId() + " " + 
                        main.users.get(i).getFees() + " "+
                        main.users.get(i).getCancelationFees() + " "+
                        main.users.get(i).getNumberOfVehicles() + " "+
                        user.number_of_bike_reserved_slots + " "+
                        user.number_of_normal_reserved_slots + " "+
                        user.number_of_large_reserved_slots + " "+
                        user.starting_id + " "));
                for(int j = 0;j<main.users.get(i).vehicle.size();j++)
                {
                    writer.write(main.users.get(i).vehicle.get(j).getName() + " " +
                                    main.users.get(i).vehicle.get(j).getType() + " " +
                                    main.users.get(i).vehicle.get(j).getLicenes_number() + " " +
                                    main.users.get(i).vehicle.get(j).getFree_hours() + " " +
                                    main.users.get(i).vehicle.get(j).getHours() + " " +
                                    main.users.get(i).vehicle.get(j).isThere_is_reservation() + " " +
                                    main.users.get(i).vehicle.get(j).getReservationdate() + " " +
                                    main.users.get(i).vehicle.get(j).getReservationtime() + " " +
                                    main.users.get(i).vehicle.get(j).getSlot_number() + " ");
                    
                }
                writer.newLine();
            }
            writer.flush();
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public static void Update_bikeSlots_File()
    {
        try
        {
            BufferedWriter writer = Files.newBufferedWriter
                    (
                    Path.of("C:/Users/Lenovo/Documents/bike.txt"),
                    StandardOpenOption.WRITE,
                    StandardOpenOption.TRUNCATE_EXISTING
                    );

            
                writer.write(String.valueOf(
                        bike.getSlots() + " "
                        ));
                for(int j = 0;j<bike.slotsArray.size();j++)
                {
                    writer.write(bike.slotsArray.get(j).getTime() + " " +
                                bike.slotsArray.get(j).getDate() + " " +
                                bike.slotsArray.get(j).getFees() + " " 
                                    );
                }
                writer.newLine();
            
            writer.flush();
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
     public static void Update_NormalSlots_File()
    {
        try
        {
            BufferedWriter writer = Files.newBufferedWriter
                    (
                    Path.of("C:/Users/Lenovo/Documents/normal.txt"),
                    StandardOpenOption.WRITE,
                    StandardOpenOption.TRUNCATE_EXISTING
                    );

            
                writer.write(String.valueOf(
                        car.getSlots()+ " "
                        ));
                for(int j = 0;j<car.slotsArray.size();j++)
                {
                    writer.write(car.slotsArray.get(j).getTime() + " " +
                                car.slotsArray.get(j).getDate() + " " +
                                car.slotsArray.get(j).getFees() + " " 
                                    );
                }
                writer.newLine();
            
            writer.flush();
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
      public static void Update_LargeSlots_File()
    {
        try
        {
            BufferedWriter writer = Files.newBufferedWriter
                    (
                    Path.of("C:/Users/Lenovo/Documents/large.txt"),
                    StandardOpenOption.WRITE,
                    StandardOpenOption.TRUNCATE_EXISTING
                    );

            
                writer.write(String.valueOf(
                        fourByFour.getSlots()+ " "
                        ));
                for(int j = 0;j<fourByFour.slotsArray.size();j++)
                {
                    writer.write(fourByFour.slotsArray.get(j).getTime() + " " +
                                fourByFour.slotsArray.get(j).getDate() + " " +
                                fourByFour.slotsArray.get(j).getFees() + " " 
                                    );
                }
                writer.newLine();
            
            writer.flush();
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
}

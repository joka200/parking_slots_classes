
import java.lang.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class log_in {

    private static final String name = "admin";
    private static final String password = "admin";

    //  boolean islogedin;
    public static boolean login_as_admin(String entered_name, String entered_password) {
        if (entered_name.equals(name) && entered_password.equals(password)) {
            System.out.println("log in successfully");
            return true;
        } else {
            System.out.println("login failed");
            return false;
        }
    }

    public static int login_for_user(String username, String password) {

        for (int i = 0; i < main.users.size(); i++) {
            if (main.users.get(i).getName().equals(username) && main.users.get(i).getPassword().equals(password)) {

                System.out.println("Login successful. Welcome, " + main.users.get(i).getName());
                return i;
            }
        }
        System.out.println("Login failed. user: " + username + " not found.");
        return -1;

    }

    public static void load_user_From_File() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Lenovo/Documents/users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userInfo = line.split(" ");

                user userr = new user(
                        userInfo[0],
                        userInfo[1],
                        userInfo[2],
                        Integer.parseInt(userInfo[3]),
                        Integer.parseInt(userInfo[4]),
                        userInfo[5],
                        userInfo[6],
                        Integer.parseInt(userInfo[7])
                );
                userr.setFees(Integer.parseInt(userInfo[8]));
                userr.setCancelationFees(Integer.parseInt(userInfo[9]));
                userr.setNumberOfVehicles(Integer.parseInt(userInfo[10]));
                user.number_of_bike_reserved_slots = Integer.parseInt(userInfo[11]);
                user.number_of_normal_reserved_slots = Integer.parseInt(userInfo[12]);
                user.number_of_large_reserved_slots = Integer.parseInt(userInfo[13]);
                user.starting_id = Integer.parseInt(userInfo[14]);
                int n = 15;
                for (int i = 0; i < userr.getNumberOfVehicles(); i++) {
                    if (userInfo[n + 1].equals("Bike")) {
                        vehicles v = new bike(
                                userInfo[n],
                                userInfo[n + 1],
                                userInfo[n + 2]
                        );
                        v.setFree_hours(Integer.parseInt(userInfo[n + 3]));
                        v.setHours(Integer.parseInt(userInfo[n + 4]));
                        v.setThere_is_reservation(Boolean.parseBoolean(userInfo[n + 5]));
                        v.setReservationdate(Integer.parseInt(userInfo[n + 6]));
                        v.setReservationtime(Integer.parseInt(userInfo[n + 7]));
                        v.setSlot_number(Integer.parseInt(userInfo[n + 8]));
                        n += 9;
                        userr.vehicle.add(v);
                    } else if (userInfo[n + 1].equals("Car")) {
                        vehicles v = new car(
                                userInfo[n],
                                userInfo[n + 1],
                                userInfo[n + 2]
                        );
                        v.setFree_hours(Integer.parseInt(userInfo[n + 3]));
                        v.setHours(Integer.parseInt(userInfo[n + 4]));
                        v.setThere_is_reservation(Boolean.parseBoolean(userInfo[n + 5]));
                        v.setReservationdate(Integer.parseInt(userInfo[n + 6]));
                        v.setReservationtime(Integer.parseInt(userInfo[n + 7]));
                        v.setSlot_number(Integer.parseInt(userInfo[n + 8]));
                        n += 9;
                        userr.vehicle.add(v);
                    } else {
                        vehicles v = new fourByFour(
                                userInfo[n],
                                userInfo[n + 1],
                                userInfo[n + 2]
                        );
                        v.setFree_hours(Integer.parseInt(userInfo[n + 3]));
                        v.setHours(Integer.parseInt(userInfo[n + 4]));
                        v.setThere_is_reservation(Boolean.parseBoolean(userInfo[n + 5]));
                        v.setReservationdate(Integer.parseInt(userInfo[n + 6]));
                        v.setReservationtime(Integer.parseInt(userInfo[n + 7]));
                        v.setSlot_number(Integer.parseInt(userInfo[n + 8]));
                        n += 9;
                        userr.vehicle.add(v);
                    }
                }

                main.users.add(userr);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void load_bikeSlots_From_File() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Lenovo/Documents/bike.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userInfo = line.split(" ");

                bike.setSlot(Integer.parseInt(userInfo[0]));
                bike.setAvailable_slots(Integer.parseInt(userInfo[1]));
                int n = 2;
                for (int i = 0; i < bike.getSlot(); i++) {
                    slots s = new slots(
                            Integer.parseInt(userInfo[n]),
                            Integer.parseInt(userInfo[n + 1]),
                            Double.parseDouble(userInfo[n + 2])
                    );
                    n += 3;
                    bike.slotsArray.add(s);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void load_NormalSlots_From_File() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Lenovo/Documents/normal.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userInfo = line.split(" ");

                car.setSlot(Integer.parseInt(userInfo[0]));
                car.setAvailable_slots(Integer.parseInt(userInfo[1]));
                int n = 2;
                for (int i = 0; i < car.getSlot(); i++) {
                    slots s = new slots(
                            Integer.parseInt(userInfo[n]),
                            Integer.parseInt(userInfo[n + 1]),
                            Double.parseDouble(userInfo[n + 2])
                    );
                    n += 3;
                    car.slotsArray.add(s);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void load_LargeSlots_From_File() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Lenovo/Documents/large.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userInfo = line.split(" ");

                fourByFour.setSlot(Integer.parseInt(userInfo[0]));
                fourByFour.setAvailable_slots(Integer.parseInt(userInfo[1]));
                int n = 2;
                for (int i = 0; i < fourByFour.getSlot(); i++) {
                    slots s = new slots(
                            Integer.parseInt(userInfo[n]),
                            Integer.parseInt(userInfo[n + 1]),
                            Double.parseDouble(userInfo[n + 2])
                    );
                    n += 3;
                    fourByFour.slotsArray.add(s);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

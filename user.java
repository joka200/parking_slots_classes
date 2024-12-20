
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class user extends person {

    private String name;
    private String password;
    private String e_mail;
    private int Phone_number;
    private int age;
    private String address;
    private String gender;
    private static final int max_vehicles = 3;
    private int id;
    private int fees = 0;
    private int CancelationFees = 0;
    private int numberOfVehicles = 0;
    public ArrayList<vehicles> vehicle = new ArrayList<>();
    public static int number_of_bike_reserved_slots = 0;
    public static int number_of_normal_reserved_slots = 0;
    public static int number_of_large_reserved_slots = 0;
    public static int starting_id = 100;

    Scanner scanner = new Scanner(System.in);

    public user(String name, String password, String e_mail, int Phone_number, int age, String address, String gender, int id) {
        this.name = name;
        this.password = password;
        this.e_mail = e_mail;
        this.Phone_number = Phone_number;
        this.age = age;
        this.address = address;
        this.gender = gender;
        this.id = id;
    }

    public void setCancelationFees(int CancelationFees) {
        this.CancelationFees = CancelationFees;
    }

    public void setNumberOfVehicles(int numberOfVehicles) {
        this.numberOfVehicles = numberOfVehicles;
    }
    

    public String getE_mail() {
        return e_mail;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
    

    public int getPhone_number() {
        return Phone_number;
    }

    public String getAddress() {
        return address;
    }

    
    
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }
    

    public int getCancelationFees() {
        return CancelationFees;
    }

    public int getNumberOfVehicles() {
        return numberOfVehicles;
    }

    public void mainMenu() {
        while (true) {
            System.out.println("Welcome to the Reservation System ");
            System.out.println("Please choose an option:");
            System.out.println("1.Add a Vehicle");
            System.out.println("2. Make a Reservation");
            System.out.println("3. Cancel a Reservation");
            System.out.println("4. Update a Reservation");
            System.out.println("5. Display Available Slots");
            System.out.println("6. Calculate Payment");
            System.out.println("7. Logout");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addVehicle();
                    break;
                case 2:
                    Reservation();
                    break;
                case 3:
                    CancelReservation();
                    break;
                case 4:
                    updatereservation();
                    break;
                case 5:
                    displayAvailableSlots();
                    break;
                case 6:
                    calculatePayment();
                    break;
                case 7:
                    System.out.println("logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    public void addVehicle() {
        String back;
        if (numberOfVehicles >= max_vehicles) {
            System.out.println("You have reached the maximum number of vehicles.");
            return;
        }

        System.out.println("Enter the vehicle name:");
        String name = scanner.next();

        System.out.println("Enter the license number:");
        String licenseNumber = scanner.next();

        String type = selectVehicleType();
        System.out.println("Press C if you want to add this vehicle otherwise press any other letter to return to the main menu");
        back = scanner.next();
        if (!back.toUpperCase().equals("C")) {
            return;
        }
        switch (type) {
            case "Bike":
                vehicles vbike = new bike(name, type, licenseNumber);
                vehicle.add(vbike);
                break;
            case "Car":
                vehicles vcar = new car(name, type, licenseNumber);
                vehicle.add(vcar);
                break;
            case "Four By Four":
                vehicles vfbf = new fourByFour(name, type, licenseNumber);
                vehicle.add(vfbf);
                break;
        }
        numberOfVehicles++;
        System.out.println("Vehicle added successfully.");
    }

    public void Reservation() {
        System.out.println("Press the number of the spot");
        boolean largespot = false;
        boolean normalspot = false;
        boolean bikespot = false;
        int bikeidchoice = 0;
        int caridchoice = 0;
        int fbfidchoice = 0;
        int j = 1;
        if (vehicle.size() == 0) {
            System.out.println("There is no vehicles to  select");
            return;
        }
        for (int i = 0; i < vehicle.size(); i++) {

            if (vehicle.get(i).getType().equals("Bike")) {
                if (bikespot) {
                    continue;
                }
                bikespot = true;
                System.out.println(j + "." + "Bike spot");
                bikeidchoice = j;
                j++;
            } else if (vehicle.get(i).getType().equals("Car")) {
                if (normalspot) {
                    continue;
                }
                normalspot = true;
                System.out.println(j + "." + "Normal spot");
                caridchoice = j;
                j++;
            } else if (vehicle.get(i).getType().equals("Four By Four")) {
                if (largespot) {
                    continue;
                }
                largespot = true;
                System.out.println(j + "." + "Large spot");
                fbfidchoice = j;
                j++;
            }
        }

        int choice1;
        boolean rightchoice;
        String back = "C";
        do {
            rightchoice = true;
            Exceptions e = new Exceptions();
            choice1 = e.check_range(1, vehicle.size());
            if (choice1 == -1) {
                rightchoice = false;
                System.out.println("Press C if you want to reenter your choice otherwise press any other letter to return to the main menu");
                back = scanner.next();
            }
            if (!back.toUpperCase().equals("C")) {
                return;
            }

        } while (back.toUpperCase().equals("C") && !rightchoice);
        int check;
        if (choice1 == bikeidchoice) {
            check = bike.check_availability();
        } else if (choice1 == caridchoice) {
            check = car.check_availability();
        } else {
            check = fourByFour.check_availability();
        }
        if (check == 1) {
            return;
        }
        int choice2;
        do {
            rightchoice = true;
            choice2 = selectVehicle();
            if (vehicle.get(choice2).isThere_is_reservation()) {
                rightchoice = false;
                System.out.println("This vehicle already has a reservation");
                System.out.println("Press C if you want to reenter other vehicle choice otherwise press any other letter to return to the main menu");
                back = scanner.next();
            } else if (choice1 == bikeidchoice && !vehicle.get(choice2).getType().equals("Bike")) {
                rightchoice = false;
                System.out.println("You must enter a valid vehicle that is suitable for the type of spots you need");
                System.out.println("Press C if you want to reenter your vehicle choice otherwise press any other letter to return to the main menu");
                back = scanner.next();
            } else if (choice1 == caridchoice && !vehicle.get(choice2).getType().equals("Car")) {
                rightchoice = false;
                System.out.println("You must enter a valid vehicle that is suitable for the type of spots you need");
                System.out.println("Press C if you want to reenter your vehicle choice otherwise press any other letter to return to the main menu");
                back = scanner.next();
            } else if (choice1 == fbfidchoice && !vehicle.get(choice2).getType().equals("Four By Four")) {
                rightchoice = false;
                System.out.println("You must enter a valid vehicle that is suitable for the type of spots you need");
                System.out.println("Press C if you want to reenter your vehicle choice otherwise press any other letter to return to the main menu");
                back = scanner.next();
            }
            if (!back.toUpperCase().equals("C")) {
                return;
            }
        } while (back.toUpperCase().equals("C") && !rightchoice);
        do {
            Scanner input = new Scanner(System.in);
            int day;
            int time;
            rightchoice = true;
            System.out.println("Enter the Day you want the reservation at");
            try{
            day = input.nextInt();
            }catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            System.out.println("Enter the Time you want the reservation at");
            try{
            time = input.nextInt();
            }catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            if (vehicle.get(choice2).addDateandTime(day, time) == 1) {
                rightchoice = false;
                System.out.println("Please Enter a valid day that don't exceeds 3 days from today");
                System.out.println("Press C if you want to reenter the day of the redervation or otherwise press any other letter to return to the main menu");
                back = scanner.next();
            } else if (vehicle.get(choice2).addDateandTime(day, time) == 2) {
                rightchoice = false;
                System.out.println("Please Enter a valid time");
                System.out.println("Press C if you want to reenter the time of the redervation or otherwise press any other letter to return to the main menu");
                back = scanner.next();
            }
            if (!back.toUpperCase().equals("C")) {
                return;
            }
        } while (back.toUpperCase().equals("C") && !rightchoice);
        do {
            Scanner input = new Scanner(System.in);
            rightchoice = true;
            System.out.println("Please enter the hours you want the reservation to be");
            int hours;
            try{
            hours = input.nextInt();
            }catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            if (vehicle.get(choice2).addhours(hours) == 1) {
                rightchoice = false;
                System.out.println("Please Enter a valid number of hours");
                System.out.println("Press C if you want to reenter hours of the redervation or otherwise press any other letter to return to the main menu");
                back = scanner.next();
            }
            if (!back.toUpperCase().equals("C")) {
                return;
            }
        } while (back.toUpperCase().equals("C") && !rightchoice);
        vehicle.get(choice2).setFree_hours(reward(choice2));
        vehicle.get(choice2).ConfirmReservation();
        calculatePayment();
    }

    public void CancelReservation() {
        System.out.println("Here is the vehicles that have reservation");
        int indexofelement = selectReservedVehicle();
        if (indexofelement == -1) {
            System.out.println("There is no Reservations to cancel");
            return;
        }
        vehicle.get(indexofelement).setHours(0);
        vehicle.get(indexofelement).setFree_hours(0);
        vehicle.get(indexofelement).setReservationdate(0);
        vehicle.get(indexofelement).setReservationtime(0);
        CancelationFees += 10;
        vehicle.get(indexofelement).ConfirmCancelation();
        calculatePayment();
    }

    public void updatereservation() {
        System.out.println("Here is the vehicles that have reservation");
        int indexofelement;
        boolean rightchoice;
        String back = "C";
        indexofelement = selectReservedVehicle();
        if (indexofelement == -1) {
            System.out.println("There is no Reservations to update");
            return;
        }

        int sel;
        do {
            System.out.println("1.date " + vehicle.get(indexofelement).getReservationdate() +  " /12/2024");
            System.out.println("2.time " + vehicle.get(indexofelement).getReservationdate() + ":00");
            System.out.println("3.hours " + vehicle.get(indexofelement).getHours());
            System.out.println("Select the number for which you want to update");
            rightchoice = true;
            Exceptions e = new Exceptions();
            sel = e.check_range(1, 3);
            if (sel == -1) {
                rightchoice = false;
                System.out.println("Press C if you want to reenter your choice otherwise press any other letter to return to the main menu");
                back = scanner.next();
            }
            if (!back.toUpperCase().equals("C")) {
                return;
            }
        } while (back.toUpperCase().equals("C") && !rightchoice);
        if (sel == 1) {
            int day;
            do {
                rightchoice = true;
                System.out.println("Enter the Day you want the reservation at");
                day = scanner.nextInt();
                if (vehicle.get(indexofelement).addDateandTime(day, vehicle.get(indexofelement).getReservationtime()) == 1) {
                    rightchoice = false;
                    System.out.println("Please Enter a valid day that don't exceeds 3 days from today");
                    System.out.println("Press C if you want to reenter the day of the reservation or otherwise press any other letter to return to the main menu");
                    back = scanner.next();
                }
                if (!back.toUpperCase().equals("C")) {
                    return;
                }
            } while (back.toUpperCase().equals("C") && !rightchoice);
        } else if (sel == 2) {
            int time;
            System.out.println("Enter the Time you want the reservation at");
            do {
                time = scanner.nextInt();
                rightchoice = true;
                if (vehicle.get(indexofelement).addDateandTime(vehicle.get(indexofelement).getReservationdate(), time) == 2) {
                    rightchoice = false;
                    System.out.println("Please Enter a valid time");
                    System.out.println("Press C if you want to reenter the time of the reservation or otherwise press any other letter to return to the main menu");
                    back = scanner.next();
                    if (!back.toUpperCase().equals("C")) {
                        return;
                    }

                }
            } while (back.toUpperCase().equals("C") && !rightchoice);
        }else{
            int hourss;
            System.out.println("Enter the Hours of the reservation");
            do {
                hourss = scanner.nextInt();
                rightchoice = true;
                if (vehicle.get(indexofelement).addhours(hourss)==1) {
                    rightchoice = false;
                    System.out.println("Please Enter a valid Number of hours");
                    System.out.println("Press C if you want to reenter the time of the reservation or otherwise press any other letter to return to the main menu");
                    back = scanner.next();
                    if (!back.toUpperCase().equals("C")) {
                        return;
                    }

                }
            } while (back.toUpperCase().equals("C") && !rightchoice);
        }
            
        calculatePayment();
    }

    public void displayAvailableSlots() {
        boolean largespot = false;
        boolean normalspot = false;
        boolean bikespot = false;
        if(vehicle.size()==0){
            System.out.println("You have no vehicle to display available slots for their type");
        }
        for (int i = 0; i < vehicle.size(); i++) {
            if (vehicle.get(i).getType().equals("Bike")) {
                if (bikespot) {
                    continue;
                }
                bikespot = true;
                System.out.println("Available bike slots are: " + bike.getAvailable_slots());
            } else if (vehicle.get(i).getType().equals("Car")) {
                if (normalspot) {
                    continue;
                }
                normalspot = true;
                System.out.println("Available Normal slots are: " + car.getAvailable_slots());
            } else {
                if (largespot) {
                    continue;
                }
                largespot = true;
                System.out.println("Available Large slots are: " + fourByFour.getAvailable_slots());
            }
        }
    }

    public int reward(int index) {
        int hours = vehicle.get(index).getHours();
        int reward = 0;
        while (hours > 0) {
            if (hours - 6 >= 0) {
                reward++;
            }
            hours -= 6;
        }
        return reward;
    }

    public void calculatePayment() {
        int j = 1;
        fees = 0;
        for (int i = 0; i < vehicle.size(); i++) {
            int payment = 0;
            if (vehicle.get(i).isThere_is_reservation()) {
                vehicle.get(i).setFree_hours(reward(i));
                System.out.println(j + "." + vehicle.get(i).getName());
                System.out.println("Hours: " + vehicle.get(i).getHours());
                System.out.println("Free Hours: " + vehicle.get(i).getFree_hours());
                if (vehicle.get(i).getType().equals("Bike")) {
                    payment = (vehicle.get(i).getHours() - vehicle.get(i).getFree_hours()) * bike.getPrice();
                    System.out.println("Payment: " + payment);
                } else if (vehicle.get(i).getType().equals("Car")) {
                    payment = (vehicle.get(i).getHours() - vehicle.get(i).getFree_hours()) * car.getPrice();
                    System.out.println("Payment: " + payment);
                } else if (vehicle.get(i).getType().equals("Four By Four")) {
                    payment = (vehicle.get(i).getHours() - vehicle.get(i).getFree_hours()) * fourByFour.getPrice();
                    System.out.println("Payment: " + payment);
                }
                fees += payment;

            }
        }
        if (CancelationFees > 0) {
            System.out.println("Cancelation Fees: " + CancelationFees);
        }
        System.out.println("Total Payment: " + (fees + CancelationFees));
        return;
    }

    public int selectVehicle() {

        boolean wrongchoice;
        int choice = 0;
        do {
            wrongchoice = false;

            System.out.println("Choose the number of the vehicle");
            for (int i = 0; i < vehicle.size(); i++) {
                System.out.println((i + 1) + ". " + vehicle.get(i).getName() + " (License: " + vehicle.get(i).getLicenes_number() + ")");
            }
            Exceptions e = new Exceptions();
            choice = e.check_range(1, vehicle.size());
            if (choice == -1) {
                wrongchoice = true;
            }

        } while (wrongchoice);
        return choice - 1;

    }

    public int selectReservedVehicle() {

        boolean wrongchoice;
        int choice;
        int indexofelement = 0;
        do {
            wrongchoice = false;
            int j = 1;
            for (int i = 0; i < vehicle.size(); i++) {
                if (vehicle.get(i).isThere_is_reservation()) {
                    System.out.println(j + ". " + vehicle.get(i).getName() + " (License: " + vehicle.get(i).getLicenes_number() + ")");
                    j++;
                }
            }
            if (j == 1) {
                return -1;
            }
            System.out.println("Select The vehicle");
            Exceptions e = new Exceptions();
            choice = e.check_range(1, j - 1);
            if (choice == -1) {
                wrongchoice = true;
                continue;
            }
            for (int i = 0; i < vehicle.size(); i++) {
                if (vehicle.get(i).isThere_is_reservation()) {
                    indexofelement++;
                    if (choice == indexofelement) {
                        indexofelement = i;
                        break;
                    }
                }
            }

        } while (wrongchoice);
        return indexofelement;

    }

    private String selectVehicleType() {
        boolean wrongchoice = false;
        do {
            System.out.println("Select the vehicle type:");
            System.out.println("1. Bike");
            System.out.println("2. Car");
            System.out.println("3. Four By Four");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    return "Bike";
                case 2:
                    return "Car";
                case 3:
                    return "Four By Four";
                default:
                    wrongchoice = true;
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (wrongchoice);
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        user otheruser = (user) obj;
        if (this.id == otheruser.id) {
            return true;
        }
        return false;
    }

}

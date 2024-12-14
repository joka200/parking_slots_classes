package youssef;

import java.util.Scanner;

public class Admin extends person {
    public static final String name = "admin";
    public static final String password = "admin";

    Scanner scanner = new Scanner(System.in);
    
    public void main_menu(){
        while (true) {
            System.out.println("1. Add Slots");
            System.out.println("2. Delete an Entity");
            System.out.println("3. Display All Available Slots for All Spots");
            System.out.println("4. Display All Owners' Data");
            System.out.println("5. Display All Spots Data");
            System.out.println("6. Calculate and Display Total Money from Normal Spot Reservations");
            System.out.println("7. Calculate and Display Total Money from Bike Spot Reservations");
            System.out.println("8. Calculate and Display Total Money from Large Spot Reservations");
            System.out.println("9. Update Any Data of Any Entity");
            System.out.println("10. Logout");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    add_slot();  
                    break;
                case 2:
                    Delete_entity();  
                    break;
                case 3:
                    Display_Available_slots();  
                    break;
                case 4:
                    Display_all_owner_data();
                    break;
                case 5:
                    Dipslay_spots();
                    break;
                case 6:
                    Display_normal_spot_total_amount();
                    break;
                case 7:
                    Display_bike_spot_total_amount();
                    break;
                case 8:
                    Display_large_spot_total_amount();  
                    break;
                case 9:
                    update_data(); 
                    break;
                case 10:
                    System.out.println("logging out....");
                    return;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 10.");
                    break;
            }
        }
    }

    public void add_slot() {
        String ans1;
        slots slot = new slots();
        int ans2;
        System.out.println("Which spot kind do you want to add slots to: ( bike | normal | large )");
        ans1 = scanner.nextLine();
        System.out.println("Which spot id do you want to add slots to: 200 | 201 | 202");
        ans2 = scanner.nextInt();
        System.out.println("How many slots you want to add");
        int ans3 = scanner.nextInt();

        if (ans1.toLowerCase().equals("bike")) {
            if (ans2 == bike.getSpot_id()) {
                for (int i = 0; i < ans3; i++) {
                    bike.addslots();
                    bike.setSlots(bike.getSlots() + 1);
                }
            } else {
                System.out.println("Invalid id");
                return;
            }
        } else if (ans1.toLowerCase().equals("car")) {
            if (ans2 == car.getSpot_id()) {
                for (int i = 0; i < ans3; i++) {

                    car.addslots();
                    car.setSlots(car.getSlots() + 1);

                }
            } else {
                System.out.println("Invalid id");
                return;
            }
        } else if (ans1.toLowerCase().equals("4*4")) {
            if (ans2 == bike.getSpot_id()) {
                for (int i = 0; i < ans3; i++) {

                    fourByFour.addslots();
                    fourByFour.setSlots(fourByFour.getSlots() + 1);

                }
            } else {
                System.out.println("Invalid id");
                return;
            }
        } else {
            System.out.println("Invalid type");
        }
    }

    public void Delete_entity() {
        int choice;
        int choice2;
        int index = 0;
        String choice3;
        int choice4;
        System.out.println("Select the entity you want to delete");
        System.out.println("1.User");
        System.out.println("2.Vehicle");
        System.out.println("3.Reservation");
        System.out.println("4.Available slot");
        System.out.println("5.Return to main menu");
        Exceptions e = new Exceptions();
        choice = e.check_range(1, 5);
        if (choice == -1) {
            System.out.println("Invalid choice");
            return;
        }
        switch (choice) {
            case 1:
                System.out.println("Enter the id of the user you want to delete");
                choice2 = scanner.nextInt();
                index = main.users.indexOf(new user(" ", " "," ",0,0," "," ", choice2));
                if (index == -1) {
                    System.out.println("Id not found");
                    return;
                }
                System.out.println("Owner Name: " + main.users.get(index).getName());
                System.out.println("Owner ID: " + main.users.get(index).getId());
                System.out.println("Owner Total Fees: " + main.users.get(index).getFees());
                for (int j = 0; j < main.users.get(index).vehicle.size(); j++) {
                    System.out.println("Vehicles: ");
                    System.out.print(j + ". " + main.users.get(index).vehicle.get(j).getName() + " (License: " + main.users.get(index).vehicle.get(j).getLicenes_number());
                    if (main.users.get(index).vehicle.get(j).There_is_reservation) {
                        System.out.print(" Reservation date: " + main.users.get(index).vehicle.get(j).getReservationdate() + "/12/2024");
                        System.out.print(" Reservation time: " + main.users.get(index).vehicle.get(j).getReservationtime() + ":00");
                        System.out.print(" Reservation hours " + main.users.get(index).vehicle.get(j).getHours());
                    }

                }
                System.out.println(" ");
                System.out.println("Are you sure you want to delete this user? Y/N");
                choice3 = scanner.next();
                switch (choice3) {
                    case "Y":
                    case "y":
                        main.users.remove(index);
                        System.out.println("User deleted successfully");
                        break;
                    case "N":
                    case "n":
                        System.out.println("No changes had done");
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;

                }
                break;
            case 2:
                System.out.println("Enter the id of the user you want to delete his vehicle");
                choice2 = scanner.nextInt();
                index = main.users.indexOf(new user(" ", " "," ",0,0," "," ", choice2));
                if (index == -1) {
                    System.out.println("Id not found");
                    return;
                }
                System.out.println("Owner Name: " + main.users.get(index).getName());
                System.out.println("Owner ID: " + main.users.get(index).getId());
                System.out.println("Owner Total Fees: " + main.users.get(index).getFees());
                choice4 = main.users.get(index).selectVehicle();
                System.out.println(" ");
                System.out.println("Are you sure you want to delete this vehicle? Y/N");
                choice3 = scanner.next();
                switch (choice3) {
                    case "Y":
                    case "y":
                        if (main.users.get(index).vehicle.get(choice4).There_is_reservation) {
                            main.users.get(index).vehicle.get(choice4).confirm_cancelation();
                        }
                        main.users.get(index).vehicle.remove(choice4);
                        System.out.println("vehicle deleted successfully");
                        break;
                    case "N":
                    case "n":
                        System.out.println("No changes had done");
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;

                }
                break;
            case 3:
                System.out.println("Enter the id of the user you want to delete his resrvation");
                choice2 = scanner.nextInt();
                index = main.users.indexOf(new user(" ", " "," ",0,0," "," ", choice2));
                if (index == -1) {
                    System.out.println("Id not found");
                    return;
                }
                System.out.println("Owner Name: " + main.users.get(index).getName());
                System.out.println("Owner ID: " + main.users.get(index).getId());
                System.out.println("Owner Total Fees: " + main.users.get(index).getFees());
                System.out.println("Here is the reserved vehicles");
                choice4 = main.users.get(index).selectReservedVehicle();
                System.out.println(" ");
                System.out.println("Are you sure you want to delete this reservation? Y/N");
                choice3 = scanner.next();
                switch (choice3) {
                    case "Y":
                    case "y":
                        main.users.get(index).vehicle.get(choice4).confirm_cancelation();
                        System.out.println("reservation deleted successfully");
                        break;
                    case "N":
                    case "n":
                        System.out.println("No changes had done");
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;

                }
                break;
            case 4:
                System.out.println("Select the type of the spot you want to delete it's slots");
                System.out.println("1.Bike spot");
                System.out.println("2.Normal spot");
                System.out.println("3.Large spot");
                choice2 = scanner.nextInt();
                switch (choice2) {
                    case 1:
                        System.out.println("Here is the number of available slots");
                        bike.getSlots();
                        System.out.println("Enter the number of slots you want to delete");
                        choice4 = scanner.nextInt();
                        if (choice4 > bike.getSlots()) {
                            System.out.println("Can't delete a reserved spot");
                        } else {
                            for (int i = 0; i < choice4; i++) {
                                bike.removeslots();
                            }
                            System.out.println("Slots removed successfully");
                        }
                        break;
                    case 2:
                        System.out.println("Here is the number of available slots");
                        car.getSlots();
                        System.out.println("Enter the number of slots you want to delete");
                        choice4 = scanner.nextInt();
                        if (choice4 > car.getSlots()) {
                            System.out.println("Can't delete a reserved spot");
                        } else {
                            for (int i = 0; i < choice4; i++) {
                                car.removeslots();
                            }
                            System.out.println("Slots removed successfully");
                        }
                        break;
                    case 3:
                        System.out.println("Here is the number of available slots");
                        fourByFour.getSlots();
                        System.out.println("Enter the number of slots you want to delete");
                        choice4 = scanner.nextInt();
                        if (choice4 > fourByFour.getSlots()) {
                            System.out.println("Can't delete a reserved spot");
                        } else {
                            for (int i = 0; i < choice4; i++) {
                                fourByFour.removeslots();
                            }
                            System.out.println("Slots removed successfully");
                        }
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;

                }
                break;
            case 5:
                return;
        }
    }

    void Display_Available_slots() {
        System.out.println("Spot Type: " + car.getSpot_type());
        System.out.println("Spot ID: " + car.getSpot_id());
        System.out.println("Number of available slots: " + car.getSlots());
        for (int i = 0; i < car.slotsArray.size(); i++) {
            System.out.println("Slot Date: " + car.slotsArray.get(i).getDate());
            System.out.println("Slot Time: " + car.slotsArray.get(i).getTime());
        }
        System.out.println("Spot Type: " + bike.getSpot_type());
        System.out.println("Spot ID: " + bike.getSpot_id());
        System.out.println("Number of available slots: " + bike.getSlots());
        for (int i = 0; i < bike.slotsArray.size(); i++) {
            System.out.println("Slot Date: " + bike.slotsArray.get(i).getDate());
            System.out.println("Slot Time: " + bike.slotsArray.get(i).getTime());
        }
        System.out.println("Spot Type: " + fourByFour.getSpot_type());
        System.out.println("Spot ID: " + fourByFour.getSpot_id());
        System.out.println("Number of available slots: " + fourByFour.getSlots());
        for (int i = 0; i < fourByFour.slotsArray.size(); i++) {
            System.out.println("Slot Date: " + fourByFour.slotsArray.get(i).getDate());
            System.out.println("Slot Time: " + fourByFour.slotsArray.get(i).getTime());

        }
    }

    void Display_all_owner_data() {
            System.out.println("Enter the id of the user you want to update");
        int choice1 = scanner.nextInt();
        int index = main.users.indexOf(new user(" ", " "," ",0,0," "," ", choice1));
        if (index == -1) {
            System.out.println("Id not found");
            return;
        }
            System.out.println("Owner Name: " + main.users.get(index).getName());
            System.out.println("Owner ID: " + main.users.get(index).getId());
            System.out.println("Owner Age: " + main.users.get(index).getAge());
            System.out.println("Owner Address: " + main.users.get(index).getAddress());
            System.out.println("Owner Email: " + main.users.get(index).getE_mail());
            System.out.println("Owner Phone number: " + main.users.get(index).getPhone_number());
            System.out.println("Owner Gender: " + main.users.get(index).getGender());
            System.out.println("Owner Total Fees: " + main.users.get(index).getFees());
            for (int j = 0; j < main.users.get(index).vehicle.size(); j++) {
                System.out.println("Vehicles: ");
                System.out.print(j + ". " + main.users.get(index).vehicle.get(j).getName() + " (License: " + main.users.get(index).vehicle.get(j).getLicenes_number());
                if (main.users.get(index).vehicle.get(j).There_is_reservation) {
                    System.out.print(" Reservation date: " + main.users.get(index).vehicle.get(j).getReservationdate() + "/12/2024");
                    System.out.print(" Reservation time: " + main.users.get(index).vehicle.get(j).getReservationtime() + ":00");
                    System.out.print(" Reservation hours " + main.users.get(index).vehicle.get(j).getHours());
                }

            }
        
    }

    void Dipslay_spots() {
        for (int i = 0; i < bike.slotsArray.size(); i++) {
            System.out.println("Spot ID: " + bike.getSpot_id());
            System.out.println("Spot Type: " + bike.getSpot_type());
            System.out.print("Date: " + bike.slotsArray.get(i).getDate());
            if (bike.slotsArray.get(i).getDate() > 0) {
                System.out.println("/12/2024");
            }
            System.out.println("time: " + bike.slotsArray.get(i).getTime());
            System.out.println("fees: " + bike.slotsArray.get(i).getFees());
        }
        for (int i = 0; i < car.slotsArray.size(); i++) {
            System.out.println("Spot ID: " + car.getSpot_id());
            System.out.println("Spot Type: " + car.getSpot_type());
            System.out.print("Date: " + car.slotsArray.get(i).getDate());
            if (car.slotsArray.get(i).getDate() > 0) {
                System.out.println("/12/2024");
            }
            System.out.println("time: " + car.slotsArray.get(i).getTime());
            System.out.println("fees: " + car.slotsArray.get(i).getFees());
        }
        for (int i = 0; i < fourByFour.slotsArray.size(); i++) {
            System.out.println("Spot ID: " + fourByFour.getSpot_id());
            System.out.println("Spot Type: " + fourByFour.getSpot_type());
            System.out.print("Date: " + fourByFour.slotsArray.get(i).getDate());
            if (fourByFour.slotsArray.get(i).getDate() > 0) {
                System.out.println("/12/2024");
            }
            System.out.println("time: " + fourByFour.slotsArray.get(i).getTime());
            System.out.println("fees: " + fourByFour.slotsArray.get(i).getFees());
        }
    }

    void Display_normal_spot_total_amount() {
        int fees = 0;
        for (int i = 0; i < main.users.size(); i++) {
            for (int j = 0; i < main.users.get(i).vehicle.size(); j++) {
                if (main.users.get(i).vehicle.get(j).type.equals("Car")) {
                    fees += car.slotsArray.get(j).getFees();
                }
            }
        }
        System.out.println("Normal Spot fees: " + fees);
    }

    void Display_bike_spot_total_amount() {
        int fees = 0;
        for (int i = 0; i < main.users.size(); i++) {
            for (int j = 0; i < main.users.get(i).vehicle.size(); j++) {
                if (main.users.get(i).vehicle.get(j).type.equals("Bike")) {
                    fees += bike.slotsArray.get(j).getFees();
                }
            }
        }
        System.out.println("bike Spot fees: " + fees);
    }

    void Display_large_spot_total_amount() {
        int fees = 0;
        for (int i = 0; i < main.users.size(); i++) {
            for (int j = 0; i < main.users.get(i).vehicle.size(); j++) {
                if (main.users.get(i).vehicle.get(j).type.equals("Four By Four")) {
                    fees += fourByFour.slotsArray.get(j).getFees();
                }
            }
        }
        System.out.println("Large Spot fees: " + fees);
    }

    void update_data() {
        System.out.println("Enter the id of the user you want to update");
        int choice1 = scanner.nextInt();
        int index = main.users.indexOf(new user(" ", " "," ",0,0," "," ", choice1));
        if (index == -1) {
            System.out.println("Id not found");
            return;
        }
        System.out.println("Owner Name: " + main.users.get(index).getName());
        System.out.println("Owner ID: " + main.users.get(index).getId());
        System.out.println("Owner Total Fees: " + main.users.get(index).getFees());
        System.out.println(" ");
        System.out.println("Enter the number you want to update");
        System.out.println("1.Vehicle");
        System.out.println("2.Return to main menu");
        Exceptions e = new Exceptions();
        choice1 = e.check_range(1, 4);
        if (choice1 == -1) {
            System.out.println("Invalid choice");
            return;
        }
        int choice2;
        switch (choice1) {
            case 1:
                System.out.println("1.update the name of the vehicle");
                System.out.println("2.update the liscenes number");
                System.out.println("3.update the reservation");
                System.out.println("4.cancel the reservation");
                int choice3 = e.check_range(1, 4);
                if (choice3 == -1) {
                    System.out.println("Invalid choice");
                    return;
                }
                switch (choice3) {
                    case 1:
                        for (int j = 0; j < main.users.get(index).vehicle.size(); j++) {
                            System.out.println("Vehicles: ");
                            System.out.print(j + ". " + main.users.get(index).vehicle.get(j).getName() + " (License: " + main.users.get(index).vehicle.get(j).getLicenes_number());
                            if (main.users.get(index).vehicle.get(j).There_is_reservation) {
                                System.out.print(" Reservation date: " + main.users.get(index).vehicle.get(j).getReservationdate() + "/12/2024");
                                System.out.print(" Reservation time: " + main.users.get(index).vehicle.get(j).getReservationtime() + ":00");
                                System.out.print(" Reservation hours " + main.users.get(index).vehicle.get(j).getHours());
                            }

                        }
                        System.out.println("Enter the number of vehicle you want to update");
                        choice2 = e.check_range(1, main.users.get(index).vehicle.size());
                        if (choice2 == -1) {
                            System.out.println("Invalid choice");
                            return;
                        }
                        System.out.println("Enter the new vehicle name");
                        String s = scanner.next();
                        main.users.get(index).vehicle.get(choice2-1).setName(s);
                        break;
                    case 2:
                        for (int j = 0; j < main.users.get(index).vehicle.size(); j++) {
                            System.out.println("Vehicles: ");
                            System.out.print(j + ". " + main.users.get(index).vehicle.get(j).getName() + " (License: " + main.users.get(index).vehicle.get(j).getLicenes_number());
                            if (main.users.get(index).vehicle.get(j).There_is_reservation) {
                                System.out.print(" Reservation date: " + main.users.get(index).vehicle.get(j).getReservationdate() + "/12/2024");
                                System.out.print(" Reservation time: " + main.users.get(index).vehicle.get(j).getReservationtime() + ":00");
                                System.out.print(" Reservation hours " + main.users.get(index).vehicle.get(j).getHours());
                            }

                        }
                        System.out.println("Enter the number of vehicle you want to update");
                        choice2 = e.check_range(1, main.users.get(index).vehicle.size());
                        if (choice2 == -1) {
                            System.out.println("Invalid choice");
                            return;
                        }
                        System.out.println("Enter the new number");
                        String L = scanner.next();
                        main.users.get(index).vehicle.get(choice2-1).setName(L);
                        break;
                    case 3:
                        main.users.get(index).updatereservation();
                        break;
                    case 4:
                        main.users.get(index).CancelReservation();
                        break;
                }

                break;
            case 2:
                return;
        }

    }

}

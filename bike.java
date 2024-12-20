
import java.util.ArrayList;
import java.util.Arrays;

public class bike extends vehicles {

    private static final int spot_id = 200;
    private static final String spot_type = "Bike Spot";
    private static int slots = 0;
    private static final int price = 25;
    private int slot_number = 0;
    public static ArrayList<slots> slotsArray = new ArrayList<>();

    public bike(String name, String type, String licenes_number) {
        super(name, type, licenes_number);
    }

    public int getSlot_number() {
        return slot_number;
    }

    public void setSlot_number(int slot_number) {
        this.slot_number = slot_number;
    }
    
    

    public static void setSlots(int slots) {
        bike.slots = slots;
    }

    public static void addslots() {
        slotsArray.add(new slots());
    }
    public static void removeslots(){
        slotsArray.remove(slotsArray.size()-1);
    }

    public static String getSpot_type() {
        return spot_type;
    }

    public static int getPrice() {
        return price;
    }

    public static int getSlots() {
        return slots;
    }

    public static int getSpot_id() {
        return spot_id;
    }

    public static int check_availability() {
        if (bike.getSlots() <= 0) {
            System.out.println("Sorry there is no slots in this type available for reservations");
            return 1;
        }
        return 0;

    }

    @Override
    public void ConfirmReservation() {
        There_is_reservation = true;
        add_data_to_slots(bike.price * (hours- free_hours));
        user.number_of_bike_reserved_slots++;
        slot_number = user.number_of_bike_reserved_slots;
        slots--;
    }

    @Override
    public void ConfirmCancelation() {
        setThere_is_reservation(false); 
        user.number_of_bike_reserved_slots--;
        slot_number = user.number_of_bike_reserved_slots;
        add_data_to_slots(bike.price * getHours());
        slots++;
    }

    @Override
    public void add_data_to_slots(int feess) {
        this.slotsArray.get(this.slot_number).setTime(Reservationtime);
        this.slotsArray.get(this.slot_number).setDate(Reservationdate);
        this.slotsArray.get(this.slot_number).setFees(feess);
    }
    

}

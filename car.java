import java.util.ArrayList;
public class car extends vehicles {

    private static final int spot_id = 201;
    private static int available_slots = 0;
    private static final String spot_type = "Normal Spot";
    private static final int price = 50;
    public int slot_number = 0;
    private static int slot = 0;
    public static ArrayList<slots> slotsArray = new ArrayList<>();

    public car(String name, String type, String licenes_number) {
        super(name, type, licenes_number);
    }

    public int getSlot_number() {
        return slot_number;
    }

    public static int getSlot() {
        return slot;
    }

    public static void setSlot(int slot) {
        car.slot = slot;
    }
    

    public void setSlot_number(int slot_number) {
        this.slot_number = slot_number;
    }
    

    public static String getSpot_type() {
        return spot_type;
    }
    public static void addslots(){
        slotsArray.add(new slots());
    }
    public static void removeslots(){
        slotsArray.remove(slotsArray.size()-1);
    }

    public static int getPrice() {
        return price;
    }

    public static int getAvailable_slots() {
        return available_slots;
    }

    

    public static int getSpot_id() {
        return spot_id;
    }

    public static int check_availability() {
        if (car.available_slots <= 0) {
            System.out.println("Sorry there is no slots in this type available for reservations");
            return 1;
        }
        return 0;

    }

    public static void setAvailable_slots(int available_slots) {
        car.available_slots = available_slots;
    }

    

    @Override
    public void ConfirmReservation() {
        There_is_reservation = true;
        add_data_to_slots(car.price * (hours- free_hours));
        user.number_of_normal_reserved_slots++;
        slot_number = user.number_of_normal_reserved_slots;
        available_slots--;
    }

    @Override
    public void ConfirmCancelation() {
        setThere_is_reservation(false);
        user.number_of_normal_reserved_slots--;
        slot_number = user.number_of_normal_reserved_slots;
        add_data_to_slots(car.price * getHours()); 
        available_slots++;
    }
    @Override
    public void add_data_to_slots(int feess) {
        this.slotsArray.get(slot_number).setTime(Reservationtime);
        this.slotsArray.get(slot_number).setDate(Reservationdate);
        this.slotsArray.get(slot_number).setFees(feess);
    }
    

}

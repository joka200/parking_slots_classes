import java.util.ArrayList;

public class fourByFour extends vehicles {

    private static final int spot_id = 202;
    private static int available_slots = 0;
    private static final String spot_type = "Large Spot";
    private static final int price = 150;
    public int slot_number = 0;
    private static int slot = 0;
    public static ArrayList<slots> slotsArray = new ArrayList<>();

    public fourByFour(String name, String type, String licenes_number) {

        super(name, type, licenes_number);
    }
    public static void addslots(){
        slotsArray.add(new slots());
    }

    public static int getSlot() {
        return slot;
    }

    public static void setSlot(int slot) {
        fourByFour.slot = slot;
    }
    

    public int getSlot_number() {
        return slot_number;
    }

    public void setSlot_number(int slot_number) {
        this.slot_number = slot_number;
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

    public static String getSpot_type() {
        return spot_type;
    }
    

    public static int check_availability() {
        if (fourByFour.available_slots <= 0) {
            System.out.println("Sorry there is no slots in this type available for reservations");
            return 1;
        }
        return 0;

    }

    public static void setAvailable_slots(int available_slots) {
        fourByFour.available_slots = available_slots;
    }

    

    @Override
    public void ConfirmReservation() {
        There_is_reservation = true;
        add_data_to_slots(fourByFour.price * (hours- free_hours));
        user.number_of_large_reserved_slots++;
        slot_number = user.number_of_large_reserved_slots;
        available_slots--;
    }

    @Override
    public void ConfirmCancelation() {
        setThere_is_reservation(false);
        user.number_of_large_reserved_slots--;
        slot_number = user.number_of_large_reserved_slots;
        add_data_to_slots(fourByFour.price * getHours());
        available_slots++;
    }
    @Override
    public void add_data_to_slots(int feess) {
        this.slotsArray.get(this.slot_number).setTime(Reservationtime);
        this.slotsArray.get(this.slot_number).setDate(Reservationdate);
        this.slotsArray.get(this.slot_number).setFees(feess);
    }

}

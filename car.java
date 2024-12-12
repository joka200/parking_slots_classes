package youssef;

public class car extends vehicles {

    private static final int spot_id = 201;
    private static int slots = 10;
    private static final int price = 50;

    public car(String name, String type, String licenes_number) {
        super(name, type, licenes_number);
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
        if (car.getSlots() <= 0) {
            System.out.println("Sorry there is no slots in this type available for reservations");
            return 1;
        }
        return 0;

    }

    public static void setSlots(int slots) {
        car.slots = slots;
    }

    @Override
    public void ConfirmReservation() {
        There_is_reservation = true;
        slots--;
    }

    @Override
    public void confirm_cancelation() {
        There_is_reservation = false;
        slots++;
    }
    

}

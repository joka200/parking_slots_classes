import java.util.ArrayList;


public class vehicles {
    private String name;
    protected String type;
    private String licenes_number;
    private int free_hours = 0;
    private int hours;
    protected boolean There_is_reservation;
    protected int Reservationdate;
    protected int Reservationtime;
    public int slot_number;

    public vehicles(String name, String type, String licenes_number) {
        this.name = name;
        this.type = type;
        this.licenes_number = licenes_number;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    public String getName() {
        return name;
    }

    public String getLicenes_number() {
        return licenes_number;
    }
    

    public String getType() {
        return type;
    }

    public boolean isThere_is_reservation() {
        return There_is_reservation;
    }

    public int getReservationdate() {
        return Reservationdate;
    }

    public int getReservationtime() {
        return Reservationtime;
    }

    public int getFree_hours() {
        return free_hours;
    }
    public int getHours() {
        return hours;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLicenes_number(String licenes_number) {
        this.licenes_number = licenes_number;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setThere_is_reservation(boolean There_is_reservation) {
        this.There_is_reservation = There_is_reservation;
    }

    public void setReservationdate(int Reservationdate) {
        this.Reservationdate = Reservationdate;
    }

    public void setReservationtime(int Reservationtime) {
        this.Reservationtime = Reservationtime;
    }
    

    public void setFree_hours(int free_hours) {
        this.free_hours = free_hours;
    }
    
    public int addDateandTime(int RDate,int Rtime){
        if(RDate>31 || RDate<1 || 16-RDate>3 || 16-RDate <0 ){
            return 1;
        }if(Rtime>24 || Rtime<1){
            return 2;
        }
        this.Reservationdate = RDate;
        this.Reservationtime = Rtime;
        return 0;
    }
    public int addhours(int hours){
        if(hours <0){
            return 1;
        }
        this.hours = hours;
            return 0;
    }
    public void add_data_to_slots(int fees){}
    public void ConfirmReservation(){}
    public void confirm_cancelation(){}
        
}

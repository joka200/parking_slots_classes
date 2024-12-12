package youssef;


public class vehicles {
    private String name = new String();
    protected String type = new String();
    private String licenes_number;
    private int free_hours = 0;
    private int hours;
    protected boolean There_is_reservation;
    private int Reservationdate;
    private int Reservationtime;

    public vehicles(String name, String type, String licenes_number) {
        this.name = name;
        this.type = type;
        this.licenes_number = licenes_number;
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
    public void ConfirmReservation(){}
    public void confirm_cancelation(){}
        
}

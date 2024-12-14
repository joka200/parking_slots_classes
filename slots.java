package youssef;

public class slots
{
    private int time;
    private int date;
    private double fees;
    private boolean isavailable;
    


    public slots() {
        this.time = 0;
        this.date = 0;
        this.fees = 0;

    }

    public slots(int time, int date, double fees) {
        this.time = time;
        this.date = date;
        this.fees = fees;
    }
    
        

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }
    
}

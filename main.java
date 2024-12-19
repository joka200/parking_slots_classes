
import java.util.ArrayList;

public class main {

    public static ArrayList<user> users = new ArrayList<>();
    static int ctr = 0;

    public static void main(String[] args)
    {
        if (ctr == 0)
        {
            System.out.println("welcome to the Parking area");
            log_in.load_user_From_File();
            log_in.load_bikeSlots_From_File();
            log_in.load_NormalSlots_From_File();
            log_in.load_LargeSlots_From_File();
            ctr++;
        }
        person.login();
    }
}


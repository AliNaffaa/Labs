package lab1;

/**
 * Created by ali.naffaa on 22.06.2018.
 */
public class MainLab1 {
    public static void main(String args []){
        Device device1 = new Device("boiler","1","10","15","7", Device.State.ON);
//        Device device2 = new Device("boiler","0","10","15","7", Device.State.ON);//NPE
        System.out.println(device1);
    }
}

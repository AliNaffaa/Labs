package lab8.pages.classes;

/**
 * Created by Ali on 24.06.2018.
 */
public class Thermometer extends Device {
    public enum State {
        ON, OFF, SERVICEABLE, DEFECTIVE;
    }

    public void setName(String name) {
        this.name = name +  " DevicePage";
    }

    public State state;

    public State getState() {
        return state;
    }



    public void setState(State state) {
        this.state = state;
    }
}

package lab5;

/**
 * Created by Ali on 24.06.2018.
 */
public class Thermometer extends Device {
    public enum State {
        ON, OFF, SERVICEABLE, DEFECTIVE;
    }

    public void setName(String name) {
        this.name = name +  " Thermometer";
    }

    public State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}

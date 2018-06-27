package lab1;

/**
 * Created by ali.naffaa on 22.06.2018.
 */

public class Device {
    public enum State {
        ON, OFF, SERVICEABLE, DEFECTIVE;
    }
    //5    1,11,2,3
//    1.Найменування приладу.
//    2. Габарити: довжина, висота, ширина.
//    3. Вага
//    11. Стан. Може приймати значення: увімкнено, вимкнено, справний, несправний...
    private String name;
    private String length;
    private String height;
    private String width;
    private String weight;
    private State state;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        checkValue(length,"length");
        this.length = length;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        checkValue(height,"height");
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        checkValue(width,"width");
        this.width = width;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        checkValue(weight,"weight");
        this.weight = weight;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    private void checkValue(String value,String fieldName){
        if(value.matches("-\\d+") || value.equals("0")){
            throw new IllegalArgumentException(fieldName+ " should be positive");
        }
    }

    public Device(String name, String length, String height, String width, String weight, State state) {
        this.setName(name);
        this.setLength(length);
        this.setHeight(height);
        this.setWidth(width);
        this.setWeight(weight);
        this.setState(state);
    }
}

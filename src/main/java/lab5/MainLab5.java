package lab5;

import java.util.ArrayList;

/**
 * Created by Ali on 24.06.2018.
 */
public class MainLab5 {
    public static void main(String args[]) {
        ArrayList<Measure> measures = new ArrayList<>();
        measures.add(new Measure(Measure.MeasureType.CELSIUS, "0", "100", "0.2"));
        measures.add(new Measure(Measure.MeasureType.CALVININR, "273,15", "373,15", "0.2"));
        measures.add(new Measure(Measure.MeasureType.FAHRENHEIT, "+32", "+212", "0.2"));
        ElectronicThermometer device = new ElectronicThermometer("R2D2");
        device.setName("term"); // name will be "term"
        device.workWithMeasures(measures.get(0));
        System.out.println(device.getName());
        Thermometer thermometer = new Thermometer();
        thermometer.setName("term"); // name will be "term Thermometer"
        System.out.println(thermometer.getName());

        device.setState(Thermometer.State.ON);
        if (device.getState().equals(Thermometer.State.ON)) {
            device.setState(Thermometer.State.OFF);
        }
    }

}

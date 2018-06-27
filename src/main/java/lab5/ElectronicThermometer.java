package lab5;

/**
 * Created by Ali on 24.06.2018.
 */
public class ElectronicThermometer extends Thermometer {

    public void workWithMeasures(Measure measure){
        System.out.println("Type:" +measure.getMeasureType());
        System.out.println("LowerBound:" +measure.getLowerBound());
        System.out.println("UpperLimit:" +measure.getUpperLimit());
        System.out.println("MeasurementError:" +measure.getMeasurementError());
    }

    public ElectronicThermometer(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

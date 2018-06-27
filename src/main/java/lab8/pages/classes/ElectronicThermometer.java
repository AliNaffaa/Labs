package lab8.pages.classes;

/**
 * Created by Ali on 24.06.2018.
 */
public class ElectronicThermometer extends Thermometer {
//8. Вимірювання. Прилад може бути розрахований на вимірювання декількох величин.
//    Кожна з них характеризується:
//            - назвою вимірюваної величини;
//- нижньою межею вимірювання;
//- верхньою межею вимірювання;
//- похибкою вимірювання.

    public void workWithMeasures(Measure measure){
        System.out.println("Type:" +measure.getMeasureType());
        System.out.println("LowerBound:" +measure.getLowerBound());
        System.out.println("UpperLimit:" +measure.getUpperLimit());
        System.out.println("MeasurementError:" +measure.getMeasurementError());
    }

    public ElectronicThermometer(String name) {
        this.name = name;
    }
}

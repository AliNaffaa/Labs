package lab5;

/**
 * Created by Ali on 24.06.2018.
 */
public class Measure {
    public enum MeasureType {
         CELSIUS, CALVININR, FAHRENHEIT;
    }

    MeasureType measureType;
    String lowerBound;
    String upperLimit;
    String MeasurementError;

    public Measure(MeasureType measureType, String lowerBound, String upperLimit, String measurementError) {
        this.measureType = measureType;
        this.lowerBound = lowerBound;
        this.upperLimit = upperLimit;
        MeasurementError = measurementError;
    }

    public MeasureType getMeasureType() {
        return measureType;
    }

    public void setMeasureType(MeasureType measureType) {
        this.measureType = measureType;
    }

    public String getLowerBound() {
        return lowerBound;
    }

    public void setLowerBound(String lowerBound) {
        this.lowerBound = lowerBound;
    }

    public String getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(String upperLimit) {
        this.upperLimit = upperLimit;
    }

    public String getMeasurementError() {
        return MeasurementError;
    }

    public void setMeasurementError(String measurementError) {
        MeasurementError = measurementError;
    }
}

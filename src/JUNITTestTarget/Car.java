package JUNITTestTarget;

/**
 * @author Dan Crosby
 * CIT360
 * A class for use in JUnit testing.   This class is invoked for purposes of comparing objects.
 */
public class Car {
    /**
     *Method getCarMake
     *<p>
     * Getter for the current objects carMake property
     * Used in JUNIT assertion testing.
     *</p>
     * @return - String carMake value
     */
    public String getCarMake() {
        return carMake;
    }

    /**
     *Method setCarMake
     *<p>
     * Setter for the current objects carMake property.
     * Used in JUNIT assertion testing.
     *</p>
     * @param carMake - String carMake value to be stored
     */
    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    private String carMake;
}

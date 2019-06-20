package JUNITTest;

import JUNITTestTarget.Car;
import JUNITTestTarget.TestTargets;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

/**
 * @author Dan Crosby
 * CIT360
 * A class for use in JUnit testing.   This class instantiates and manipulates basicobjects.
 */
public class CarTest {
    /**
     *Method testAssertSame
     *<p>
     * This method creates Junit test "assertSame" for the JUNITTestTarget.Car class
     *</p>
     */
    @org.junit.Test
    public void testAssertSame() {
        JUNITTestTarget.Car c=new Car();
        c.setCarMake("Volkswagen");
        assertSame(c, TestTargets.getReturnObject(c));
    }

    /**
     *Method testAssertSame
     *<p>
     * This method creates Junit test "assertNotSame" for the JUNITTestTarget.Car class
     * The not same assertion checks not the values, but rather to see if the object reference is identical.
     *</p>
     */
    @org.junit.Test
    public void testAssertNotSame() {
        //The Not Same assertion tests to ensure that
        //objects are the same, so even if the values match,
        //assertSame will fail if the objects are different.
        Car c=new Car();
        c.setCarMake("Volkswagen");

        Car d=new Car();
        d.setCarMake("Volkswagen");
        assertNotSame(c,d);
    }

}

package JUNITTest;

import JUNITTestTarget.Car;
import JUNITTestTarget.TestTargets;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

public class CarTest {


    @org.junit.Test
    public void testAssertSame() {
        JUNITTestTarget.Car c=new Car();
        c.setCarMake("Volkswagen");
        assertSame(c, TestTargets.getReturnObject(c));
    }

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

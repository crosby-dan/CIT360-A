package JUNITTest;

import JUNITTestTarget.TestTargets;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

public class TestTargetsTest {
    @org.junit.Test
    public void testAdder() {
        assertEquals(TestTargets.adder(3,2),5);
    }

    @org.junit.Test
    public void testGetUpperCase() {
        assertNotSame('z', TestTargets.getUpperCase('a'));
    }

    @org.junit.Test
    public void testGetDaysOfWeek() {
        String[] dayList= {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        assertArrayEquals(dayList, TestTargets.getDaysOfWeek());
    }

    @org.junit.Test
    public void testGetUpperCase2() {
        // Testing using assertThat instead of assert equals
        // Note that the expected value comes second
        // and by using the "is" and "not" functions of JUnit,
        // the code is more readable.
        assertThat(TestTargets.getUpperCase('a'),is(not('z')));
    }

    @org.junit.Test
    public void testGetNull() {
        // Test the AssertNull assertion
        assertNull(TestTargets.getNull());
    }

    @org.junit.Test
    public void testAdder2() {
        // Test the AssertTrue assertion
        assertTrue(TestTargets.adder(50,500)==550);
    }

    @org.junit.Test
    public void testAdder3() {
        // Test the AssertFalse assertion
        assertFalse(TestTargets.adder(12,25)==550);
    }

}



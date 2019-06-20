package JUNITTest;

import JUNITTestTarget.TestTargets;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

/**
 * @author Dan Crosby
 * CIT360
 * A JUnit test class to test emthods in the TestTargets class.
 */
public class TestTargetsTest {
    /**
     *Method testAdder
     *<p>
     * Test adding 2 numbers and verify using assertEquals.
     *</p>
     */
    @org.junit.Test
    public void testAdder() {
        assertEquals(5,TestTargets.adder(3,2));
    }

    /**
     *Method testGetUpperCase
     *<p>
     * Test the getUpperCase method by verifying that the case has changed from 'a' to something other than 'a'.
     *</p>
     */
    @org.junit.Test
    public void testGetUpperCase() {
        assertNotEquals('a', TestTargets.getUpperCase('a'));
    }

    /**
     *Method testGetDaysOfWeek
     *<p>
     * Test the getDaysOfWeek method by verifying that the return results match an identical array.
     *</p>
     */
    @org.junit.Test
    public void testGetDaysOfWeek() {
        String[] dayList= {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        assertArrayEquals(dayList, TestTargets.getDaysOfWeek());
    }

    /**
     *Method testGetUpperCase2
     *<p>
     * Test the getUpperCase method by using assert that
     * which reverses the input parameters and uses the "is" and "not" parameters to make the
     * code more readable.
     *</p>
     */
    @org.junit.Test
    public void testGetUpperCase2() {
        assertThat(TestTargets.getUpperCase('a'),is(not('a')));
    }

    /**
     *Method testGetNull
     *<p>
     * Test the getNull method by verifying the result is null.
     *</p>
     */
    @org.junit.Test
    public void testGetNull() {
        // Test the AssertNull assertion
        assertNull(TestTargets.getNull());
    }

    /**
     *Method testAdder2
     *<p>
     * Test the adder method by using the assertTrue method.  50+500=550
     *</p>
     */
    @org.junit.Test
    public void testAdder2() {
        // Test the AssertTrue assertion
        assertTrue(TestTargets.adder(50,500)==550);
    }

    /**
     *Method testAdder3
     *<p>
     * Test the adder method by using the assertFalse method.  12+25 does not equal 550
     *</p>
     */
    @org.junit.Test
    public void testAdder3() {
        // Test the AssertFalse assertion
        assertFalse(TestTargets.adder(12,25)==550);
    }

}



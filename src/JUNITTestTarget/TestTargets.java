package JUNITTestTarget;

/**
 * @author Dan Crosby
 * CIT360
 * A class for use in demonstrating the use of JUnit in methods that invoke this class.
 */
public class TestTargets {

    /**
     *Method adder
     *<p>
     * Add 2 integers
     *</p>
     * @param num1 - first number to add
     * @param num2 - second number to add
     * @return - the added integers
     */
    public static int adder(int num1, int num2) {
        return num1+num2;
    }

    /**
     *Method getUpperCase
     *<p>
     * Convert a character to upper case
     *</p>
     * @param s1 - character to be converted to upper case
     * @return the upper case equivalent
     */
    public static char getUpperCase(char s1) {
        return Character.toUpperCase(s1);
    }

    /**
     *Method getNull
     *<p>
     * Returns a null value for testing assertions that check for null.
     *</p>
     * @return a null value
     */
    public static Object getNull() {
        //Until forever, we are going to return null from this method.
        return null;
    }

    /**
     *Method getReturnObject
     *<p>
     * Returns a the same object that was passed in for testing the AssertSame method.
     *</p>
     * @param a - the object to be returned
     * @return the same object that was passed in
     */
    public static Object getReturnObject(Object a) {
        return a;
    }

    /**
     *Method getDaysOfWeek
     *<p>
     * An array of Strings with the days of the week for use in assertion testing.
     *</p>
     * @return An array of Strings
     */
    public static String[] getDaysOfWeek() {
        String[] dayList= {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        return dayList;
    }

}

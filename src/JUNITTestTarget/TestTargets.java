package JUNITTestTarget;

public class TestTargets {

    public static int adder(int num1, int num2) {
        return num1+num2;
    }

    public static char getUpperCase(char s1) {
        return Character.toUpperCase(s1);
    }

    public static Object getNull() {
        //Until forever, we are going to return null from this method.
        return null;
    }

    public static Object getReturnObject(Object a) {
        //So that we can test the AssertSame assertion
        //we are going to return the same object that is passed to this method.
        return a;
    }

    public static String[] getDaysOfWeek() {
        String[] dayList= {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        return dayList;
    }

}

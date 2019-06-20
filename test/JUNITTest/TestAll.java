package JUNITTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
/**
 * @author Dan Crosby
 * CIT360
 * A JUnit test suite to package up all other testing within this project.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({CarTest.class,TestTargetsTest.class})
public class TestAll {
    //No code other than the SuiteClasses annotation is necessary for a test suite
}

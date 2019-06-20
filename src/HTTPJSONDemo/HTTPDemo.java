package HTTPJSONDemo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 *@author Dan Crosby
 * CIT360
 * Demonstrate using the native Java HTTP objects for GET and POST.
 */
public class HTTPDemo {

    private final String USER_AGENT = "Mozilla/5.0";

    /**
     *Method mainTest
     *<p>
     * Launching point to start HTTP related tests.
     *</p>
     */
    public static void httpTest() {
        HTTPDemo httpDemo = new HTTPDemo();
        httpDemo.processRequests();

        JSONDemo jsonDemo = new JSONDemo();
        jsonDemo.jsonDemoRun();
    }

    /**
     *Method processRequests
     *<p>
     * Set parameters and call HTTP Tests -
     * Test 1 - GET test for a conference talk in English
     * Test 2 - GET test for a conference talk in Spanish
     * Test 3 - POST test to the Post Test 2 server using 2 parameters.
     *</p>
     */
    private void processRequests() {
        //Setup and run test 1
        String title="Conference talk in English (lang=eng)";
        String url="https://www.churchofjesuschrist.org/study/general-conference/2019/04/28holland?lang=eng";
        System.out.format("\nTest 1 - sending GET test - %s:\n\tURL:\t%s\n",title,url);
        retrieveHTML("GET",url, null);

        //Setup and run test 2
        title="Conference talk in Spanish (lang=spa)";
        url="https://www.churchofjesuschrist.org/study/general-conference/2019/04/28holland?lang=spa";
        System.out.format("\nTest 2 - sending GET test - %s:\n\tURL:\t%s\n",title,url);
        retrieveHTML("GET",url, null);

        //Setup and run test 3
        title="Post Test to the Dump View server with parameter TEST";
        url="http://ptsv2.com/t/tester/post";
        String urlParams = "class=CIT360&Major=ComputerScience";
        System.out.format("\nTest 3 - sending POST test - %s params: %s\n\tURL:\t%s\n",title,url,urlParams);
        retrieveHTML("POST",url, urlParams);
        }

    /**
     *Method retrieveHTML
     *<p>
     * Call the respective HTTP service and process the results.
     *
     * @param  method - A string indicating GET or POST
     * @param  url - A valid HTTP URL in string format.  (Not for use with HTTPS)
     * @param  urlParams - for POST only, a string version of parameters to be passed in
     *             parameter name=value&next parameter name=next value
     *</p>
     */
    private StringBuffer retrieveHTML (String method, String url, String urlParams) {
        //Initialize variables
        HttpURLConnection myConn;
        URL obj;
        StringBuffer response;

        //Establish an HTTP connection to the URL
        try {
            obj=new URL(url);
            myConn = (HttpURLConnection) obj.openConnection();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println ("Failed to process URL " + url);
            return null;
        }

        //Depending on the method, run the appropriate code to establish an HTTP connection.
        try {
            if (method.equals("GET")) {

                //Setup the properties to establish an HTTP GET connection
                myConn.setRequestMethod("GET");
                myConn.setRequestProperty("User-Agent", USER_AGENT);
            }
            else if (method.equals("POST")) {

                //Setup the properties to establish an HTTP POST connection
                myConn.setDoOutput(true);
                myConn.setRequestMethod("POST");
                myConn.setRequestProperty("User-Agent", USER_AGENT);
                myConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

                //Write the parameters
                byte[] postData = urlParams.getBytes(StandardCharsets.UTF_8);
                try (DataOutputStream wr = new DataOutputStream(myConn.getOutputStream())) {
                    wr.write(postData);
                }
            } else {

                System.out.println("Error - invalid method passed.  Only GET or POST are allowed.");
                throw new Exception("Invalid method");

            }
            //Establish the connection
            int httpResponseCode = myConn.getResponseCode();
            System.out.format("\tResponse code: %d\n", httpResponseCode);

            //Setup buffered connection for downloading the page contents
            BufferedReader in = new BufferedReader(new InputStreamReader(myConn.getInputStream()));
            response = new StringBuffer();
            String inputLine;

            //Download the GET response with a buffered connection
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //Write response stats out to console.
            System.out.format ("\tResponse Length: %d\n",response.length());
            System.out.format ("\tPage response: %s\n",response.toString());
            Util.Util.promptEnterKey("Press enter to continue.");

            return response;

        } catch (Exception ex) {
            System.out.println("Error occurred: " + ex.getMessage());
            return null;
        }
    }
}

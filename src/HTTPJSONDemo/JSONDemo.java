package HTTPJSONDemo;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class JSONDemo {
    /**
     *Method jsonDemoRun
     *<p>
     * This method will direct traffic on tests 4,5,6,7 which pull JSON data from HTTP and then do things with the data.
     * </p>
     */
    void jsonDemoRun() {

        System.out.format("\nTest 4 - Retrieve employee list in JSON from dummy.restapiexample.com/api/v1/employees");
        StringBuffer json=retrieveJSONHttp("http://dummy.restapiexample.com/api/v1/employees");

        System.out.format("\nTest 5 - parse JSON into a java class and then call the toString method");
        Gson gson = new Gson();
        Employee[] employees = gson.fromJson(json.toString(), Employee[].class);

        //We are going to print out a list of the top 50 employees returned by the previous test.
        String eeList="";
        int counter=0;
        for(Employee emp: employees) {
            eeList += String.format("%2s)  ",counter+1) + emp.toStringShort();
            if ((counter+1) %5 == 0) eeList += "\n";
            counter++;
            //For purposes of this demo, we will only show the first 50 employees.
            if (counter>=50) break;
        }

        //Have the user select a number from 1 to 50 so that we can then
        //show the full details for that employee.
        System.out.format("Employee List: \n%s\n\nWhich employee would you like to display?-->",eeList);
        String s=Util.Util.getInput("(\\d\\d?)","Invalid value provided, please enter 1 - 50.");
        if (s == null || s.isEmpty()) {
            System.out.println ("Invalid input, program aborted.");
            return;
        }

        //For the selected ID, download the rest of the employee info from JSON.
        //Note that technically we already had this in the array, but this test
        //simulates a more sophisticated process where one would first query and then
        //pull the more detailed data after drilling down.
        System.out.format("\nTest 6 - Retrieve JSON from dummy.restapiexample.com/api/v1/employee/" + employees[Integer.parseInt(s)-1].getId());
        json=retrieveJSONHttp("http://dummy.restapiexample.com/api/v1/employee/" + employees[Integer.parseInt(s)-1].getId());

        //Display the detailed information found for the specified employee.
        System.out.format("\nTest 7 - Call the toString method on the employee class parsed from JSON for your selected employee.\n");
        Employee employee = gson.fromJson(json.toString(), Employee.class);
        System.out.println(employee.toString());
    }

    /**
     *Method retrieveJSONHttp
     *<p>
     * Method will contact the specified URL and return the JSON results that are returned.
     *</p>
     * @param url - HTTP url that will return JSON.
     * @return - A stringbuffer of the returned fields, or null if the process fails.
     */
    private StringBuffer retrieveJSONHttp (String url) {
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
            System.out.println ("Failed to process " + url);
            return null;
        }

        try {
            //Setup the properties to establish an HTTP GET connection
            myConn.setRequestMethod("GET");

            //Establish the connection
            int httpResponseCode = myConn.getResponseCode();
            System.out.format("\tHTTP JSON Response code: %d\n", httpResponseCode);

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
            System.out.format ("\tJSON Response Length: %d\n",response.length());
            System.out.format ("\tJSON response: %s\n",response.toString());
            Util.Util.promptEnterKey("Press enter to continue.");

            return response;

        } catch (Exception ex) {
            System.out.println("Error occurred: " + ex.getMessage());
            return null;
        }
    }
}

package HTTPJSONDemo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class JSONDemo {
    private final String USER_AGENT = "Mozilla/5.0";

    void jsonDemoRun() {

        System.out.format("\nTest 4 - Retrieve employee list in JSON from dummy.restapiexample.com/api/v1/employees");
        StringBuffer json=retrieveJSONHttp("http://dummy.restapiexample.com/api/v1/employees");

        System.out.format("\nTest 5 - parse JSON into a java class and then call the toString method");
        Gson gson = new Gson();
        Employee[] employees = gson.fromJson(json.toString(), Employee[].class);

        //System.out.println(employees[0].toString());

        String eeList="";
        int counter=0;
        for(Employee emp: employees) {
            eeList += String.format("%2s)  ",counter+1) + emp.toStringShort();
            if ((counter+1) %5 == 0) eeList += "\n";
            counter++;
            //For purposes of this demo, we will only show the first 50 employees.
            if (counter>=50) break;
        }
        System.out.format("Employee List: \n%s\n\nWhich employee would you like to display?-->",eeList);
        String s=Util.Util.getInput("(\\d\\d?)","Invalid value provided, please enter 1 - 50.");
        if (s == null || s.isEmpty()) {
            System.out.println ("Invalid input, program aborted.");
            return;
        }

        System.out.format("\nTest 6 - Retrieve JSON from dummy.restapiexample.com/api/v1/employee/" + employees[Integer.parseInt(s)-1].getId());
        json=retrieveJSONHttp("http://dummy.restapiexample.com/api/v1/employee/" + employees[Integer.parseInt(s)-1].getId());

        System.out.format("\nTest 7 - Call the toString method on the employee class parsed from JSON for your selected employee.\n");
        Employee employee = gson.fromJson(json.toString(), Employee.class);
        System.out.println(employee.toString());
    }

    private StringBuffer retrieveJSONHttp (String url) {
        //Initialize variables
        HttpURLConnection myConn;
        URL obj;
        StringBuffer response;

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
            //myConn.setRequestProperty("User-Agent", USER_AGENT);

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

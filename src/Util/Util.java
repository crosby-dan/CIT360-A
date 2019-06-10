package Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Dan Crosby
 * This class will also contain some global utilities that do not pertain to one specific class or activity.
 */

public class Util {
/**
     * The promptEnterKey method
     * Purpose: A simple function to prompt and catch an enter key to manage the flow of user input.
     * @return void
     */

    public static void promptEnterKey(){
        System.out.format("Press ENTER to continue.");
        try {
            int readKey = System.in.read(new byte[2]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

/**
     * The promptEnterKey method with an overload to change the prompt message.
     * Purpose: A simple function to prompt and catch an enter key to manage the flow of user input.
     * @return void
     */

    public static void promptEnterKey(String message){
        System.out.println(message);
        try {
            int readKey = System.in.read(new byte[2]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

/**
     * The textToConsole method
     * A simple function to output a file of text to the console.
     * @param fn (String) - the path and file name of the text file to output to console, i.e. "img/tractor.txt"
     * @return void
     */

    public static void textToConsole(String fn) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(fn));
        String line = in.readLine();
        while(line != null)
        {
            System.out.println(line);
            line = in.readLine();
        }
        in.close();
    }

}

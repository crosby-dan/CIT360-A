package Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Dan Crosby
 * This class will also contain some global utilities that do not pertain to one specific class or activity.
 */

public class Util {
/**
     * The promptEnterKey method
     * Purpose: A simple function to prompt and catch an enter key to manage the flow of user input.
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

    //This method copied from https://stackoverflow.com/questions/8499698/trim-a-string-based-on-the-string-length
    public static String abbreviateString(String input, int maxLength) {
        if (input.length() <= maxLength)
            return input;
        else
            return input.substring(0, maxLength-2) + "..";
    }


    public static String getInput(String sPattern,String errorPrompt) {
        Pattern pattern = Pattern.compile(sPattern);
        Matcher matcher;

        @SuppressWarnings("resource")
        Scanner in = new Scanner (System.in);
        String input=in.nextLine();
        matcher = pattern.matcher(input);
        boolean matchResult=matcher.find();
            if (!matchResult) {
                System.out.println(errorPrompt);
                return null;
            }
            else
                return matcher.group(1);
    }

}

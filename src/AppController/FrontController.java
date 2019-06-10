package AppController;

import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *@author Dan Crosby
 * CIT360
 * A Controller to handle a simple shopping list application.
  */
public class FrontController {
    //This TreeSet will hold a sorted list of shopping cart items.
    static TreeSet<String> setShoppingList = new TreeSet<>();

    /**
     *Method AppControllerDemo
     *<p>
     * Gathers input and launches the appropriate controller.
     * To add or remove an item requires two parameters.
     * To clear list or print, requires one parameter.
     * To quit requires no parameters.
     *</p>
     */
    public static void AppControllerDemo() {
        Pattern pattern1 = Pattern.compile("^(print|clear|quit|add|remove).*");
        Pattern pattern2 = Pattern.compile(".*(bananas|paper towels|milk|eggs|pop tarts|spam)");

        ListRequestHandler handler = new ListRequestHandler();

        Matcher matcher1, matcher2;
        boolean matchResult1, matchResult2;
        do {
            System.out.format("\nWelcome to your shopping list.   Enter a command and an item name.");
            System.out.format("\nCommands:  add, remove, clear, print.\t\tItems:  Bananas, Paper Towels, Milk, Eggs, Spam.\n\n");

            @SuppressWarnings("resource")
            Scanner in = new Scanner (System.in);
            String input=in.nextLine();
            matcher1 = pattern1.matcher(input);
            matcher2 = pattern2.matcher(input);
            matchResult1=matcher1.find();
            matchResult2=matcher2.find();
            if (!matchResult1 ) {
                System.out.println("*** Invalid commands provided ***\n");
            }
            else if (matcher1.group(1).equalsIgnoreCase("quit"))
                return;
            else if (matchResult1 && matchResult2)
                //Commands add and remove require 2 parameters
                handler.handleCommand(matcher1.group(1),matcher2.group(1));
            else
                //Commands print, clear require 1 parameter
                handler.handleCommand(matcher1.group(1),"");
        }
        while (!matchResult1 || !matcher1.group(1).equalsIgnoreCase("quit"));
    }
}

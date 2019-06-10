package AppController;

import static AppController.FrontController.setShoppingList;
/**
 *@author Dan Crosby
 * CIT360
 * A class called when needed to print the shopping list.
 */
public class PrintList implements doListCommand {
    /**
     *Method runCommand
     *<p>
     * Print the current shopping list to console.
     *</p>
     * @param  sCommand - For the action PrintList, this field will be ignored.
     */
    public void runCommand(String sCommand){
        if (setShoppingList.isEmpty())
            System.out.format("*******************************************\nThe shopping list is empty.");
        else
            System.out.format("*******************************************\nHere is the current shopping list: %s\n\n", setShoppingList.toString());
    }
}

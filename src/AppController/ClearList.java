package AppController;

import static AppController.FrontController.setShoppingList;

/**
 *@author Dan Crosby
 * CIT360
 * Clear the shopping list.
 */
public class ClearList implements doListCommand {
    /**
     *Method runCommand
     *<p>
     * Clear the shopping list.
     *</p>
     * @param  sCommand - For the action ClearList, this field will be ignored.
     */
    public void runCommand(String sCommand){
        setShoppingList.clear();
        System.out.println("*******************************************\nList cleared.");
    }
}

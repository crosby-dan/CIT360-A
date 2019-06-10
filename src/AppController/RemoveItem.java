package AppController;

import static AppController.FrontController.setShoppingList;
/**
 *@author Dan Crosby
 * CIT360
 * A Class called when needed to remove an item from the shopping list.
 */
public class RemoveItem implements doListCommand {
    /**
     *Method runCommand
     *<p>
     * Remove the selected item.
     *</p>
     * @param  sCommand - The name of the item to be removed.
     */
    public void runCommand(String sCommand){
        try {
            setShoppingList.remove(sCommand.toLowerCase());
            System.out.format("*******************************************\nRemoved %s from list.\n",sCommand);
        }
        catch (Exception ex) {
            System.out.format("*******************************************\nFailed to remove %s from list.\n",sCommand);
        }
    }
}

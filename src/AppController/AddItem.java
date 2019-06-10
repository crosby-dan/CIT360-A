package AppController;

import static AppController.FrontController.setShoppingList;

/**
 * @author Dan Crosby
 * CIT360
 * Clear the shopping list.
 */
public class AddItem implements doListCommand {
    /**
     *Method runCommand
     *<p>
     * Add the specified item to the shopping list.
     *</p>
     * @param  sCommand - The name of the item to be added.
     */
    public void runCommand(String sCommand){
        if (sCommand.isEmpty())
            System.out.format("*******************************************\nInvalid item requested.\n",sCommand);
        else if (!setShoppingList.contains(sCommand.toLowerCase())) {
            setShoppingList.add(sCommand.toLowerCase());
            System.out.format("*******************************************\nAdded %s to list.\n", sCommand);
        }
        else
            System.out.format("*******************************************\n%s is already on your list.\n",sCommand);
    }
}

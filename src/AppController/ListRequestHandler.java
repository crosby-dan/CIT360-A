package AppController;

import java.util.HashMap;

public class ListRequestHandler {
    private static HashMap<String, doListCommand> key = new HashMap<>();

    /**
     *Method handleCommand
     *<p>
     * Each action on the shopping list is a separate command.
     *</p>
     * @param  command1 - This is the name of the command, i.e. add, remove, print, or clear.
     * @param  command2 - This is the parameter which indicates which item, i.e. bananas, paper towels, etc.
     */
    static void handleCommand(String command1, String command2) {
        key.put("add", new AddItem());
        key.put("remove", new RemoveItem());
        key.put("print", new PrintList());
        key.put("clear", new ClearList());

        //TODO: While the current method calling this validates the inputs, this should ideally still have error handling.
        doListCommand request = key.get(command1.toLowerCase());
        //This is the application controller launching the appropriate command.
        request.runCommand(command2);
    }

}
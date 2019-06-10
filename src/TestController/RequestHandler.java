package TestController;

import java.util.HashMap;
/**
 *
 * @author sirri
 */
class RequestHandler {
    private static HashMap<String, doMath> key = new HashMap<>();
    static Double handleOperator(String operator, Double input1, Double input2){
        key.put("+", new Addition());
        key.put("-", new Subtraction());
        key.put("*", new Multiplication());
        key.put("/", new Division());
        key.put("%", new Modulo());
        key.put("^", new Power());
        
        doMath request = key.get(operator);
        return request.execute(input1, input2);
    }
}

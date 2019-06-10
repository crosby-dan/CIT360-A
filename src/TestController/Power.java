package TestController;

/**
 *
 * @author sirri
 */
public class Power implements doMath {
    public Double execute(Double input1, Double input2){
        return Math.pow(input1, input2);
    }
}

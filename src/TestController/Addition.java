/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestController;

/**
 *
 * @author sirri
 */
public class Addition implements doMath {
    public Double execute(Double input1, Double input2){
        Double addition = input1 + input2;
        return addition;
    }
}

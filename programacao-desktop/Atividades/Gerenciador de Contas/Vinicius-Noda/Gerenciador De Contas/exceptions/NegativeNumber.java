/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author noda
 */
public class NegativeNumber extends Exception{

    public NegativeNumber() {
        super("Negative account number not expected!");
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author gabriel
 */
public class InvalidExpressionException extends Exception {

    /**
     * Creates a new instance of <code>InvalidExpression</code> without detail
     * message.
     */
    public InvalidExpressionException() {
    }

    /**
     * Constructs an instance of <code>InvalidExpression</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidExpressionException(String msg) {
        super(msg);
    }
}

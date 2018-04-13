
package calculator;

import views.Calc;

/**
 *
 * @author quintanilhaedu
 */
public class Calculator {
    
    
    
    /**s
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        views.Calc calculator = new Calc();
        calculator.setVisible(true);
        
    }
    
    //Add Number to Visor Method
    public static String addNumber(String txt, String number){
        StringBuilder numbers = new StringBuilder();
        numbers.append(txt).append(number);
        return numbers.toString();
    }
    
    //Calculation Methods
    public static String calcOperation(String txtVisor, String operation, String number){
        StringBuilder numbers = new StringBuilder();
        txtVisor = txtVisor.replace(",",".");
        number = number.replace(",", ".");
        double numbersCalc = Double.parseDouble(txtVisor);
        switch (operation) {
            case "+":
                numbersCalc += (Double) Double.parseDouble(number);
                break;
            case "-":
                numbersCalc -= (Double) Double.parseDouble(number);
                break;
            case "*":
                numbersCalc *= (Double) Double.parseDouble(number);
                break;
            case "/":
                numbersCalc /= (Double) Double.parseDouble(number);
                break;
            default:
                break;
        }
        
        return numbers.append(numbersCalc).toString();        
    }
}

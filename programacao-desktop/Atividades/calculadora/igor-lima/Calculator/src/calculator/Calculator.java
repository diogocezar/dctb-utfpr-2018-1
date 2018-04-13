package calculator;

import javax.swing.SwingUtilities;
import view.GUI;

/**
 *
 * @author igorv
 */
public class Calculator {
    Double result = 0.0;

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GUI gui = new GUI();
                gui.setVisible(true);
            }
        });
    
    }
    
    public String sum(Double value1, Double value2){
        result = (value1 + value2);
        return (String.valueOf(result));
    }
    
    public String sub(Double value1, Double value2){
        result = (value1 - value2);
        return (String.valueOf(result));
    }
    
    public String mul(Double value1, Double value2){
        result = (value1 * value2);
        return (String.valueOf(result));
    }
    
    public String div(Double value1, Double value2){
        result = (value1 / value2);
        return (String.valueOf(result));
    }
    
}

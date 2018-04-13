package calculadora;
/**
 *
 * @author Stefanie
 */

import Interface.FormularioCalc;

public class Calculadora {
    Double result = 0.0;

    public static void main(String[] args) {
        
        //Criando um novo objeto
        FormularioCalc calc = new FormularioCalc(); 
        calc.setVisible(true);
    }
    
    //Metodo para soma
    public String sum(Double value1, Double value2){
        result = (value1 + value2);
        return (String.valueOf(result));
    }
    
    //Metodo para subtracao
    public String subt(Double value1, Double value2){
        result = (value1 - value2);
        return (String.valueOf(result));
    }
    
    //Metodo para divisao
    public String divi(Double value1, Double value2){
        result = (value1 / value2);
        return (String.valueOf(result));
    }
    
    //Metodo para multiplicacao
    public String multi(Double value1, Double value2){
        result = (value1 * value2);
        return (String.valueOf(result));
    } 
    
}

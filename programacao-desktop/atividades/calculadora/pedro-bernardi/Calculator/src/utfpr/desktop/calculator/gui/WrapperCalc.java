package utfpr.desktop.calculator.gui;

import utfpr.desktop.calculator.control.ProcessCalc;

/**
 * Calculadora
 * @author Pedro Bernardi
 */

public class WrapperCalc{

    Calc calc;
    ProcessCalc processCalc;

    public WrapperCalc(){
        processCalc = new ProcessCalc();
        calc = new Calc(processCalc);
    }

    public static void main(String[] args) {
        WrapperCalc initCalc = new WrapperCalc();
    }
}

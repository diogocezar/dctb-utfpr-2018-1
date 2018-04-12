package utfpr.desktop.calculator.control;

import java.math.BigDecimal;

public class ArithmaticCalculatorCommand implements Command {

    private char operator;
    private BigDecimal leftOperand;
    private BigDecimal rightOperand;
    private Calculator calculator;

    public ArithmaticCalculatorCommand( char operator, BigDecimal leftOperand, BigDecimal rightOperand, Calculator calculator ) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operator = operator;
        this.calculator = calculator;
    }

    public void calculate() {
        calculator.operation( operator, leftOperand, rightOperand );
    }
}
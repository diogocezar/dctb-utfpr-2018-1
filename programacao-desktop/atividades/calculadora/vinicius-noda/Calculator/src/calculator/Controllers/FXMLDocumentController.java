/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

/**
 *
 * @author noda
 */
public class FXMLDocumentController implements Initializable {

    private Scene scn;
    private Calculate calcObj;
    private boolean firstNumberAfterOp;

    @FXML
    private Label resultLabel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        calcObj = new Calculate();
    }

    public void setScene(Scene scn) {
        this.scn = scn;
    }

    public void setGlobalEventHandler() {
        scn.setOnKeyPressed(ev -> {
            if (null != ev.getCode()) {
                switch (ev.getCode()) {
                    case ENTER:
                        enterKey();
                        break;
                    case BACK_SPACE:
                        clearKey();
                        break;
                    case PLUS:
                    case ADD:
                        processOp("+");
                        break;
                    case MINUS:
                    case SUBTRACT:
                        processOp("-");
                        break;
                    case ASTERISK:
                    case MULTIPLY:
                        processOp("*");
                        break;
                    case SLASH:
                    case DIVIDE:
                        processOp("/");
                        break;
                    case PERIOD:
                    case DECIMAL:
                        appendTextLabel(".");
                        break;
                    case NUMPAD0:
                    case DIGIT0:
                        appendTextLabel("0");
                        break;
                    case NUMPAD1:
                    case DIGIT1:
                        appendTextLabel("1");
                        break;
                    case NUMPAD2:
                    case DIGIT2:
                        appendTextLabel("2");
                        break;
                    case NUMPAD3:
                    case DIGIT3:
                        appendTextLabel("3");
                        break;
                    case NUMPAD4:
                    case DIGIT4:
                        appendTextLabel("4");
                        break;
                    case NUMPAD5:
                    case DIGIT5:
                        appendTextLabel("5");
                        break;
                    case NUMPAD6:
                    case DIGIT6:
                        appendTextLabel("6");
                        break;
                    case NUMPAD7:
                    case DIGIT7:
                        appendTextLabel("7");
                        break;
                    case NUMPAD8:
                    case DIGIT8:
                        appendTextLabel("8");
                        break;
                    case NUMPAD9:
                    case DIGIT9:
                        appendTextLabel("9");
                        break;
                    default:
                        break;
                }
            }
            ev.consume();
        });
    }

    @FXML
    private void numKey(ActionEvent e) {
        appendTextLabel(((Button) e.getSource()).getText());
    }

    @FXML
    private void opKey(ActionEvent e) {
        processOp(((Button) e.getSource()).getText());
    }

    @FXML
    private void enterKey() {
        processEnter();
    }

    @FXML
    private void clearKey() {
        resultLabel.setText("0");
        calcObj.clearData();
    }

    @FXML
    private void invKey() {
        prependTextLabel("-");
    }

    @FXML
    private void percentageKey() {
        processPercentage();
    }

    private void processOp(String op) {
        if (calcObj.isNum1Set()) {
            //if the first num is set already, apply the operation and put the result in num1
            processEnter();
        }
        calcObj.setNum1(Double.parseDouble(resultLabel.getText()));
        calcObj.setOp(op);
        firstNumberAfterOp = true;
    }

    private void processEnter() {
        if (calcObj.isNum1Set()) {
            //if the first num is set, apply the operation
            calcObj.setNum2(Double.parseDouble(resultLabel.getText()));
            double res = calcObj.calculate();
            setTextLabel(res);
            firstNumberAfterOp = true;
        }
    }

    private void processPercentage() {
        //set bool to use special set of operations
        calcObj.setPercentageOp(true);
        firstNumberAfterOp = true;
        if (calcObj.isNum1Set()) {
            processEnter();
        }
    }

    private void appendTextLabel(String txt) {
        if (firstNumberAfterOp) {
            //clear the last number and begin the next
            if (txt.equals(".")) {
                resultLabel.setText("0" + txt);
            } else {
                resultLabel.setText(txt);
            }
            firstNumberAfterOp = false;
        } else if (resultLabel.getText().equals("0") && !txt.equals(".")) {
            //remove the zero from the beginning if not .
            resultLabel.setText(txt);
        } else if (txt.equals(".") && resultLabel.getText().contains(".")) {
            //block more than one period
            //do nothing
        } else {
            resultLabel.setText(resultLabel.getText() + txt);
        }
    }

    private void prependTextLabel(String txt) {
        if (resultLabel.getText().equals("0")) {
            //do nothing 
        } else if (!resultLabel.getText().contains("-")) {
            //add -
            resultLabel.setText(txt + resultLabel.getText());
        } else {
            //remove the -
            resultLabel.setText(resultLabel.getText().substring(1));
        }
    }

    private void setTextLabel(double num) {
        if ((num % 1) == 0) {
            //no need for the .0 after the number
            resultLabel.setText(String.valueOf((long) num));
        } else {
            resultLabel.setText(String.valueOf(num));
        }
    }
}

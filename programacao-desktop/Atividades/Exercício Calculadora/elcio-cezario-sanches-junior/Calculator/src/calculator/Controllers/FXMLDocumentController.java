/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.Controllers;

import calculator.Calculate;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author ecaanchesjr
 */
public class FXMLDocumentController implements Initializable {
    private Scene scene;
    private boolean dotKey;
    private Calculate calc;
    private boolean afterOperation;
    @FXML
    private Label screen;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afterOperation=false;
        dotKey=false;
        calc=new Calculate();
    }    

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void setGlobalEventHandler() {
        scene.setOnKeyPressed(ev -> {
            if(ev.getCode() != null) switch(ev.getCode()) {
                case NUMPAD0:
                case DIGIT0:
                    appendCtrl("0");
                    break;
                case NUMPAD1:
                case DIGIT1:
                    appendCtrl("1");
                    break;
                case NUMPAD2:
                case DIGIT2:
                    appendCtrl("2");
                    break;
                case NUMPAD3:
                case DIGIT3:
                    appendCtrl("3");
                    break;
                case NUMPAD4:
                case DIGIT4:
                    appendCtrl("4");
                    break;
                case NUMPAD5:
                case DIGIT5:
                    appendCtrl("5");
                    break;
                case NUMPAD6:
                case DIGIT6:
                    appendCtrl("6");
                    break;
                case NUMPAD7:
                case DIGIT7:
                    appendCtrl("7");
                    break;
                case NUMPAD8:
                case DIGIT8:
                    appendCtrl("8");
                    break;
                case NUMPAD9:
                case DIGIT9:
                    appendCtrl("9");
                    break;
                case ENTER:
                    processOperation("=");
                    break;
                case BACK_SPACE:
                    clearPress();
                    break;
                case PLUS:
                case ADD:
                    processOperation("+");
                    break;
                case MINUS:
                case SUBTRACT:
                    processOperation("-");
                    break;
                case ASTERISK:
                case MULTIPLY:
                    processOperation("x");
                    break;
                case SLASH:
                case DIVIDE:
                    processOperation("/");
                    break;
                case PERIOD:
                case DECIMAL:
                case COMMA:
                    appendCtrl(".");
                    break;
            }
        });
    }
    
    @FXML
    private void operationPress(ActionEvent evt) {
        processOperation(((Button)evt.getSource()).getText());
    }
    
    @FXML 
    private void clearPress() {
        screen.setText("0");
        dotKey=false;
        calc.clearData();
    }
    
    @FXML
    private void equalsPress() {
        if(calc.isValue1Set()) {
            calc.setValue2(screen.getText());
            
            setResultOperation(calc.calculate());
            
            calc.setOperation("");
            calc.setValue1Set(false);
        }
    }
    
    @FXML
    private void numPress(ActionEvent evt) {
        appendCtrl(((Button)evt.getSource()).getText());
    }
    
    private void appendCtrl(String key) {
        if(afterOperation) {
            // first number after another operation
            screen.setText(key);
            afterOperation=false;
        } else {
            // se for um . bloquear .
            if(key.equals(".")) {
                if(!dotKey) {
                    appendScreen(key);
                    dotKey=!dotKey;
                }
            } else {
                // se for 0 só insere o número
                if(screen.getText().equals("0")) {
                    screen.setText(key);
                } else  {
                    // se tiver algum número, colocar à direita
                    appendScreen(key);
                }   
            }
        }
    }
    
    private void appendScreen(String key) {
        String text;
        
        text=screen.getText();
        text+=key;
        screen.setText(text);
    }
    
    private void processOperation(String operation) {
        if(calc.isValue1Set()){
            // se já foi colocado um valor
            
            calc.setValue2(screen.getText());
            double result = calc.calculate();
            calc.setOperation(operation);
            calc.setValue1(""+result);
            
            setResultOperation(result);
        } else {
            // primeiro valor
            
            calc.setValue1(screen.getText());
            calc.setOperation(operation);
            calc.setValue1Set(true);
            screen.setText("0");
            dotKey=false;
        }
    }
    
    private void setResultOperation(double result) {
        // If result is Integer, not show the .0 in right
        if(result == (int)result) 
            screen.setText(""+(int)result); 
        else 
            screen.setText(""+result);
        
        afterOperation=true;   
    }
}

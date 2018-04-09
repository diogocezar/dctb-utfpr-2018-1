/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import Model.BasicSolver;
import Model.ParserSolver;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.plaf.basic.BasicArrowButton;

/**
 *
 * @author gabriel
 */
public class CalculatorFXMLController implements Initializable {

    ///JavaFX Components
    //Buttons
    @FXML
    private Button Bt1;
    @FXML
    private Button Bt2;
    @FXML
    private Button Bt3;
    @FXML
    private Button Bt4;
    @FXML
    private Button Bt5;
    @FXML
    private Button Bt6;
    @FXML
    private Button Bt7;
    @FXML
    private Button Bt8;
    @FXML
    private Button Bt9;
    @FXML
    private Button Bt0;
    @FXML
    private Button Btplus;
    @FXML
    private Button BtMinus;
    @FXML
    private Button BtX;
    @FXML
    private Button BtDiv;
    @FXML
    private Button BtEqual;
    @FXML
    private Button BtDot;
    @FXML
    private Button BtAc;
    //TextField
    @FXML
    private TextField Equation;
    // Message 
    @FXML
    private Text Message;
    //Radios
    @FXML
    private RadioButton ParserRadio;
    @FXML
    private RadioButton BasicRadio;
    // Internal Components
    ToggleGroup tg;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Message.setText("");
        tg = new ToggleGroup();
        ParserRadio.setToggleGroup(tg);
        BasicRadio.setToggleGroup(tg);
        tg.selectToggle(ParserRadio);
    }

    //JavaFX methods
    public void clickButtonNumbers(Event e) {
        if (e.getSource() == Bt1) {
            Equation.appendText("1");
        } else if (e.getSource() == Bt2) {
            Equation.appendText("2");
        } else if (e.getSource() == Bt3) {
            Equation.appendText("3");
        } else if (e.getSource() == Bt4) {
            Equation.appendText("4");
        } else if (e.getSource() == Bt5) {
            Equation.appendText("5");
        } else if (e.getSource() == Bt6) {
            Equation.appendText("6");
        } else if (e.getSource() == Bt7) {
            Equation.appendText("7");
        } else if (e.getSource() == Bt8) {
            Equation.appendText("8");
        } else if (e.getSource() == Bt9) {
            Equation.appendText("9");
        } else if (e.getSource() == Bt0) {
            Equation.appendText("0");
        } else if (e.getSource() == BtDot) {
            Equation.appendText(".");
        }

    }

    @FXML
    public void modeChange() {
        Message.setText("");
    }

    @FXML
    public void clickButtonFunc(Event e) {
        if (ParserRadio.isSelected()) {
            parseMethod(e);
        } else if (BasicRadio.isSelected()) {
            basicMethod(e);
        }
    }

    @FXML
    public void closeApplication() {
        System.exit(0);
    }

    @FXML
    public void showAbout() {
        try {
            Parent aboutFXML = FXMLLoader.load(getClass().getResource("About.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(aboutFXML);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.setTitle("Calculator");
            stage.show();
        } catch (Exception e) {
            //
        }
    }

    @FXML
    public void resolve() {
        try {
            Equation.setText(Double.toString(ParserSolver.solve(Equation.getText())));
            Equation.positionCaret(Equation.getText().length());
            Message.setText("");
        } catch (Exception ex) {
            Message.setText(ex.getMessage());
        }
    }

    //Internal Methods
    private void realizeOperation(double value) {
        BasicSolver.getInstance().setNextValue(value);
        BasicSolver.getInstance().runOperation();
        BasicSolver.getInstance().setWaitIngValue(true);
        SetMessage();
        Equation.clear();
    }

    private void SetMessage() {
        double d = BasicSolver.getInstance().getBuffer();
        String formatted = String.format("%.1f", d);
        Message.setText("Atual: " + formatted);
    }

    private void clearAll() {
        BasicSolver.getInstance().setBuffer(0);
        BasicSolver.getInstance().setOperation("");
        BasicSolver.getInstance().setNextValue(0);
        BasicSolver.getInstance().setWaitIngValue(false);
        SetMessage();
        Equation.clear();
    }

    private void basicMethod(Event e) {
        if (e.getSource() == Btplus) {
            BasicSolver.getInstance().setOperation("+");
        } else if (e.getSource() == BtMinus) {
            BasicSolver.getInstance().setOperation("-");
        } else if (e.getSource() == BtX) {
            BasicSolver.getInstance().setOperation("x");
        } else if (e.getSource() == BtDiv) {
            BasicSolver.getInstance().setOperation("/");
        } else if (e.getSource() == BtAc) {
            clearAll();
        } else if (e.getSource() == BtEqual) {
            try {
                double value = Double.parseDouble(Equation.getText());
                BasicSolver.getInstance().setNextValue(value);
                BasicSolver.getInstance().runOperation();
                Equation.setText(Double.toString(BasicSolver.getInstance().getBuffer()));
                BasicSolver.getInstance().setWaitIngValue(false);
            } catch (Exception ex) {
                //
            }
        }
        try {
            double value = Double.parseDouble(Equation.getText());
            realizeOperation(value);
        } catch (Exception ex) {
            //
        }
    }

    private void parseMethod(Event e) {
        if (e.getSource() == Btplus) {
            Equation.appendText(" + ");
        } else if (e.getSource() == BtMinus) {
            Equation.appendText(" - ");
        } else if (e.getSource() == BtX) {
            Equation.appendText(" x ");
        } else if (e.getSource() == BtDiv) {
            Equation.appendText(" / ");
        } else if (e.getSource() == BtAc) {
            Equation.setText("");
        } else if (e.getSource() == BtEqual) {
            resolve();
        }
    }

}

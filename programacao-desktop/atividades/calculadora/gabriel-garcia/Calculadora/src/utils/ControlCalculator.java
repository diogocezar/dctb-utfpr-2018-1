package utils;

import java.util.ArrayList;
import view.Calculator;

public class ControlCalculator {

    Calculator calc;
    private double result = 0;

    private ArrayList<Double> toAdd;
    private ArrayList<Double> toSubtract;
    private ArrayList<Double> toDivide;
    private ArrayList<Double> toMultiply;
    private ArrayList<Double> toPercent;

    public ControlCalculator() {
        toAdd = new ArrayList<>();
        toSubtract = new ArrayList<>();
        toDivide = new ArrayList<>();
        toMultiply = new ArrayList<>();
        toPercent = new ArrayList<>();
    }
    
    public String result(){
        result = 0;
        if (toAdd.size() > 0) {
            result = toAdd.get(0);
            try {
                for (int i = 1; i < toAdd.get(i); i++) {
                    result = result + toAdd.get(i);
                }
            } catch (Exception e) {
            }
            return String.valueOf(result);
        }
        if (toSubtract.size() > 0) {
            result = toSubtract.get(0);
            try {
                for (int i = 1; i < toSubtract.size(); i++) {
                    result = result - toSubtract.get(i);
                }
            } catch (Exception e) {
            }
            return String.valueOf(result);
        }
        if (toMultiply.size() > 0) {
            result = toMultiply.get(0);
            try {
                for (int i = 1; i < toMultiply.size(); i++) {
                    result = (result * toMultiply.get(i));
                }
            } catch (Exception e) {
            }
            return String.valueOf(result);
        }
        if (toDivide.size() > 0) {
            result = toDivide.get(0);
            try {
                for (int i = 1; i < toDivide.size(); i++) {
                    result = result / toDivide.get(i);
                }
            } catch (Exception e) {
            }
            return String.valueOf(result);
        }
        if(toPercent.size() > 0){
            result = toPercent.get(0) / 100;
            result = toPercent.get(1) * result;
            return String.valueOf(result);
        }
        return null;
    }

    public void clean() {
        toAdd.clear();
        toSubtract.clear();
        toDivide.clear();
        toMultiply.clear();
        result = 0.0;
    }

    public void setToAdd(Double num) {
        toAdd.add(num);
    }

    public void setToSubtract(Double num) {
        toSubtract.add(num);
    }

    public void setToDivide(Double num) {
        toDivide.add(num);
    }

    public void setToMultiply(Double num) {
        toMultiply.add(num);
    }

    public ArrayList<Double> getToAdd() {
        return toAdd;
    }

    public ArrayList<Double> getToSubtract() {
        return toSubtract;
    }

    public ArrayList<Double> getToDivide() {
        return toDivide;
    }

    public ArrayList<Double> getToMultiply() {
        return toMultiply;
    }

    public ArrayList<Double> getToPercent() {
        return toPercent;
    }

    public void setToPercent(Double num) {
        toPercent.add(num);
    }
}

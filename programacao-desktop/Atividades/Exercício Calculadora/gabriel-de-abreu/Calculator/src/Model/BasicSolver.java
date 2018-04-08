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
public class BasicSolver {
    private double Buffer=0;
    private double nextValue=0;
    private boolean waitIngValue=false;
    private String operation;
    
    public void runOperation(){
        if(waitIngValue){
            if(operation.equals("-")){
                Buffer-=nextValue;
            }
            else if(operation.equals("+")){
                Buffer+=nextValue;
            }
            else if(operation.equals("x")){
                Buffer*=nextValue;
            }
            else if(operation.equals("/")){
                Buffer/=nextValue;
            }
        }else{
            Buffer=nextValue;
        }
    }
    public boolean isWaitIngValue() {
        return waitIngValue;
    }

    public void setWaitIngValue(boolean waitIngOp) {
        this.waitIngValue = waitIngOp;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
    

    public double getNextValue() {
        return nextValue;
    }

    public void setNextValue(double nextValue) {
        this.nextValue = nextValue;
    }
    
    
    public double getBuffer() {
        
        return Buffer;
    }

    public void setBuffer(double Buffer) {
        this.Buffer = Buffer;
    }
    
    private BasicSolver() {
    }
    
    public static BasicSolver getInstance() {
        return BasicSolverHolder.INSTANCE;
    }
    
    private static class BasicSolverHolder {

        private static final BasicSolver INSTANCE = new BasicSolver();
    }
}

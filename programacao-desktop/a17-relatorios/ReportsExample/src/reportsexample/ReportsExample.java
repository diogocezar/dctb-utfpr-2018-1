/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportsexample;

/**
 *
 * @author diogo
 */
public class ReportsExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            new JasperReportExample().generate("report.jrxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

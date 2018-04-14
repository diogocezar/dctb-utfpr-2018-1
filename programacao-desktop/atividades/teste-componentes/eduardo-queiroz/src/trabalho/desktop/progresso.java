/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.desktop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import javax.swing.JProgressBar;
import javax.swing.Timer;

/**
 *
 * @author Eduardo Queiroz
 */
class progresso implements ActionListener {

    JProgressBar jProgressBar1;
    Timer timer;
    public progresso(JProgressBar _jProgressBar1, Timer _timer) {
        this.jProgressBar1 = _jProgressBar1;
        this.timer = _timer;
    } 

    progresso() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int n = jProgressBar1.getValue();
            jProgressBar1.setMaximum(100);
            if(n < 100){
                n = n + 2;
                jProgressBar1.setValue(n);
                jProgressBar1.setString(n + "%");
            }else{
                timer.stop();     
            }
    }
    
    
}

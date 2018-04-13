package calculadora;

import com.sun.glass.ui.Cursor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Calculadora extends JFrame {
    JButton[] botao = new JButton[20];
    JFrame janela = new JFrame();
    JLabel texto = new JLabel("0");
    String acm = "";
    float aux,aux2;
    int indc;
    
    public void interfaceCalculadora(){
        botao[0] = new JButton("AC");botao[1] = new JButton("+/-");botao[2] = new JButton("%");
        botao[3] = new JButton("÷");botao[4] = new JButton("7");botao[5] = new JButton("8");
        botao[6] = new JButton("9");botao[7] = new JButton("X");botao[8] = new JButton("4");
        botao[9] = new JButton("5");botao[10] = new JButton("6");botao[11] = new JButton("-");
        botao[12] = new JButton("1");botao[13] = new JButton("2");botao[14] = new JButton("3");
        botao[15] = new JButton("+");botao[16] = new JButton("0");botao[17] = new JButton("00");
        botao[18] = new JButton(",");botao[19] = new JButton("=");
       
        botao[0].addActionListener(new Manipular0());
        botao[1].addActionListener(new Manipular1());
        botao[2].addActionListener(new Manipular2());
        botao[3].addActionListener(new Manipular3());
        botao[4].addActionListener(new Manipular4());
        botao[5].addActionListener(new Manipular5());
        botao[6].addActionListener(new Manipular6());
        botao[7].addActionListener(new Manipular7());
        botao[8].addActionListener(new Manipular8());
        botao[9].addActionListener(new Manipular9());
        botao[10].addActionListener(new Manipular10());
        botao[11].addActionListener(new Manipular11());
        botao[12].addActionListener(new Manipular12());
        botao[13].addActionListener(new Manipular13());
        botao[14].addActionListener(new Manipular14());
        botao[15].addActionListener(new Manipular15());
        botao[16].addActionListener(new Manipular16());
        botao[17].addActionListener(new Manipular17());
        botao[18].addActionListener(new Manipular18());
        botao[19].addActionListener(new Manipular19());
        
        
        
        JPanel painel = new JPanel(new GridLayout(5,4));
        JPanel painelTexto = new JPanel();
        
        painelTexto.add(texto);
        texto.setPreferredSize(new Dimension(230,90));
        texto.setHorizontalAlignment(SwingConstants.RIGHT);
        texto.setBorder(BorderFactory.createTitledBorder(""));
        texto.setFont(new Font("Consolas", Font.PLAIN, 49));
        texto.setForeground(Color.WHITE);
        painelTexto.setBackground(new Color(78,78,78));
        
        for (int i = 0; i < botao.length; i++) {
            painel.add(botao[i]);
            botao[i].setBackground(new Color(226,226,226));
            botao[i].setForeground(Color.BLACK);
            botao[i].setFont(new Font("Consolas", Font.PLAIN, 20));
        }
        for(int i = 3; i < botao.length;i+=4){
            botao[i].setBackground(new Color(247, 123, 0));
            botao[i].setForeground(Color.WHITE);
        }
        
        janela.getContentPane().add(BorderLayout.NORTH,painelTexto);
        janela.getContentPane().add(BorderLayout.CENTER,painel); 
        janela.setSize(300,400);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(janela.EXIT_ON_CLOSE);
    }    
    
    public class Manipular0 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0){
           texto.setText("");
           acm = ""; 
           aux = 0; aux2 = 0;
        }
    }
    public class Manipular1 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0){
            aux = Float.parseFloat(acm);
            texto.setText("");
            acm = "";
            String resultado = Float.toString(aux * -1);
            texto.setText(resultado);
        }
    }
    public class Manipular2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0){
            aux = Float.parseFloat(acm);
            texto.setText("");
            acm = "";
            acm = Float.toString(aux / 100);
            texto.setText(acm);
        }
    }
    public class Manipular3 implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent arg0) {
            aux = Float.parseFloat(acm);
            texto.setText("");
            acm = "";
            indc = 1;
        }	 
    }
    public class Manipular4 implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent arg0) {
            acm = acm + 7;
            texto.setText(acm);	
        }	 
    }
    public class Manipular5 implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent arg0) {
            acm = acm + 8;
            texto.setText(acm);	
        }	 
    }
    public class Manipular6 implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent arg0) {
            acm = acm + 9;
            texto.setText(acm);	
        }	 
    }
    public class Manipular7 implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent arg0) {
            aux = Float.parseFloat(acm);;
            texto.setText("");
            acm = "";
            indc = 2;
        }	 
    }
    public class Manipular8 implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent arg0) {
            acm = acm + 4;
            texto.setText(acm);	
        }	 
    }
    public class Manipular9 implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent arg0) {
            acm = acm + 5;
            texto.setText(acm);	
        }	 
    }
    public class Manipular10 implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent arg0) {
            acm = acm + 6;
            texto.setText(acm);	
        }	 
    }
    public class Manipular11 implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent arg0) {
            aux = Float.parseFloat(acm);
            texto.setText("");
            acm = "";
            indc = 3;
        }	 
    }
    public class Manipular12 implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent arg0) {
            acm = acm + 1;
            texto.setText(acm);	
        }	 
    }
    public class Manipular13 implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent arg0) {
            acm = acm + 2;
            texto.setText(acm);	
        }	 
    }
    public class Manipular14 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0){
            acm = acm + 3;
            texto.setText(acm);
        }
    }
    public class Manipular15 implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent arg0) {
            aux = Float.parseFloat(acm);
            texto.setText("");
            acm = "";
            indc = 4;
        }	 
    }
    public class Manipular16 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0){
            acm = acm + 0;
            texto.setText(acm);
        }
    }
    public class Manipular17 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0){
            acm = acm + 0 + '0';
            texto.setText(acm);
        }
    }
    public class Manipular18 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0){
            acm = acm + '.';
            texto.setText(acm);
        }
    }
    public class Manipular19 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0){
            switch(indc){
                case 1: 
                    aux2 = Float.parseFloat(acm);
                    String resultado = Float.toString(aux / aux2);
                    texto.setText(resultado);
                    indc = 0;
                    break;
                case 2:
                    aux2 = Float.parseFloat(acm);
                    String resultado2 = Float.toString(aux * aux2);
                    texto.setText(resultado2);
                    indc = 0;
                    break;
                case 3:
                    aux2 = Float.parseFloat(acm);
                    String resultado3 = Float.toString(aux - aux2);
                    texto.setText(resultado3);
                    indc = 0;
                    break;
                case 4: 
                    aux2 = Float.parseFloat(acm);
                    String resultado4 = Float.toString(aux + aux2);
                    texto.setText(resultado4);
                    indc = 0;
                    break;
            }
            aux = 0; aux2 = 0;
        }
    }
}
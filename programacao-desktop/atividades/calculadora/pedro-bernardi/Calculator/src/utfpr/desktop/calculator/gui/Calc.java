package utfpr.desktop.calculator.gui;

import utfpr.desktop.calculator.control.ProcessCalc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.util.Objects;

/**
 * Classe principal do gui da calculadora
 */

public class Calc extends JFrame implements ActionListener, MouseListener {
    private ProcessCalc processCalc;
    private VisorPanel panelVisor;
    private JPanel panelButtons;
    private JButton[] buttonsSimbol;
    public boolean typing = false;
    public static final Dimension DIMENSIONS = new Dimension(250, 350);

    public Calc(ProcessCalc processCalc) throws HeadlessException {
        super();
        this.processCalc = processCalc;
        setUndecorated(true);
        setMinimumSize(DIMENSIONS);
        setMaximumSize(DIMENSIONS);
        setPreferredSize(DIMENSIONS);
        setShape(new RoundRectangle2D.Double(0, 0, DIMENSIONS.width, DIMENSIONS.height, 15, 15));
        revalidate();
        setLayout(new BorderLayout());
        init();
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void init() {
        //Criar componentes
        panelVisor = new VisorPanel(this);
        panelButtons = new JPanel(new GridBagLayout());
        buttonsSimbol = new JButton[20];

        //Determinar tamanhos
        panelVisor.setPreferredSize(new Dimension(235, 85));

        //Ativar componentes
        panelVisor.setVisible(true);
        panelButtons.setVisible(true);

        //Adicionar componentes
        add(panelVisor, BorderLayout.NORTH);
        add(panelButtons, BorderLayout.CENTER);
        initButtons();
        panelVisor.getExit().addMouseListener(this);

        //Determinar cores
        panelVisor.setBackground(new Color(0x172836));
        for (int i = 0; i < buttonsSimbol.length; i++)
            buttonsSimbol[i].setBackground(new Color(0xE0E0E0));
        for (int i = 15; i < buttonsSimbol.length; i++) {
            buttonsSimbol[i].setBackground(new Color(0xF79231));
            buttonsSimbol[i].setForeground(Color.WHITE);
        }
    }

    public void initButtons() {
        GridBagConstraints gbc = new GridBagConstraints();
        //Vetor com texto de botão
        String buttons[] = {"AC", "7", "4", "1", "", "CE", "8", "5", "2", "0", "%", "9", "6", "3", ",", "÷", "×", "−", "+", "="};
        //Posicionar botões com gridbaglayout
        for (int x = 0, z = 0; x < 4; x++) {
            for (int y = 0; y < 5; y++, z++) {
                buttonsSimbol[z] = new JButton(buttons[z]);
                gbc.fill = GridBagConstraints.BOTH;
                gbc.weightx = 1;
                gbc.weighty = 1;
                gbc.gridx = x;
                gbc.gridy = y;
                panelButtons.add(buttonsSimbol[z], gbc);
                buttonsSimbol[z].setPreferredSize(new Dimension(30, 20));
                buttonsSimbol[z].setFocusPainted(false);
                buttonsSimbol[z].addActionListener(this);
            }
        }
        panelButtons.remove(buttonsSimbol[4]);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panelButtons.add(buttonsSimbol[9], gbc);
        Font font = new Font("HelveticaNeueLT Std Thin", Font.PLAIN, 23);
        for (JButton button : buttonsSimbol)
            button.setFont(font);
        buttonsSimbol[0].setFont(new Font("HelveticaNeueLT Std Thin", Font.PLAIN, 20));
        buttonsSimbol[5].setFont(new Font("HelveticaNeueLT Std Thin", Font.PLAIN, 20));
        buttonsSimbol[9].setHorizontalAlignment(SwingConstants.LEFT);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (arg0.getSource() instanceof JButton) {
            if (arg0.getSource() == buttonsSimbol[0]) {//Botão AC
                removeAllText("0");
                typing = false;
            } else if(arg0.getSource() == buttonsSimbol[5]) {//Botão CE
                removeLast();
            } else if(arg0.getSource() == buttonsSimbol[10]) {//Botão percent
                String result = processCalc.percent(panelVisor.getTextVisor().getText());
                panelVisor.getTextVisor2().setText(panelVisor.getTextVisor2().getText() + result);
                typing = false;
            }else if ((find(arg0.getSource())) > 14) { //Botões de calculos
                if (panelVisor.getTextVisor().getText().length() > 0) {
                    setText2(arg0);
                }
                result(arg0);
                if (((JButton) arg0.getSource()).getText() == "=")
                    reset();
                typing = false;
            } else { // Bot~~oes númericos
                if (!typing)
                    removeAllText("");
                setText(arg0);
                typing = true;
            }
        }
    }

    /**
     * Colocar texto na parte inferior do visor
     */
    public void setText(ActionEvent arg0) {
        panelVisor.getTextVisor().setText(panelVisor.getTextVisor().getText() + (((JButton) arg0.getSource()).getText()));
    }

    /**
     * Colocar texto na parte superior do visor
     * @param arg0
     */
    public void setText2(ActionEvent arg0) {
        panelVisor.getTextVisor2().setText(panelVisor.getTextVisor2().getText() + panelVisor.getTextVisor().getText() + (((JButton) arg0.getSource()).getText()));
    }

    /**
     * Remover texto ou somente da parte inferior
     * @param text
     */
    public void removeAllText(String text) {
        panelVisor.getTextVisor().setText(text);
        if (text == "0")
            panelVisor.getTextVisor2().setText("");
    }

    /**
     * Remover ultimo caractere do que foi digitado
     */
    public void removeLast(){
        if (panelVisor.getTextVisor().getText().length() > 0)
            panelVisor.getTextVisor().setText(panelVisor.getTextVisor().getText().substring(0, panelVisor.getTextVisor().getText().length() - 1));
    }

    /**
     * Resetar texto do visor
     */
    public void reset() {
        panelVisor.getTextVisor2().setText("");
    }

    public int find(Object o) {
        for (int i = 0; i < buttonsSimbol.length; i++) {
            if (Objects.equals(buttonsSimbol[i], o))
                return i;
        }
        return 0;
    }

    public void result(ActionEvent arg0) {
        String expression = panelVisor.getTextVisor2().getText();
        expression = expression.substring(0, expression.length() - 1);
        String result = processCalc.start(expression);
        panelVisor.getTextVisor().setText(result);
    }

    @Override
    public void mouseClicked(MouseEvent arg1) {
        if (arg1.getSource() == panelVisor.getExit())
            System.exit(0);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        panelVisor.switchExit(false);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        panelVisor.switchExit(true);
    }
}

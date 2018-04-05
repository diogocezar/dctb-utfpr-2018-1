package exemplo4;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JButtonDemo implements ActionListener {

    JLabel jlab;

    JButtonDemo() {

        // CRIA UM CONTEINER JFRAME.
        JFrame jfrm = new JFrame(" EXEMPLO DE JBUTTON");

        // ESPECIFICA FLOWLAYOUT COMO GREENCIADOR DE LEIAUTE
        jfrm.setLayout(new FlowLayout());

        // FORNECE UM TAMANHO INICIAL PARA O QUADRO
        jfrm.setSize(300, 200);

        // ENCERRA O PROGRAMA QUANDO O USUÁRIO FECHA O APLICATIVO
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // CRIA OS BOTÕES
        ImageIcon goIcon = new ImageIcon(getClass().getResource("/imagens/verde.png"));
        JButton jbtnGo = new JButton(goIcon);
        jbtnGo.setActionCommand(" PASSE ");
        jbtnGo.addActionListener(this);

        ImageIcon cautionIcon = new ImageIcon(getClass().getResource("/imagens/amarelo.png"));
        JButton jbtnCaution = new JButton(cautionIcon);
        jbtnCaution.setActionCommand(" ATENÇÃO ");
        jbtnCaution.addActionListener(this);

        ImageIcon stopIcon = new ImageIcon(getClass().getResource("/imagens/vermelho.png"));
        JButton jbtnStop = new JButton(stopIcon);
        jbtnStop.setActionCommand(" PARE ");
        jbtnStop.addActionListener(this);

        // ADICIONA OS BOTÕES AO PAINEL DE CONTEÚDO
        jfrm.add(jbtnGo);
        jfrm.add(jbtnCaution);
        jfrm.add(jbtnStop);

        // CCRIA E ADICIONA O RÓTULO AO PAINEL DE CONTEÚDO
        jlab = new JLabel(" ESCOLHA UMA COR ");
        jfrm.add(jlab);

        // EXIBE O QUADRO
        jfrm.setVisible(true);
    }

    // TRATADOR DE EVENTOS
    public void actionPerformed(ActionEvent ae) {
        jlab.setText(" VOCÊ SELECIONOU : " + ae.getActionCommand() + ".");
    }
}

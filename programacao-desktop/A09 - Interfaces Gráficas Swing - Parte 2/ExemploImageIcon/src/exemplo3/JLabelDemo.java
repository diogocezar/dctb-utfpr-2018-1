package exemplo3;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class JLabelDemo {

    JLabelDemo() {

        // CRIA UM CONTEINER JFRAME
        JFrame jfrm = new JFrame("JLABEL COM ÍCONES DE IMAGENS");

        // FORNECE UM TAMANHO INICIAL PARA O QUADRO
        jfrm.setSize(500, 500);

        // ENCERRA O PROGRAMA QUANDO O USUÁRIO FECHA O APLICATIVO
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // CRIA UM ÍCONE E UM RÓTULO PARA VERDE
        ImageIcon goIcon = new ImageIcon(getClass().getResource("/imagens/verde.png"));
        JLabel jlabGo = new JLabel(" PASSE ", goIcon, SwingConstants.LEFT);

        // CRIA UM ÍCONE E UM RÓTULO PARA AMARELO
        ImageIcon cautionIcon = new ImageIcon(getClass().getResource("/imagens/amarelo.png"));
        JLabel jlabCaution = new JLabel(" ATENÇÃO  ", cautionIcon, SwingConstants.CENTER);

        // CRIA UM ÍCONE E UM RÓTULO PARA VERMELHO
        ImageIcon stopIcon = new ImageIcon(getClass().getResource("/imagens/vermelho.png"));
        JLabel jlabStop = new JLabel(" PARE", stopIcon, SwingConstants.RIGHT);

        // ADICIONA OS RÓTULOS AOS PAINEL DE CONTEÚDO
        jfrm.add(jlabGo, BorderLayout.NORTH);
        jfrm.add(jlabCaution, BorderLayout.CENTER);
        jfrm.add(jlabStop, BorderLayout.SOUTH);

        // EXIBE O QUADRO
        jfrm.setVisible(true);
    }

}

package exemplo5;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

public class JToggleButtonDemo {

    JLabel jlab;
    JToggleButton jtbn;

    JToggleButtonDemo() {

        //CRIA UM CONTEINER JFRAME
        JFrame jfrm = new JFrame(" EXEMPLO DE JToggleButton - botão de alternância");

        //ESPECIFICA FLOWLAYOUT COMO GERENCIADOR DE LEIAUTE
        jfrm.setLayout(new FlowLayout());

        //FORNECE UM TAMANHO INICIAL PAR AO QUADRO
        jfrm.setSize(250, 100);

        //ENCERRA O PROGRAMA QUANDO O USUÁRIO FECHA O APLICATIVO
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //CRIA UM RÓTULO
        jlab = new JLabel(" O BOTÃO NÃO ESTÁ SELECIONADO ");

        //CRIA UM BOTÃO DE ALTERNÂNCIA
        jtbn = new JToggleButton("On/Off");

        // ADICIONA UM OUVINTE DE ITENS PARA O BOTÃO DE ALTERNÂNCIA
        //USA UM ITEM LISTENER PARA TRATAR EVENTOS DO BOTÃO DE ALTERNÂNCIA
        //USA IS SELECTED() PARA DETERMINAR O ESTADO DO BOTÃO
        jtbn.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                if (jtbn.isSelected()) {
                    jlab.setText(" O BOTÃO ESTÁ SELECIONADO" );
                } else {
                    jlab.setText(" O BOTÃO NÃO ESTÁ SELECIONADO.");
                }
            }
        });

        // ADICIONA O BOTÃO DE ALTERNÂNCIA E O RÓTULO AO PAINEL DE CONTEÚDO
        jfrm.add(jtbn);
        jfrm.add(jlab);

        // Display the frame.
        jfrm.setVisible(true);
    }
}

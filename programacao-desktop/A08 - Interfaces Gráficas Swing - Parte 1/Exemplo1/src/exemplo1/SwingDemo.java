//PACOTE EM QUE A CLASSE JAVA ESTÁ ALOCADA
package exemplo1;
//IMPORTAÇÃO DE OUTRAS CLASSES JAVA NECESSÁRIAS PARA ESTA CLASSE
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * @author Cissa Gatto
 */
public class SwingDemo {

    SwingDemo() {

        //CRIA UM CONTEINER JFRAME (CONTEINER)
        //CRIA UM CONTEINER DE NÍVEL SUPERIOR (jframe)
        JFrame jfrm = new JFrame(" UMA APLICAÇÃO SWING SIMPLES");

        //FORNECE UM TAMANHO INICIAL PARA O QUADRO (jframe)
        //DEFINE AS DIMENSÕES DO CONTEINER (275,100)
        jfrm.setSize(275, 100);

        //ENCERRA O PROGRAMA QUANDO O USUÁRIO FECHA O APLICATIVO
        //ENCERRA O PROGRAMA QUANDO O USUÁRIO CLICA NA CAIXA FECHAR (exit_on_close)
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //CRIA UM RÓTULO BASEADO EM TEXTO (STRING)
        //CRIA UM JLABEL (NEW JLABEL)
        JLabel jlab = new JLabel(" SWING DEFINE UMA MODERNA INTERFACE GRÁFICA EM JAVA.");

        //ADICIONA O RÓTULO (JLABEL) AO PAINEL DE CONTEÚDO (JFRM)
        jfrm.add(jlab);

        //EXIBE O QUADRO.
        //TRUE TORNA O QUADRO VISIVEL
        jfrm.setVisible(true);
    }
}

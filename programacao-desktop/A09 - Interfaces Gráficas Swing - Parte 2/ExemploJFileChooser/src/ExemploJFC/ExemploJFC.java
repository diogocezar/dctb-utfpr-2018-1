package ExemploJFC;

import java.awt.BorderLayout;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ExemploJFC extends JFrame {

    private JTextArea jtextarea;
    private JScrollPane scrollPane;

    public ExemploJFC() {
        super(" TESTANDO CLASSE ARQUIVO ");
        jtextarea = new JTextArea();
        //ADICIONA JTEXTAREA À SCROLL PANE
        scrollPane = new JScrollPane(jtextarea);
        //ADICIONA O SCROLL PANE À GUI
        add(scrollPane, BorderLayout.CENTER);
        // CONFIGURA O TAMANHO DA JANELA
        setSize(400, 400);
        //EXIBE A GUI
        setVisible(true);
        analyzePath();
    }

    private void analyzePath() {
        //CRIA UM OBJETO ARQUIVO COM BASE NA ENTRADA DO USUÁRIO
        File nome = getArquivo();
        //VERIFICAR SE O NOME EXISTE
        //SE SIM, MOSTRA INFORMAÇÕES SOBRE ELE
        if (nome.exists()) {
            jtextarea.setText(String.format(" %s%s \n %s \n %s \n %s \n %s%s \n %s%s \n %s%s \n %s%s \n %s%s ",
                    nome.getName(), " EXISTE ",
                    (nome.isFile() ? " É um arquivo " : " Não é um arquivo "),
                    (nome.isDirectory() ? " É um diretório " : " Não é um diretório "),
                    (nome.isAbsolute() ? " é um caminho absoluto " : " não é um caminho absoluto "),
                    " Ultima Modificação: ", nome.lastModified(),
                    " TAMANHO: ", nome.length(),
                    " CAMINHO: ", nome.getPath(),
                    " CAMINHO ABSOLUTO: ", nome.getAbsolutePath(),
                    " PARENT: ", nome.getParent()));
            if (nome.isDirectory()) {
                String diretorio[] = nome.list();
                jtextarea.append(" \n O DIRETÓRIO CONTÉM: ");
                for (String nomeDiretorio : diretorio) {
                    jtextarea.append(nomeDiretorio + "\n");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, nome + " NÃO EXISTE ",
                    " ERRO ", JOptionPane.ERROR_MESSAGE);
        }

    }

    private File getArquivo() {
        //CRIA UM NOVO OBJETO DO TIPO J FILE CHOOSER
        JFileChooser jfilechooser = new JFileChooser();

        //EXIBE UMA CAIXA DE DIÁLOGO DE ARQUIVO PARA QUE O USUÁRIO ESCOLHA
        //O ARQUIVO QUE DESEJA ABRIR
        jfilechooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        int resultado = jfilechooser.showOpenDialog(this);

        //SE O USUÁRIO CLICAR NO BOTÃO CANCELAR A AÇÃO SERÁ SAIR 
        if (resultado == JFileChooser.CANCEL_OPTION) {
            System.exit(1);
        }

        //OBTÉM O ARQUIVO DESEJADO PELO USUÁRIO
        File nomeArquivo = jfilechooser.getSelectedFile();

        //EXIBE ERRO SE FOR INVÁLIDO
        if ((nomeArquivo == null) || (nomeArquivo.getName().equals(""))) {
            JOptionPane.showMessageDialog(this, "Nome de Arquivo Inválido",
                    "Nome de Arquivo Inválido", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        return nomeArquivo;
    }

}

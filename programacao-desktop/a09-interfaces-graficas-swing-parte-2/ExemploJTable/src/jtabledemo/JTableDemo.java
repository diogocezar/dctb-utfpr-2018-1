package jtabledemo;

import javax.swing.*;

public class JTableDemo {

  JTableDemo() {

    //CRIA UM NOVO CONTAINER
    JFrame jfrm = new JFrame("EXEMPLO DE JTable");

    //DEFINE UM TAMANHO INICIAL PARA O FRAME
    jfrm.setSize(400, 300);

    //FECHA A APLICAÇÃO QUANDO O USUÁRIO SAI
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //INICIALIZA OS CABEÇALHOS DAS COLUNAS
    String[] Headings = { "Name", "Student ID", "Midterm", "Final" };

    //INICIALIZA O ARRAY DATA
    String[][] data = {
      { "Tom", " 4-616", " 97", " 87" },
      { "Ken", " 3-786", " 88", " 95" },
      { "Rachel", " 4-674", " 92", " 83" },
      { "Sherry", " 3-235", " 91", " 99" },
      { "Adam", " 2-923", " 76", " 96" },
      { "Jon", " 3-561", " 84", " 80" },
      { "Stuart", " 1-337", " 62", " 74" },
      { "Mary", " 4-731", " 68", " 58" },
      { "Todd", " 2-924", " 82", " 72" },
      { "Shane", " 2-434", " 93", " 91" },
      { "Robert", " 3-769", " 99", " 92" },
    };

    //CRIA A TABELA
    JTable table = new JTable(data, Headings);

    //ADICIONA A TABELA AO PAINEL DE ROLAGEM
    JScrollPane jsp = new JScrollPane(table);

    //ADICIONA O PAINEL DE ROLAGEM AO CONTEÚDO DO PAINEL
    jfrm.add(jsp);

    //EXIBE O FRAME
    jfrm.setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new JTableDemo();
      }
    });
  }
}

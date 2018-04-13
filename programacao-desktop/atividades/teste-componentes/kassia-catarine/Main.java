import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main implements ItemListener {
  JLabel jlabChange;
  JLabel jlabSupported;
  JLabel jlabTitulo;

  JCheckBox cBChegando;
  JCheckBox cBSaindo;
  JCheckBox cbMac;

  Main() {
    JFrame jfrm = new JFrame("Teste de Componentes");

    jfrm.setLayout(new FlowLayout());
    jfrm.setSize(600, 1000);

    //Programa irá fechar quando sair
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    cBChegando = new JCheckBox("Chegando");
    cBChegando.addItemListener(this);
    jfrm.add(cBChegando);

    cBSaindo = new JCheckBox("Saindo");
    cBSaindo.addItemListener(this);
    jfrm.add(cBSaindo);

    jlabChange = new JLabel();
    jfrm.add(jlabChange);

    jlabSupported = new JLabel();
    jfrm.add(jlabSupported);

    JButton btn_ola = new JButton("Heyy");
    jfrm.add(btn_ola);

    JToggleButton btn_toggle = new JToggleButton("Clicavel ON/OFF");
    jfrm.add(btn_toggle);

    JRadioButton radioButton = new JRadioButton("Radio", true);
    jfrm.add(radioButton);


    String[] Headings = { "Name", "ID"};

    //INICIALIZA O ARRAY DATA
    String[][] data = {
      { "Tom", " 4-616" },
      { "Ken", " 3-786" },
      { "Rachel", " 4-674" },
      { "Sherry", " 3-235" },
      { "Adam", " 2-923" },
      { "Jon", " 3-561" },
      { "Stuart", " 1-337" },
      { "Mary", " 4-731" }
    };

    JTable table = new JTable(data, Headings);

    JScrollPane jsp = new JScrollPane(table);

    //scroll
    jfrm.add(jsp);

    jfrm.setVisible(true);
  }

  // Handle item events for the check boxes.
  public void itemStateChanged(ItemEvent ie) {
    JCheckBox cb = (JCheckBox)ie.getItem();

    if(cb.isSelected())
      jlabChange.setText(cb.getText());
    else
      jlabChange.setText(cb.getText());

    // Build a string the indicate all selections.
    String supported = "";
    if(cBChegando.isSelected()) supported = ": Ola, Bom dia";
    if(cBSaindo.isSelected()) supported = ": Tchau, Ate mais";

    jlabSupported.setText(supported);
  }

  public static void main(String[] args) {

    //CRIA a GUI na thread de despacho de evento
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new Main();
      }
    });
  }
}
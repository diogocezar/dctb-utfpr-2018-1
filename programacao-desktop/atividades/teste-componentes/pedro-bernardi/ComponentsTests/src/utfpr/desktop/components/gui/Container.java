package utfpr.desktop.components.gui;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Atividade testes de componentes
 *
 * @author Pedro Bernardi
 */

public class Container extends JFrame {

    public static final Dimension DIMENSIONS = new Dimension(1000, 700);
    private JPanel index = new JPanel();
    private JPanel content = new JPanel();
    private JPanel bottom = new JPanel();
    private JLabel titulo;
    private JProgressBar progressBar;

    public Container() throws HeadlessException {
        super();
        setMinimumSize(DIMENSIONS);
        setMaximumSize(DIMENSIONS);
        setPreferredSize(DIMENSIONS);
        revalidate();
        setLayout(new BorderLayout());
        init();
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setLayout(new BorderLayout());
        setBackground(new Color(0xDBE1DD));
        add(index, BorderLayout.NORTH);
        index.setLayout(new FlowLayout());
        add(content, BorderLayout.CENTER);
        content.setLayout(new FlowLayout());
        add(bottom, BorderLayout.SOUTH);
        createLabels();
        createButtons();
        createJTextField();
        createScroll();
        createJList();
        createJComboBox();
        createJTree();
        createJTable();
        createPassword();
        createJTextArea();
        createJFormattedTextField();
        createJProgessBar();
    }

    private void createLabels() {
        titulo = new JLabel("TESTES DE COMPONENTES");
        index.add(titulo);
        titulo.setFont(new Font(titulo.getName(), Font.PLAIN, 40));
        titulo.setBackground(new Color(0x19000B));
        ImageIcon goIcon = new ImageIcon(getClass().getClassLoader().getResource("utfpr\\desktop\\components\\res\\icons\\icons8-sort-down-24.png"));
        JLabel labelImage = new JLabel(goIcon, SwingConstants.LEFT);
        index.add(labelImage);
    }

    private void createButtons() {
        ImageIcon buttonMenu = new ImageIcon(getClass().getClassLoader().getResource("utfpr/desktop/components/res/icons/icons8-menu-25.png"));
        JButton menu = new JButton(buttonMenu);
        menu.setBorderPainted(false);
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.setBackground(new Color(0x4DDD1B));
            }
        });

        JToggleButton switchButton = new JToggleButton("On/Off");
        switchButton.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                if (switchButton.isSelected()) {
                    switchButton.setBackground(new Color(0xffffff));
                    switchButton.setForeground(new Color(0x000000));
                    switchButton.setText("ON");
                    createJFileChooser();
                } else {
                    switchButton.setBackground(new Color(0x000000));
                    switchButton.setForeground(new Color(0xffffff));
                    switchButton.setText("OFF");
                    progressBar.setValue(progressBar.getValue() + 10);
                }
            }
        });

        JLabel text = new JLabel();
        JCheckBox xfce = new JCheckBox("XFCE");
        xfce.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent arg1) {
                text.setText(((JCheckBox) arg1.getItem()).getText());
            }
        });
        JCheckBox deepin = new JCheckBox("DEEPIN");
        deepin.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent arg1) {
                text.setText(((JCheckBox) arg1.getItem()).getText());
            }
        });
        JCheckBox gnome = new JCheckBox("GNOME");
        gnome.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent arg1) {
                text.setText(((JCheckBox) arg1.getItem()).getText());
            }
        });
        JRadioButton one = new JRadioButton("ONE");
        JRadioButton two = new JRadioButton("TWO");
        ButtonGroup group = new ButtonGroup();
        group.add(one);
        group.add(two);
        one.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText("ONE");
            }
        });
        two.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText("TWO");
            }
        });
        content.add(one);
        content.add(two);
        content.add(text);
        content.add(xfce);
        content.add(deepin);
        content.add(gnome);
        content.add(menu);
        content.add(switchButton);
    }

    private void createJFileChooser() {
        JFrame file = new JFrame();
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Choose a directory to save your file: ");
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int returnValue = jfc.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            if (jfc.getSelectedFile().isDirectory()) {
                System.out.println("You selected the directory: " + jfc.getSelectedFile());
            }
        }
        file.add(jfc);
    }

    private void createJTable() {
        String[] header = {"First Name",
                "Last Name",
                "Sport",
                "# of Years"};
        String[][] data = {
                {"Tom", " Smith", "Pool", " 5"},
                {"Ken", " Doe", " Rowing", " 15"},
                {"Rachel", " White", "Soccer", " 10"},
        };
        JTable table = new JTable(data, header);
        content.add(table);
    }

    private void createJTree() {
        DefaultMutableTreeNode root
                = new DefaultMutableTreeNode("Ordem");
        DefaultMutableTreeNode types = new DefaultMutableTreeNode("tipos");
        root.add(types);

        DefaultMutableTreeNode fpTypes
                = new DefaultMutableTreeNode("Alb");
        types.add(fpTypes);
        fpTypes.add(new DefaultMutableTreeNode("A"));
        fpTypes.add(new DefaultMutableTreeNode("B"));

        DefaultMutableTreeNode intTypes
                = new DefaultMutableTreeNode("Num");
        types.add(intTypes);
        intTypes.add(new DefaultMutableTreeNode("1"));
        intTypes.add(new DefaultMutableTreeNode("2"));
        intTypes.add(new DefaultMutableTreeNode("3"));
        intTypes.add(new DefaultMutableTreeNode("4"));

        types.add(new DefaultMutableTreeNode("Rom"));
        types.add(new DefaultMutableTreeNode("Sem"));

        JTree tree = new JTree(root);

        tree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent tse) {
                titulo.setText("a seleção é: "
                        + tse.getPath().getLastPathComponent());
            }
        });

        bottom.add(tree);
    }

    private void createJComboBox() {
        String[] type = {"A", "B", "C"};
        JComboBox comboBox = new JComboBox<String>(type);
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String item = (String) comboBox.getSelectedItem();
                titulo.setText(titulo.getText() + item);
            }
        });
        bottom.add(comboBox);
    }

    private void createJList() {
        String[] type = {"A", "B", "C"};
        JList list = new JList<String>(type);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent le) {
                int idx = list.getSelectedIndex();
                if (idx != -1)
                    titulo.setText(titulo.getText() + type[idx]);
            }
        });
        bottom.add(list);
    }

    private void createScroll() {
        JFrame frame = new JFrame();
        frame.setSize(300, 100);
        JLabel text =
                new JLabel("<html>Lorem ipsum dolor sit amet, consectetur adipiscing elit. <br>" +
                        "Sed euismod augue a purus convallis, vitae convallis quam lobortis.<br>" +
                        " Mauris sem nunc, consectetur sed dui nec, pretium eleifend ligula.  <br>" +
                        "Sed facilisis massa nec dolor scelerisque laoreet. <br>" +
                        "Quisque volutpat ut nibh placerat pretium. <br>" +
                        "Sed laoreet purus non consectetur varius. " +
                        "Sed euismod augue a purus convallis, vitae convallis quam lobortis.<br>" +
                        " Mauris sem nunc, consectetur sed dui nec, pretium eleifend ligula.  <br>" +
                        "Sed facilisis massa nec dolor scelerisque laoreet. <br>" +
                        "Quisque volutpat ut nibh placerat pretium. <br>" +
                        "Sed laoreet purus non consectetur varius. ");
        JScrollPane scroll = new JScrollPane(text);
        frame.add(scroll);
        frame.setVisible(true);
    }

    private void createPassword() {
        JLabel password = new JLabel("Password: ");
        JPasswordField passwordField = new JPasswordField(10);
        passwordField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String input = String.valueOf(passwordField.getPassword());
                String correctPassword = "laoreet";
                if (input.equals(correctPassword))
                    JOptionPane.showMessageDialog(null,
                            "Success! You typed the right password.");
            }
        });
        content.add(password);
        content.add(passwordField);
    }

    private void createJProgessBar() {
        progressBar = new JProgressBar(0);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        content.add(progressBar);
    }

    private void createJFormattedTextField() {
        int value = 5;
        JFormattedTextField rate = new JFormattedTextField();
        rate.setValue(value);
        rate.setColumns(10);
        content.add(rate);
    }

    private void createJTextArea() {
        JTextArea textArea = new JTextArea(
                "Sed euismod augue a purus convallis, vitae convallis quam lobortis.<br>" +
                        " Mauris sem nunc, consectetur sed dui nec, pretium eleifend ligula.  <br>" +
                        "Sed facilisis massa nec dolor scelerisque laoreet. <br>" +
                        "Quisque volutpat ut nibh placerat pretium. <br>" +
                        "Sed laoreet purus non consectetur varius. "
        );
        textArea.setFont(new Font("Serif", Font.ITALIC, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        content.add(textArea);
    }

    private void createJTextField() {
        JTextField textField = new JTextField("Digite um novo titulo", 15);
        content.add(textField);
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                titulo.setText(textField.getText());
            }
        });

    }
}

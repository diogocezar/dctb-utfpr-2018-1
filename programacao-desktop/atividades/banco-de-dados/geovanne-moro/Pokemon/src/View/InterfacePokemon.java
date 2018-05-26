/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.PokemonControl;
import Model.Pokemon;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author geovannemoro
 */

public class InterfacePokemon extends JFrame{
    
    private final Dimension dF = new Dimension(1000, 700);
    private final Dimension dJTxt = new Dimension(800, 30);
    private final Dimension dButtons = new Dimension(100, 40);
  
    private JPanel panel1;
    private JPanel panel2;
    private JTable table;
    private DefaultTableModel modelo = new DefaultTableModel();
    private JTextField nome;
    private JButton inserir;
    private JButton remover;
    private JButton consultar;
    private JButton limpar;
    private JButton sair;
    
    public InterfacePokemon(){
        initComponents();
    }
    
    private void initComponents(){
        this.setSize(dF);
        this.setResizable(false);
        this.setTitle("Pokedex");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2,0));
        this.setLocationRelativeTo(null);
        
        panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        
        JLabel lb = new JLabel("Nome do pokemon");
        nome = new JTextField();
        nome.setPreferredSize(dJTxt);
        inserir = new JButton("Inserir");
        inserir.setPreferredSize(dButtons);
        remover = new JButton("Remover");
        remover.setPreferredSize(dButtons);
        consultar = new JButton("Consultar");
        consultar.setPreferredSize(dButtons);
        limpar = new JButton("Limpar");
        limpar.setPreferredSize(dButtons);
        sair = new JButton("Sair");
        sair.setPreferredSize(dButtons);
        
        panel1.add(lb);
        panel1.add(nome);
        panel1.add(inserir);
        panel1.add(remover);
        panel1.add(consultar);
        panel1.add(limpar);
        panel1.add(sair);

        table = new JTable(modelo);
        modelo.setColumnIdentifiers(new String[]{"Id", "Nome", "Nivel", "Vida", "Agilidade", "Ataque", "Defesa", "AtaqueEspecial", "DefesaEspecial"});
        JScrollPane scrollpane = new JScrollPane(table);
        panel2.add(scrollpane);
        
        
        inserir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                inserirActionPerformed(e);
            }
        });
        remover.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                removerActionPerformed(e);
            }
        });
        consultar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                consultarActionPerformed(e);
            }
        });
        limpar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                limparActionPerformed(e);
            }
        });
          sair.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                sairActionPerformed(e);
            }
        });
        this.add(panel1);
        this.add(panel2);
        this.setVisible(true);
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public JTable getTable() {
        return table;
    }
    
    public void inserirActionPerformed(ActionEvent e){
        Pokemon poke = new Pokemon();
        PokemonControl c = new PokemonControl(this);
        String id = JOptionPane.showInputDialog("Insira o Id do Pokemon!");
        poke.setId(Integer.parseInt(id));
        poke.setName(this.nome.getText());
        String level = JOptionPane.showInputDialog("Insira o level do Pokemon!");
        poke.setLevel(Integer.parseInt(level));
        String hp = JOptionPane.showInputDialog("Insira o HP do Pokemon!");
        poke.setHp(Integer.parseInt(hp));
        String agility = JOptionPane.showInputDialog("Insira a Agilidade do Pokemon!");
        poke.setAgility(Integer.parseInt(agility));
        String attack = JOptionPane.showInputDialog("Insira o Ataque do Pokemon!");
        poke.setAttack(Integer.parseInt(attack));
        String defense = JOptionPane.showInputDialog("Insira a Defesa do Pokemon!");
        poke.setDefense(Integer.parseInt(defense));
        String sattack = JOptionPane.showInputDialog("Insira o valor de Ataque Especial do Pokemon!");
        poke.setSpecialAttack(Integer.parseInt(sattack));
        String sdefense = JOptionPane.showInputDialog("Insira o valor de Defesa Especial do Pokemon!");
        poke.setSpecialDefense(Integer.parseInt(sdefense));
        this.nome.setText("");
        c.insert(poke);
    }
    
    public void removerActionPerformed(ActionEvent e){
        PokemonControl c = new PokemonControl(this);
        Pokemon poke = new Pokemon();
        String id = JOptionPane.showInputDialog("Insira o Id do Pokemon a ser Removido!");
        poke.setId(Integer.parseInt(id));
        c.remove(poke.getId());
    }
    
    public void consultarActionPerformed(ActionEvent e){
        this.consultar.setEnabled(false);
        PokemonControl c = new PokemonControl(this);
        c.getData();
    }
    
    public void limparActionPerformed(ActionEvent e){
        this.consultar.setEnabled(true);
        PokemonControl c = new PokemonControl(this);
        c.resetTable();
    }
    public void sairActionPerformed(ActionEvent e){
            System.exit(0);
        }
}

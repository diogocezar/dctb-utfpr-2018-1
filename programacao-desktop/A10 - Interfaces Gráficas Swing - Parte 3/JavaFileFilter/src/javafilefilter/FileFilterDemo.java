
package javafilefilter;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

// A custom file filter that displays
// Java source files and directories.
class JavaFileFilter extends FileFilter {
  public boolean accept(File file) {
    // Return true if the file is a Java source file
    // or if it is a directory.
    if(file.getName().endsWith(".java")) return true;
    if(file.isDirectory()) return true;

    // Otherwise, return false.
    return false;
  }

  public String getDescription() {
    return "Selecionador de Arquivos Java";
  }
}

public class FileFilterDemo {

  JLabel jlab;
  JButton jbtnShow;
  JFileChooser jfc;

  FileFilterDemo() {
    // Create a new JFrame container.
    JFrame jfrm = new JFrame("Filtro de Arquivo");

    // Specify FlowLayout for the layout manager.
    jfrm.setLayout(new FlowLayout());

    // Give the frame an initial size.
    jfrm.setSize(400, 200);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create a label that will show the selected file.
    jlab = new JLabel();

    // Create a button that will show the dialog.
    jbtnShow = new JButton("Selecionador de Arquivo");

    // Create the file chooser.
    jfc = new JFileChooser();

    // Set the file filter.
    jfc.setFileFilter(new JavaFileFilter());

    // Show the file chooser when the Show File Chooser button
    // is pressed.
    jbtnShow.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent le) {
        // Pass null for the parent. This typically centers
        // the dialog on the screen.
        int result = jfc.showOpenDialog(null);

        if(result == JFileChooser.APPROVE_OPTION)
          jlab.setText("O arquivo selecionado é: " +
                       jfc.getSelectedFile().getName());
        else
          jlab.setText("Nenhum arquivo selecionado.");
      }
    });

    // Add the Show File Chooser button and label to the
    // content pane.
    jfrm.add(jbtnShow);
    jfrm.add(jlab);

    // Display the frame.
    jfrm.setVisible(true);
  }

  public static void main(String[] args) {
    // Create the GUI on the event dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new FileFilterDemo();
      }
    });
  }
}

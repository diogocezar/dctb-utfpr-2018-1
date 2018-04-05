
package filechooserdemo;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class FileChooserDemo {

  JLabel jlab;
  JButton jbtnShow;
  JFileChooser jfc;

  FileChooserDemo() {
    // Create a new JFrame container.
    JFrame jfrm = new JFrame("JFileChooser Demo");

    // Specify FlowLayout for the layout manager.
    jfrm.setLayout(new FlowLayout());

    // Give the frame an initial size.
    jfrm.setSize(400, 200);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create a label that will show the selected file.
    jlab = new JLabel();

    // Create button that will show the dialog.
    jbtnShow = new JButton("Show File Chooser");

    // Create the file chooser.
    jfc = new JFileChooser();

    // Show the file chooser when the Show File Chooser button
    // is pressed.
    jbtnShow.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent le) {
        // Pass null for the parent. This centers the dialog
        // on the screen.
        int result = jfc.showOpenDialog(null);

        if(result == JFileChooser.APPROVE_OPTION)
          jlab.setText("Selected file is: " +
                       jfc.getSelectedFile().getName());
        else
          jlab.setText("No file selected.");
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
        new FileChooserDemo();
      }
    });
  }
}


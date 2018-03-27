import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class cronometro implements ActionListener {

  JLabel jlab;
  long start; // holds the start time in milliseconds

  cronometro() {

    // Create a new JFrame container.
    JFrame jfrm = new JFrame("A Simple Stopwatch");

    // Specify FlowLayout for the layout manager.
    jfrm.setLayout(new FlowLayout());

    // Give the frame an initial size.
    jfrm.setSize(300, 300);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Make two buttons.
    JButton jbtnStart = new JButton("Start");
    JButton jbtnStop = new JButton("Stop");

    // Add action listeners.
    jbtnStart.addActionListener(this);
    jbtnStop.addActionListener(this);

    // Add the buttons to the content pane.
    jfrm.add(jbtnStart);
    jfrm.add(jbtnStop);

    // Create a text-based label.
    jlab = new JLabel("Press Start to begin timing.");

    // Add the label to the frame.
    jfrm.add(jlab);

    // Display the frame.
    jfrm.setVisible(true);
  }

  // Handle button events.
  public void actionPerformed(ActionEvent ae) {
    // get the current system time
    Calendar cal = Calendar.getInstance();

    if(ae.getActionCommand().equals("Start")) {
      // Store start time.
      start = cal.getTimeInMillis();
      jlab.setText("Stopwatch is Running...");
    }
    else
      // Compute the elapsed time.
      jlab.setText("Elapsed time is "
           + (double) (cal.getTimeInMillis() - start)/1000);
  }

  public static void main(String[] args) {

    // Create the frame on the event dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new cronometro();
      }
    });
  }
}
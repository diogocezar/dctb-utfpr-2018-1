import java.awt.GridLayout;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Sliders {

	public static void main(String[] args) {
		// Create and set up a frame window
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("Slider with change listener");
		frame.setSize(500, 500);
		frame.setLayout(new GridLayout(3, 1));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Set the panel to add buttons
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
		// Add status label to show the status of the slider
		JLabel status = new JLabel("Slide the slider and you can get its value", JLabel.CENTER);
		
		// Set the slider
		JSlider slider = new JSlider();	
		slider.setMinorTickSpacing(10);
		slider.setPaintTicks(true);
		
		// Set the labels to be painted on the slider
		slider.setPaintLabels(true);
		
		// Add positions label in the slider
		Hashtable<Integer, JLabel> position = new Hashtable<Integer, JLabel>();
		position.put(0, new JLabel("0"));
		position.put(50, new JLabel("50"));
		position.put(100, new JLabel("100"));
		
		// Set the label to be drawn
		slider.setLabelTable(position);
		
		// Add change listener to the slider
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				status.setText("Value of the slider is: " + ((JSlider)e.getSource()).getValue());
			}
		});
		
		// Add the slider to the panel
		panel1.add(slider);
		
		// Set the window to be visible as the default to be false
		frame.add(panel1);
		frame.add(status);
		frame.add(panel2);
		frame.pack();
		frame.setVisible(true);

	}

}
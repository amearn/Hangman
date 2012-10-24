package advance.gui.basic;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioButtonDemo extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	static String blueString = "Blue";
	static String redString = "Red";
	static String greenString = "Green";
	static String yellowString = "Yellow";

	public RadioButtonDemo() {
		super(new BorderLayout());

		// Create the radio buttons.
		JRadioButton blueButton = new JRadioButton(blueString);
		JRadioButton redButton = new JRadioButton(redString);
		JRadioButton greenButton = new JRadioButton(greenString);
		JRadioButton yellowButton = new JRadioButton(yellowString);

		// Group the radio buttons.
		ButtonGroup group = new ButtonGroup();
		group.add(blueButton);
		group.add(redButton);
		group.add(greenButton);
		group.add(yellowButton);

		// Put the radio buttons in a column in a panel.
		JPanel radioPanel = new JPanel(new GridLayout(0, 1));
		radioPanel.add(blueButton);
		radioPanel.add(redButton);
		radioPanel.add(greenButton);
		radioPanel.add(yellowButton);

		add(radioPanel, BorderLayout.LINE_START);
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

	}

	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("RadioButtonDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		RadioButtonDemo newContentPane = new RadioButtonDemo();
		newContentPane.setOpaque(true); // content panes must be opaque
		frame.setContentPane(newContentPane);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}

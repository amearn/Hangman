package advance.gui.basic;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CheckBoxDemo extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	JCheckBox redButton;
	JCheckBox blueButton;
	JCheckBox yellowButton;
	JCheckBox greenButton;

	public CheckBoxDemo() {
		super(new BorderLayout());

		// Create the check boxes.
		redButton = new JCheckBox("Red");

		blueButton = new JCheckBox("Blue");

		yellowButton = new JCheckBox("Yellow");

		greenButton = new JCheckBox("Green");

		// Put the check boxes in a column in a panel
		JPanel checkPanel = new JPanel(new GridLayout(0, 1));
		checkPanel.add(redButton);
		checkPanel.add(blueButton);
		checkPanel.add(yellowButton);
		checkPanel.add(greenButton);

		add(checkPanel, BorderLayout.LINE_START);
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	}

	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("CheckBoxDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		CheckBoxDemo newContentPane = new CheckBoxDemo();
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

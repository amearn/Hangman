package advance.gui.basic;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UnEditableComboBoxDemo extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public UnEditableComboBoxDemo() {
		super(new BorderLayout());

		String[] colorStrings = { "Red", "Blue", "Green", "Yellow", "Pink" };

		// Create the combo box, select the item at index 4.
		// Indices start at 0, so 4 specifies the pig.
		JComboBox colorList = new JComboBox(colorStrings);
		colorList.setSelectedIndex(4);

		// Lay out the demo.
		add(colorList, BorderLayout.PAGE_START);
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	}

	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("UnEditableComboBoxDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		UnEditableComboBoxDemo newContentPane = new UnEditableComboBoxDemo();
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

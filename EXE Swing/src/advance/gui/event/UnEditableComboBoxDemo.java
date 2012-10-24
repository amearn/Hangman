package advance.gui.event;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UnEditableComboBoxDemo extends JPanel implements ActionListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JLabel picture;
	static String blueString = "Blue";
	static String redString = "Red";
	static String greenString = "Green";
	static String yellowString = "Yellow";
	static String pinkString = "Pink";

	public UnEditableComboBoxDemo() {
		super(new BorderLayout());

		String[] colorStrings = { blueString, redString, greenString,
				yellowString, pinkString };

		// Create the combo box, select the item at index 4.
		// Indices start at 0, so 4 specifies the pig.
		JComboBox colorList = new JComboBox(colorStrings);
		colorList.setSelectedIndex(4);
		colorList.addActionListener(this);

		// Set up the picture.
		picture = new JLabel("Selected Color");
		picture.setFont(picture.getFont().deriveFont(Font.ITALIC));
		picture.setHorizontalAlignment(JLabel.CENTER);
		picture.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

		// Lay out the demo.
		add(colorList, BorderLayout.PAGE_START);
		add(picture, BorderLayout.PAGE_END);
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JComboBox cb = (JComboBox) e.getSource();
		String colorName = (String) cb.getSelectedItem();
		if (colorName.equals(redString)) {
			picture.setForeground(new Color(200, 0, 0));
		} else if (colorName.equals(blueString)) {
			picture.setForeground(new Color(0, 0, 200));
		} else if (colorName.equals(greenString)) {
			picture.setForeground(new Color(0, 200, 0));
		} else if (colorName.equals(yellowString)) {
			picture.setForeground(new Color(150, 150, 0));
		} else if (colorName.equals(pinkString)) {
			picture.setForeground(new Color(200, 0, 100));
		}
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

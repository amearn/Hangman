package advance.gui.basic;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextComponentDemo extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	protected static final String textFieldString = "JTextField";
	protected static final String passwordFieldString = "JPasswordField";
	protected static final String ftfString = "JFormattedTextField";
	protected static final String buttonString = "JButton";

	public TextComponentDemo() {
		setLayout(new BorderLayout());

		// Create a regular text field.
		JTextField textField = new JTextField(10);

		// Create a password field.
		JPasswordField passwordField = new JPasswordField(10);

		// Create a formatted text field.
		JFormattedTextField ftf = new JFormattedTextField(java.util.Calendar
				.getInstance().getTime());
		ftf.setActionCommand(textFieldString);

		// Create some labels for the fields.
		JLabel textFieldLabel = new JLabel(textFieldString + ": ");
		textFieldLabel.setLabelFor(textField);
		JLabel passwordFieldLabel = new JLabel(passwordFieldString + ": ");
		passwordFieldLabel.setLabelFor(passwordField);
		JLabel ftfLabel = new JLabel(ftfString + ": ");
		ftfLabel.setLabelFor(ftf);

		// Lay out the text controls and the labels.
		JPanel textControlsPane = new JPanel();
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();

		textControlsPane.setLayout(gridbag);

		c.anchor = GridBagConstraints.EAST;
		c.gridwidth = GridBagConstraints.RELATIVE; // next-to-last
		c.fill = GridBagConstraints.NONE; // reset to default
		c.weightx = 0.0; // reset to default
		textControlsPane.add(textFieldLabel, c);
		c.gridwidth = GridBagConstraints.REMAINDER; // end row
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		textControlsPane.add(textField, c);

		c.gridwidth = GridBagConstraints.RELATIVE; // next-to-last
		c.fill = GridBagConstraints.NONE; // reset to default
		c.weightx = 0.0; // reset to default
		textControlsPane.add(passwordFieldLabel, c);
		c.gridwidth = GridBagConstraints.REMAINDER; // end row
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		textControlsPane.add(passwordField, c);

		c.gridwidth = GridBagConstraints.RELATIVE; // next-to-last
		c.fill = GridBagConstraints.NONE; // reset to default
		c.weightx = 0.0; // reset to default
		textControlsPane.add(ftfLabel, c);
		c.gridwidth = GridBagConstraints.REMAINDER; // end row
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		textControlsPane.add(ftf, c);

		textControlsPane.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Text Fields"), BorderFactory
						.createEmptyBorder(5, 5, 5, 5)));

		// Create a text area.
		JTextArea textArea = new JTextArea("This is an editable JTextArea. "
				+ "A text area is a \"plain\" text component, "
				+ "which means that although it can display text "
				+ "in any font, all of the text is in the same font.");
		textArea.setFont(new Font("Serif", Font.ITALIC, 16));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);

		JScrollPane areaScrollPane = new JScrollPane(textArea);
		areaScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setPreferredSize(new Dimension(250, 250));
		areaScrollPane.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createCompoundBorder(BorderFactory
						.createTitledBorder("Plain Text"), BorderFactory
						.createEmptyBorder(5, 5, 5, 5)), areaScrollPane
						.getBorder()));

		// Put everything together.
		JPanel leftPane = new JPanel(new BorderLayout());
		leftPane.add(textControlsPane, BorderLayout.PAGE_START);
		leftPane.add(areaScrollPane, BorderLayout.CENTER);

		add(leftPane, BorderLayout.LINE_START);
	}

	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("TextComponentDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Add content to the window.
		frame.add(new TextComponentDemo());

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

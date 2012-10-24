package advance.gui.event;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CheckBoxDemo extends JPanel implements ItemListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	JCheckBox redButton;
	JCheckBox blueButton;
	JCheckBox yellowButton;
	JCheckBox greenButton;

	JLabel pictureLabel;
	String buffer[] = { "", "", "", "" };

	public CheckBoxDemo() {
		super(new BorderLayout());

		this.setPreferredSize(new Dimension(400, 200));
		// Create the check boxes.
		redButton = new JCheckBox("Red");
		redButton.setMnemonic(KeyEvent.VK_C);
		redButton.setSelected(false);

		blueButton = new JCheckBox("Blue");
		blueButton.setMnemonic(KeyEvent.VK_G);
		blueButton.setSelected(false);

		yellowButton = new JCheckBox("Yellow");
		yellowButton.setMnemonic(KeyEvent.VK_H);
		yellowButton.setSelected(false);

		greenButton = new JCheckBox("Green");
		greenButton.setMnemonic(KeyEvent.VK_T);
		greenButton.setSelected(false);

		// Register a listener for the check boxes.
		redButton.addItemListener(this);
		blueButton.addItemListener(this);
		yellowButton.addItemListener(this);
		greenButton.addItemListener(this);

		// Set up the picture label
		pictureLabel = new JLabel();
		pictureLabel.setFont(pictureLabel.getFont().deriveFont(Font.ITALIC));

		// Put the check boxes in a column in a panel
		JPanel checkPanel = new JPanel(new GridLayout(0, 1));
		checkPanel.add(redButton);
		checkPanel.add(blueButton);
		checkPanel.add(yellowButton);
		checkPanel.add(greenButton);

		add(checkPanel, BorderLayout.LINE_START);
		add(pictureLabel, BorderLayout.EAST);
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	}

	/** Listens to the check boxes. */
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

		Object source = e.getItemSelectable();
		if (e.getStateChange() == ItemEvent.SELECTED) {
			if (source == redButton) {
				buffer[0] = "Red";
			} else if (source == blueButton) {
				buffer[1] = "Blue";
			} else if (source == greenButton) {
				buffer[2] = "Green";
			} else if (source == yellowButton) {
				buffer[3] = "Yellow";
			}
		}

		if (e.getStateChange() == ItemEvent.DESELECTED) {
			if (source == redButton) {
				buffer[0] = "";
			} else if (source == blueButton) {
				buffer[1] = "";
			} else if (source == greenButton) {
				buffer[2] = "";
			} else if (source == yellowButton) {
				buffer[3] = "";
			}
		}

		pictureLabel.setText(buffer[0] + buffer[1] + buffer[2] + buffer[3]);
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

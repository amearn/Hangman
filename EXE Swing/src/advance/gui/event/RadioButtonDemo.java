package advance.gui.event;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioButtonDemo extends JPanel implements ActionListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	static String blueString = "Blue";
	static String redString = "Red";
	static String greenString = "Green";
	static String yellowString = "Yellow";
	JLabel pictureLabel;

	public RadioButtonDemo() {
		super(new BorderLayout());
		this.setPreferredSize(new Dimension(400, 200));

		// Create the radio buttons.
		JRadioButton blueButton = new JRadioButton(blueString);
		blueButton.setMnemonic(KeyEvent.VK_B);
		blueButton.setActionCommand(blueString);
		blueButton.setSelected(true);

		JRadioButton redButton = new JRadioButton(redString);
		redButton.setMnemonic(KeyEvent.VK_C);
		redButton.setActionCommand(redString);

		JRadioButton greenButton = new JRadioButton(greenString);
		greenButton.setMnemonic(KeyEvent.VK_D);
		greenButton.setActionCommand(greenString);

		JRadioButton yellowButton = new JRadioButton(yellowString);
		yellowButton.setMnemonic(KeyEvent.VK_R);
		yellowButton.setActionCommand(yellowString);

		// Group the radio buttons.
		ButtonGroup group = new ButtonGroup();
		group.add(blueButton);
		group.add(redButton);
		group.add(greenButton);
		group.add(yellowButton);

		// Register a listener for the radio buttons.
		blueButton.addActionListener(this);
		redButton.addActionListener(this);
		greenButton.addActionListener(this);
		yellowButton.addActionListener(this);

		// Put the radio buttons in a column in a panel.
		JPanel radioPanel = new JPanel(new GridLayout(0, 1));
		radioPanel.add(blueButton);
		radioPanel.add(redButton);
		radioPanel.add(greenButton);
		radioPanel.add(yellowButton);

		// Set up the picture label
		pictureLabel = new JLabel("Selected Color");
		add(pictureLabel, BorderLayout.EAST);
		pictureLabel.setFont(pictureLabel.getFont().deriveFont(Font.ITALIC));

		add(radioPanel, BorderLayout.LINE_START);
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getActionCommand().equals(blueString)) {
			 pictureLabel.setForeground(new Color(0,0,200));
		}else if (e.getActionCommand().equals(redString)) {
			 pictureLabel.setForeground(new Color(200,0,0));
		}else if (e.getActionCommand().equals(greenString)) {
			 pictureLabel.setForeground(new Color(0,200,0));
		}else if (e.getActionCommand().equals(yellowString)) {
			 pictureLabel.setForeground(new Color(150,150,0));
		}
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

package advance.gui.basic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JTextField;

public class TopLevelDemo {

	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("TopLevelDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create the menu bar. Make it have a green background.
		JMenuBar mMenuBar = new JMenuBar();
		mMenuBar.setOpaque(true);
		mMenuBar.setBackground(new Color(174, 0, 157));
		mMenuBar.setPreferredSize(new Dimension(200, 20));

		// Create a label to put in the content pane.
		JLabel lLabel = new JLabel("Label");
		lLabel.setOpaque(true);
		lLabel.setBackground(new Color(48, 183, 191));
		lLabel.setPreferredSize(new Dimension(100, 80));

		JTextField tTextfield = new JTextField("TextField");
		tTextfield.setOpaque(true);
		tTextfield.setBackground(new Color(108, 213, 81));
		tTextfield.setPreferredSize(new Dimension(200, 100));

		// Set the menu bar and add the label to the content pane.
		//frame.setJMenuBar(mMenuBar);
	 	 frame.getContentPane().add(lLabel, BorderLayout.CENTER);
	 	//frame.add(lLabel, BorderLayout.CENTER);
		//frame.getContentPane().add(tTextfield, BorderLayout.CENTER);


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

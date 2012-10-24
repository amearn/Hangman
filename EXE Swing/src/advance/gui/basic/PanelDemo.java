package advance.gui.basic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelDemo {
	private static void createAndShowGUI() {

		JFrame frame = new JFrame("PanelDemo");
		JPanel pPanel = new JPanel();
		pPanel.setSize(400,350);

		// Create a label to put in the content pane.
		JLabel lLabel = new JLabel("Label");
		lLabel.setOpaque(true);
		lLabel.setBackground(new Color(48, 183, 191));
		lLabel.setPreferredSize(new Dimension(100, 80));
		pPanel.add(lLabel);


		frame.getContentPane().add(pPanel, BorderLayout.CENTER);
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

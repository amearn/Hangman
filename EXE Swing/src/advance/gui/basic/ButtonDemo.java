package advance.gui.basic;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonDemo extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	protected JButton b1, b2, b3;

	public ButtonDemo() {
		ImageIcon leftButtonIcon = createImageIcon("/images/right.gif");
		ImageIcon rightButtonIcon = createImageIcon("/images/left.gif");

		b1 = new JButton("Disable middle button", leftButtonIcon);
		b1.setVerticalTextPosition(AbstractButton.CENTER);
		b1.setHorizontalTextPosition(AbstractButton.LEADING); // aka LEFT, for
																// left-to-right
																// locales

		b2 = new JButton("Middle button");
		b2.setVerticalTextPosition(AbstractButton.BOTTOM);
		b2.setHorizontalTextPosition(AbstractButton.CENTER);

		b3 = new JButton("Enable middle button", rightButtonIcon);
		// Use the default text position of CENTER, TRAILING (RIGHT).

		b1.setToolTipText("Click this button to disable the middle button.");
		b2.setToolTipText("This middle button does nothing when you click it.");
		b3.setToolTipText("Click this button to enable the middle button.");

		// Add Components to this container, using the default FlowLayout.
		add(b1);
		add(b2);
		add(b3);
	}

	/** Returns an ImageIcon, or null if the path was invalid. */
	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = ButtonDemo.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	private static void createAndShowGUI() {
		 //Create and set up the window.
        JFrame frame = new JFrame("ButtonDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        ButtonDemo newContentPane = new ButtonDemo();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
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

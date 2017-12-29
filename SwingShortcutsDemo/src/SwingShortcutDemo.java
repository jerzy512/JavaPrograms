
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class SwingShortcutDemo extends JFrame {
	private JButton button = new JButton();
	
	public SwingShortcutDemo() throws HeadlessException {
		super("Swing Shortcuts Demo");
		
		makeButton();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640, 480);
		setLocationRelativeTo(null);
		
	}
	

	private void makeButton() {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		add(button);
		
		Action buttonAction = new AbstractAction("Refresh") {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				System.out.println("Refreshing...");
			}
		};
		
		String key = "Refresh";

		button.setAction(buttonAction);
		
		buttonAction.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_R);
		
		button.getInputMap(JComponent.WHEN_FOCUSED).put(
				KeyStroke.getKeyStroke(KeyEvent.VK_B, 0), key);
		
		button.getActionMap().put(key, buttonAction);
		
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new SwingShortcutDemo().setVisible(true);
			}
		});
	}

}

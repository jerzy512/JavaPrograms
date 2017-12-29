package program;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	private TextPanel textPanel;
	private Toolbar toolbar;
	
	public MainFrame() {
		super("Practice Chinese Characters");
		
		setLayout(new BorderLayout());
		
		toolbar = new Toolbar();
		textPanel = new TextPanel();
		
		toolbar.setButtonListener(new ButtonListener() {
			public void buttonAction(int number) {
				if (number == 1) {
					textPanel.appendText("Action 1.\n");
				}
				else if (number == 2) {
					textPanel.appendText("2222222.\n");
				}
			}
		});
		
		add(toolbar, BorderLayout.NORTH);
		add(textPanel, BorderLayout.CENTER);
		
		setSize(1000, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

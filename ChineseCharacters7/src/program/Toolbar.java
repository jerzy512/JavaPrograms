package program;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel {
	
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	
	public Toolbar() {
		button1 = new JButton("Action 1");
		button2 = new JButton("Action 2");
		button3 = new JButton("Action 3");
		button4 = new JButton("Action 4");
		button5 = new JButton("Action 5");
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
	}
}

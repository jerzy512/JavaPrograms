package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class TheToolBar extends JToolBar{
	
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton otherButton;
	private JButton learnButton;
	
	private ToolBarListener listener;
	
	//////////////////////////// Constructor ///////////////////////////////
	
	public TheToolBar() {
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();
		button5 = new JButton();
		otherButton = new JButton();
		learnButton = new JButton();
		
		button1.setIcon(new ImageIcon("src/icons/App-Connect-To-icon.png"));
		button2.setIcon(new ImageIcon("src/icons/App-Office-Spreadsheet-icon.png"));
		button3.setIcon(new ImageIcon("src/icons/App-Office-Word-Proccesser-icon.png"));
		button4.setIcon(new ImageIcon("src/icons/DVD-Box-icon.png"));
		button5.setIcon(new ImageIcon("src/icons/App-appfinder-icon.png"));
		otherButton.setIcon(new ImageIcon("src/icons/software-firefox-icon.png"));
		learnButton.setIcon(new ImageIcon("src/icons/Arrow-Right-icon.png"));
		
		add(button1);
		add(button2);
		addSeparator();
		add(button3);
		add(button4);
		add(button5);
		add(otherButton);
		otherButton.setToolTipText("Something else");
		addSeparator();
		addSeparator();
		add(learnButton);
		learnButton.setToolTipText("Start learning");
		
		otherButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (listener != null) {
					listener.buttonClicked(ButtonEnum.OTHER);
				}
			}
		});
		
		learnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (listener != null) {
					listener.buttonClicked(ButtonEnum.LEARN);
				}
			}
		});
	}
	
	public void setToolBarListener(ToolBarListener listener) {
		this.listener = listener;
	}
}

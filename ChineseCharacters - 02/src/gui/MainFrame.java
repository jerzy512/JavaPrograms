package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	
	private TheMenuBar menuBar;
	private TheToolBar toolBar;
	private LearnWindow learnWindow;
	
	///////////////////// Constructor ///////////////////////////////////
	
	public MainFrame() {
		
		super("Learn Chinese Characters");
		
		menuBar = new TheMenuBar();
		toolBar = new TheToolBar();
		learnWindow = new LearnWindow(this);
		
		setLayout(new BorderLayout());
		
		setJMenuBar(menuBar);
		add(toolBar, BorderLayout.PAGE_START);
		
		toolBar.setToolBarListener(new ToolBarListener() {
			public void buttonClicked(ButtonEnum button) {
				if (button == ButtonEnum.LEARN) {
					learnWindow.setVisible(true);
				} else if (button == ButtonEnum.OTHER) {
					System.out.println("Doing nothing now.");
				}
			}
		});
		
		setSize(1500,800);
		setLocation(200, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

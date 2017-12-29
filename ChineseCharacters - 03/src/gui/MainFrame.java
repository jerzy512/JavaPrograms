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
					setLearnWindow();
					learnWindow.setVisible(true);
				} else if (button == ButtonEnum.OTHER) {
					System.out.println("Doing nothing now.");
				}
			}
		});
		
		learnWindow.setLearnWindowListener(new LearnWindowListener() {
			public void gradeEarned(GradeEnum grade) {
				if (grade == GradeEnum.FAIL) {
					System.out.println("The grade is fail.");
					learnWindow.setCharacter("买");
				} else if (grade == GradeEnum.HARD) {
					System.out.println("The grade is hard.");
				} else if (grade == GradeEnum.GOOD) {
					System.out.println("The grade is good.");
				} else if (grade == GradeEnum.EASY) {
					System.out.println("The grade is easy.");
				}
			}
		});
		
		setSize(1500,800);
		setLocation(200, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	} // Constructor ends
	
	private void setLearnWindow() {
		learnWindow.setCharacter("不");
	}
}

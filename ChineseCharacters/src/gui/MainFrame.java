package gui;

import java.awt.BorderLayout;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;

import data.CharData;

public class MainFrame extends JFrame{
	
	private TheMenuBar menuBar;
	private TheToolBar toolBar;
	private LearnWindow learnWindow;
	
	private CharData char1 = new CharData("是", "shì", "shi4", "be");
	private CharData char2 = new CharData("左", "zuǒ", "zuo3", "left");
	
	private List<CharData> charList = new LinkedList<>();
	
	///////////////////// Constructor ///////////////////////////////////
	
	public MainFrame() {
		
		super("Learn Chinese Characters");
		
		charList.add(new CharData("是", "shì", "shi4", "be"));
		charList.add(new CharData("左", "zuǒ", "zuo3", "left"));
		
		menuBar = new TheMenuBar();
		toolBar = new TheToolBar();
		learnWindow = new LearnWindow(this);
		learnWindow.setLearnWindow(char1);
		//learnWindow.setCharacter(char1);
		
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
		
		learnWindow.setLearnWindowListener(new LearnWindowListener() {
			public void gradeEarned(GradeEnum grade) {
				switch (grade) {
				case FAIL:
					System.out.println("The grade is fail.");
					learnWindow.setCharacter(char2);
					break;
				case HARD:
					System.out.println("The grade is hard.");
					learnWindow.setCharacter(char2);
					break;
				case GOOD:
					System.out.println("The grade is good.");
					learnWindow.setCharacter(char2);
					break;
				case EASY:
					System.out.println("The grade is easy.");
					learnWindow.setCharacter(char2);
					break;
				case AGAIN:
					System.out.println("Regrading...");
					learnWindow.setCharacter(char1);
				default:
					break;
				}
			}
		});
		
		setSize(1500,800);
		setLocation(200, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	} // Constructor ends
	
	private void setLearnWindow() {
		learnWindow.setCharacter(char1);
	}
}

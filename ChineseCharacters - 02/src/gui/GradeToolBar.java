package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.border.Border;

public class GradeToolBar extends JToolBar{
	
	private JButton failButton;
	private JButton hardButton;
	private JButton goodButton;
	private JButton easyButton;
	
	private ToolBarListener listener;
	
	////////////////////////// Constructor /////////////////////////////
	
	public GradeToolBar() {
		
		int space = 8;
		Border spaceBorder = BorderFactory.createEmptyBorder(space, space, space, space);
		Border lineBorder = BorderFactory.createLineBorder(Color.BLACK);
		setBorder(BorderFactory.createCompoundBorder(lineBorder, spaceBorder));
		
		//setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		Font gradeFont = new Font("SansSerif", Font.PLAIN, 32);
		
		failButton = new JButton(" |__C__| ");
		hardButton = new JButton(" |__V__| ");
		goodButton = new JButton(" |__B__| ");
		easyButton = new JButton(" |__N__| ");
		
		failButton.setFont(gradeFont);
		hardButton.setFont(gradeFont);
		goodButton.setFont(gradeFont);
		easyButton.setFont(gradeFont);

		failButton.setToolTipText("Fail");
		hardButton.setToolTipText("Hard");
		goodButton.setToolTipText("Good");
		easyButton.setToolTipText("Easy");
		
		add(failButton);
		add(hardButton);
		add(goodButton);
		add(easyButton);
		
		//setVisible(false);
	}

}

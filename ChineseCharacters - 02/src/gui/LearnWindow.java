package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class LearnWindow extends JDialog {
	
	private JPanel emptyTop;
	private JTextArea charArea;
	private JTextArea pinArea;
	private JTextArea meanArea;
	
	private GradeToolBar gradeBar;
	
	///////////////////////////// Constructor ///////////////////////////
	
	public LearnWindow(JFrame parent) {
		
		super(parent, "Learning Window", false);
		
		emptyTop = new JPanel();
		charArea = new JTextArea();
		pinArea = new JTextArea();
		meanArea = new JTextArea();
		gradeBar = new GradeToolBar();
		
		Font pinyinFont = new Font("SansSerif", Font.PLAIN, 60);
		Font englishFont = new Font("SansSerif", Font.PLAIN, 46);
		Font chineseFont = new Font("SimSun", Font.PLAIN, 110);
		
		pinArea.setFont(pinyinFont);
		charArea.setFont(chineseFont);
		meanArea.setFont(englishFont);
		
		Color col = getBackground();
		
		charArea.setBackground(col);
		pinArea.setBackground(col);
		meanArea.setBackground(col);
		
		layoutPanels();
		
		emptyTop.setSize(400, 100);
		//charArea.setSize(250,200);
		//meanArea.setPreferredSize(new Dimension(400, 200));
		
		charArea.append("  ");
		charArea.append("巧");
		pinArea.append("qiǎo");
		meanArea.append("clever");
		
		setSize(650, 600);
		//setLocationRelativeTo(parent);
		setLocation(900,700);
		//pack();
		//pinArea.setVisible(false);
		//meanArea.setVisible(false);
	}
	
	///////////////////////// Layout areas ///////////////////////////
	
	private void layoutPanels() {
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		///////////////// empty space ////////////////////
		/*
		gc.gridy = 0;
		gc.weighty = 0.3;
		
		gc.gridx = 1;
		gc.weightx = 1;
		
		gc.anchor = GridBagConstraints.NORTH;
		add(emptyTop, gc);
		*/
		
		////////////////// top row --- character and pinyin ///////////////
		
		gc.gridy = 0;
		gc.weighty = 1;
		
		// character
		
		gc.gridx = 0;
		gc.weightx = 1;
		//gc.fill = GridBagConstraints.BOTH;
		gc.anchor = GridBagConstraints.WEST;
		//Insets charPadding = new Insets(50, 50, 0, 0);
		//gc.insets = charPadding;
		add(charArea, gc);
		
		// pinyin
		
		gc.gridx = 1;
		gc.weightx = 5;
		gc.anchor = GridBagConstraints.CENTER;
		add(pinArea, gc);
		
		///////////////////// lower row ---- meaning ///////////////////////
		
		gc.gridy++;
		gc.weighty = 0.5;
		
		gc.gridx = 0;
		gc.weightx = 1;
		gc.gridwidth = 2;
		gc.anchor = GridBagConstraints.NORTH;
		add(meanArea, gc);
		
		/////////////////// grading ////////////////////////
		
		gc.gridy++;
		gc.weighty = 0.2;
		
		gc.gridx = 0;
		gc.weightx = 1;
		gc.gridwidth = 2;
		gc.anchor = GridBagConstraints.NORTH;
		add(gradeBar, gc);
	}
}

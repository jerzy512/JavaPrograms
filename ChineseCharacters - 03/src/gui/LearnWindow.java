package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class LearnWindow extends JDialog {
	
	private String theChar;
	
	private JPanel learnPanel;
	private JPanel pinPanel;
	private JPanel showPanel;
	private GradeToolBar gradeBar;
	private JButton contButton;
	
	private LearnWindowListener listener;
	
	///////////////////////////// Constructor ///////////////////////////
	
	public LearnWindow(JFrame parent) {
		
		super(parent, "Learning Window", false);

		Font chineseFont = new Font("SimSun", Font.PLAIN, 110);
		Font pinyinFont = new Font("SansSerif", Font.PLAIN, 60);
		Font englishFont = new Font("SansSerif", Font.PLAIN, 46);
		
		gradeBar = new GradeToolBar();
		contButton = new JButton("Press spacebar to continue...");
		
		learnPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				
				g.setFont(chineseFont);
				g.drawString(theChar, 120, 190);
				/*
				g.setFont(pinyinFont);
				String pinyin = "xí";
				int pinyinWidth = g.getFontMetrics().stringWidth(pinyin);
				g.drawString(pinyin, 415-(int)(pinyinWidth/2), 175);
				
				g.setFont(englishFont);
				String meaning = "aggression";
				int meaningWidth = g.getFontMetrics().stringWidth(meaning);
				g.drawString(meaning, 300-(int)(meaningWidth/2), 340);
				*/
			}
		};
		
		pinPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				
				g.setFont(chineseFont);
				g.drawString(theChar, 120, 190);
				
				g.setFont(pinyinFont);
				String pinyin = "shì";
				int pinyinWidth = g.getFontMetrics().stringWidth(pinyin);
				g.drawString(pinyin, 415-(int)(pinyinWidth/2), 175);
				/*
				g.setFont(englishFont);
				String meaning = "aggression";
				int meaningWidth = g.getFontMetrics().stringWidth(meaning);
				g.drawString(meaning, 300-(int)(meaningWidth/2), 340);
				*/
			}
		};
		
		showPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				
				g.setFont(chineseFont);
				g.drawString(theChar, 120, 190);
				
				g.setFont(pinyinFont);
				String pinyin = "shì";
				int pinyinWidth = g.getFontMetrics().stringWidth(pinyin);
				g.drawString(pinyin, 415-(int)(pinyinWidth/2), 175);
				
				g.setFont(englishFont);
				String meaning = "be";
				int meaningWidth = g.getFontMetrics().stringWidth(meaning);
				g.drawString(meaning, 300-(int)(meaningWidth/2), 340);
			}
		};

		add(learnPanel, BorderLayout.CENTER);
		add(contButton, BorderLayout.SOUTH);
		
		Font gradeFont = new Font("SansSerif", Font.PLAIN, 32);
		contButton.setFont(gradeFont);
		
		contButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (learnPanel.isVisible()) {
					learnPanel.setVisible(false);
					add(pinPanel, BorderLayout.CENTER);
					playSound("src/sound/shi4.mp3");
				} else {
				contButton.setVisible(false);
				pinPanel.setVisible(false);
				add(gradeBar, BorderLayout.SOUTH);
				add(showPanel, BorderLayout.CENTER);
				}
			}
		});
		
		gradeBar.setGradeListener(new GradeListener() {
			public void buttonClicked(GradeEnum button) {
				listener.gradeEarned(button);
			}
		});
		
		setSize(650, 600);
		//setLocationRelativeTo(parent);
		setLocation(900,700);
		//pack();
	}
	
	static void playSound(String fileName) {
		File file = new File(fileName);
		try {
			Player player = new Player(new FileInputStream(file));
			player.play();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setCharacter(String theChar) {
		this.theChar = theChar;
		showPanel.repaint();
	}
	
	public void setLearnWindowListener(LearnWindowListener listener) {
		this.listener = listener;
	}
}

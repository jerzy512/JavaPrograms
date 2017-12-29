package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import data.CharData;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class LearnWindow extends JDialog {
	
	private String theChar;
	
	private LearnPanel learnPanel1;
	private LearnPanel learnPanel2;
	private LearnPanel learnPanel3;
	private GradeToolBar gradeBar;
	private JButton contButton;
	
	private LearnWindowListener listener;
	
	//private CharData char1 = new CharData("是", "shì", "be");
	private CharData charData = new CharData("是", "shì", "be");
	
	///////////////////////////// Constructor ///////////////////////////
	
	public LearnWindow(JFrame parent) {
		
		super(parent, "Learning Window", false);
		
		gradeBar = new GradeToolBar();
		contButton = new JButton("Press spacebar to continue...");
		
		learnPanel1 = new LearnPanel();
		learnPanel2 = new LearnPanel();
		learnPanel3 = new LearnPanel();
		learnPanel1.setLearnPanel(charData, LearnEnum.CHAR);
		learnPanel2.setLearnPanel(charData, LearnEnum.PIN);
		learnPanel3.setLearnPanel(charData, LearnEnum.MEAN);

		add(learnPanel1, BorderLayout.CENTER);
		add(contButton, BorderLayout.SOUTH);
		
		Font gradeFont = new Font("SansSerif", Font.PLAIN, 32);
		contButton.setFont(gradeFont);
		
		contButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (learnPanel1.isVisible()) {
					learnPanel1.setVisible(false);
					add(learnPanel2, BorderLayout.CENTER);
					playSound("src/sound/shi4.mp3");
				} else {
					learnPanel2.setVisible(false);
					add(learnPanel3, BorderLayout.CENTER);
					contButton.setVisible(false);
					add(gradeBar, BorderLayout.SOUTH);
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
	} // End Constructor
	
	
	
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
	
	public void setCharacter(CharData charData) {
		this.charData = charData;
		learnPanel1.repaint();
		learnPanel2.repaint();
		learnPanel3.repaint();
	}
	
	public void setLearnWindowListener(LearnWindowListener listener) {
		this.listener = listener;
	}
}

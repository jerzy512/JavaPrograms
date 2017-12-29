package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

import data.CharData;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class LearnWindow extends JDialog {

	private String theChar;

	private LearnPanel learnPanel;
	private GradeToolBar gradeBar;
	private JButton contButton;
	private CharData charDataNow;

	private LearnWindowListener listener;

	public Font gradeFont = new Font("SansSerif", Font.PLAIN, 32);

	///////////////////////////// Constructor ///////////////////////////

	public LearnWindow(JFrame parent) {

		super(parent, "Learning Window", false);

		gradeBar = new GradeToolBar();
		contButton = new JButton("... continue ...");

		learnPanel = new LearnPanel();

		setLayout(new BorderLayout());

		setSize(650, 600);
		// setLocationRelativeTo(parent);
		setLocation(900, 700);
		// pack();
	} // End Constructor

	LearnEnum step = LearnEnum.CHAR;

	public void setLearnWindow(CharData charData) {
		charDataNow = charData;
		learnPanel.setLearnPanel(charData, LearnEnum.CHAR);

		add(learnPanel, BorderLayout.CENTER);
		add(contButton, BorderLayout.SOUTH);

		contButton.setFont(gradeFont);
		contButton.setToolTipText("<html>Press \"spacebar\" to see the pinyin. "
				+ "Press it twice to see the meaning <br>"
				+ "Press \"Z\" to redo previous character "
				+ "(works only before pinyin is displayed). <br>"
				+ "Press \"C\" to give \"FAIL\" grade (can be done any time).<br>"
				+ "Press \"V\" (HARD), \"B\" (GOOD) or \"N\" (EASY) after meaning is displayed.<br>"
				+ "Press \"X\" to hide the learning window. </html>");

		contButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (step) {
				case CHAR:
					learnPanel.setLearnPanel(charDataNow, LearnEnum.PIN);
					learnPanel.repaint();
					playSound("src/sound/" + charDataNow.getSound() + ".mp3");
					step = LearnEnum.PIN;
					break;
				case PIN:
					learnPanel.setLearnPanel(charDataNow, LearnEnum.MEAN);
					learnPanel.repaint();
					add(gradeBar, BorderLayout.SOUTH);
					gradeBar.setVisible(true);
					step = LearnEnum.MEAN;
					break;
				case MEAN:
					playSound("src/sound/" + charDataNow.getSound() + ".mp3");
				default:
					break;
				}
			}
		});

		contButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_C, 0),
				"fail");
		contButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_X, 0),
				"invisible");
		contButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, 0),
				"repeat");
		contButton.getActionMap().put("invisible", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		contButton.getActionMap().put("fail", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if (listener != null) {
					listener.gradeEarned(GradeEnum.FAIL);
				}
			}
		});
		contButton.getActionMap().put("repeat", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if (listener != null) {
					if (step == LearnEnum.CHAR) {
						listener.gradeEarned(GradeEnum.AGAIN);
					}
				}
			}
		});

		gradeBar.setGradeListener(new GradeListener() {
			public void buttonClicked(GradeEnum button) {
				listener.gradeEarned(button);
			}
		});
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

	public void setCharacter(CharData charData) {
		charDataNow = charData;
		learnPanel.setLearnPanel(charDataNow, LearnEnum.CHAR);
		gradeBar.setVisible(false);
		step = LearnEnum.CHAR;
		learnPanel.repaint();
	}

	public void setLearnWindowListener(LearnWindowListener listener) {
		this.listener = listener;
	}
}

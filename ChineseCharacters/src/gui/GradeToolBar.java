package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.border.Border;

public class GradeToolBar extends JToolBar {

	private JButton failButton;
	private JButton hardButton;
	private JButton goodButton;
	private JButton easyButton;

	private GradeListener listener;

	////////////////////////// Constructor /////////////////////////////

	public GradeToolBar() {

		int space = 8;
		//Border spaceBorder = BorderFactory.createEmptyBorder(space, space, space, space);
		//Border lineBorder = BorderFactory.createLineBorder(Color.BLACK);
		//setBorder(BorderFactory.createCompoundBorder(lineBorder, spaceBorder));

		// setBorder(BorderFactory.createLineBorder(Color.BLACK));

		Font gradeFont = new Font("SansSerif", Font.PLAIN, 32);

		failButton = new JButton(" C ");
		hardButton = new JButton(" V ");
		goodButton = new JButton(" B ");
		easyButton = new JButton(" N ");

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
		
		failButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listener != null) {
					listener.buttonClicked(GradeEnum.FAIL);
				}
			}
		});
		
		hardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listener != null) {
					listener.buttonClicked(GradeEnum.HARD);
				}
			}
		});
		
		goodButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listener != null) {
					listener.buttonClicked(GradeEnum.GOOD);
				}
			}
		});
		
		easyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listener != null) {
					listener.buttonClicked(GradeEnum.EASY);
				}
			}
		});

		//failButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_C, 0), "fail");
		hardButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_V, 0), "hard");
		goodButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_B, 0), "good");
		easyButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_N, 0), "easy");
		/*
		failButton.getActionMap().put("fail", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if (listener != null) {
					System.out.print("Using Keyboard: ");
					listener.buttonClicked(GradeEnum.FAIL);
				}
			}
		});
		*/
		hardButton.getActionMap().put("hard", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if (listener != null) {
					System.out.print("Using Keyboard: ");
					listener.buttonClicked(GradeEnum.HARD);
				}
			}
		});
		
		goodButton.getActionMap().put("good", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if (listener != null) {
					System.out.print("Using Keyboard: ");
					listener.buttonClicked(GradeEnum.GOOD);
				}
			}
		});
		
		easyButton.getActionMap().put("easy", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if (listener != null) {
					System.out.print("Using Keyboard: ");
					listener.buttonClicked(GradeEnum.EASY);
				}
			}
		});

		//setVisible(false);
	}
	
	public void setGradeListener(GradeListener listener) {
		this.listener = listener;
	}
}

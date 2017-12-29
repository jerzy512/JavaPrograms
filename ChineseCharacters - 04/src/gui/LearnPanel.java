package gui;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import data.CharData;

public class LearnPanel extends JPanel {
	
	private String theChar;
	private String pinyin;
	private String meaning;
	
	public void setLearnPanel(CharData charData, LearnEnum step) {
		this.theChar = charData.getTheChar();
		switch (step) {
		case CHAR:
			this.pinyin = "";
			this.meaning = "";
			break;
		case PIN:
			this.pinyin = charData.getPinyin();
			this.meaning = "";
			break;
		case MEAN:
			this.pinyin = charData.getPinyin();
			this.meaning = charData.getMeaning();
			break;
		default:
			break;
		}
	}
	
	Font chineseFont = new Font("SimSun", Font.PLAIN, 110);
	Font pinyinFont = new Font("SansSerif", Font.PLAIN, 60);
	Font englishFont = new Font("SansSerif", Font.PLAIN, 46);
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setFont(chineseFont);
		g.drawString(theChar, 120, 190);
		
		g.setFont(pinyinFont);
		int pinyinWidth = g.getFontMetrics().stringWidth(pinyin);
		g.drawString(pinyin, 415-(int)(pinyinWidth/2), 175);
		
		g.setFont(englishFont);
		int meaningWidth = g.getFontMetrics().stringWidth(meaning);
		g.drawString(meaning, 300-(int)(meaningWidth/2), 340);
	}
}

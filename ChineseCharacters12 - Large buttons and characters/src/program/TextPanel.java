package program;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextPanel extends JPanel {
	
	private JTextArea textArea;
	
	public TextPanel() {
		textArea = new JTextArea();


		Font chineseFont = new Font("SimSun", Font.PLAIN, 120);
        Font chineseFontExt = new Font("SimSun-ExtB", Font.PLAIN, 120);
        
		textArea.setFont(chineseFont);
		
		setLayout(new BorderLayout());
		add(new JScrollPane(textArea), BorderLayout.CENTER);
	}
	
	public void appendText(String text) {
		textArea.append(text);
	}
}

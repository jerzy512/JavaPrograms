import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	
	public MainFrame() {
		
		super("GUI Test");
		
		JPanel contentPanel = new JPanel();
		
		JPanel displayPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawString("String", 100, 100);
			}
		};
		
		JButton okButton = new JButton("OK");
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("OK button pressed.");
				System.exit(0);
			}
		});
		
		
		
		contentPanel.setLayout(new BorderLayout());
		
		contentPanel.add(displayPanel, BorderLayout.CENTER);
		contentPanel.add(okButton, BorderLayout.SOUTH);
		
		setContentPane(contentPanel);
		
		setSize(500, 300);
		setLocation(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

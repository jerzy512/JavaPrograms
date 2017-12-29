package program;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;

public class MessagePanel extends JPanel {
	
	private JTree serverTree;
	
	public MessagePanel() {
		
		serverTree = new JTree();
		
		setLayout(new BorderLayout());
		
		add(new JScrollPane(serverTree), BorderLayout.CENTER);
	}
}

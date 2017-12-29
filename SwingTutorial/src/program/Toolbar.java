package program;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

//public class Toolbar extends JPanel implements ActionListener {

public class Toolbar extends JToolBar implements ActionListener {

	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;

	private StringListener listener;

	public Toolbar() {
		setBorder(BorderFactory.createEtchedBorder());
		
		setFloatable(false);

		button1 = new JButton();
		button2 = new JButton("__X__");
		button3 = new JButton("__C__");
		button4 = new JButton("__V__");
		button5 = new JButton("__B__");
		button6 = new JButton();
		
		button1.setIcon(createIcon("/images/147659.gif"));
		button1.setToolTipText("Text");

		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);

		// setLayout(new FlowLayout(FlowLayout.LEFT));

		add(button1);
		addSeparator();
		add(button2);
		addSeparator();
		add(button3);
		addSeparator();
		add(button4);
		addSeparator();
		add(button5);
		addSeparator();

		////////// my additions ////////////
		//add(button6);
		/*
		 * Action buttonAction = new AbstractAction("B") {
		 * 
		 * @Override public void actionPerformed(ActionEvent evt) { if (listener !=
		 * null) { listener.textEmitted("Button B clicked.\n"); }
		 * //System.out.println("Refreshing..."); } };
		 
		// String key = "Refresh";

		button6.setAction(new AbstractAction("B") {
			public void actionPerformed(ActionEvent arg0) {
				if (listener != null) {
					listener.textEmitted("Button B clicked.\n");
				}
			}
		});
	*/
		button1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_B, 0), "key");

		button1.getActionMap().put("key", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if (listener != null) {
					listener.textEmitted("Button B clicked.\n");
				}
			}
		});

		//// End my additions
	}

	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton) e.getSource();

		if (clickedButton == button1) {
			if (listener != null) {
				listener.textEmitted("Button 1 clicked.\n");
			}
		} else if (clickedButton == button2) {
			if (listener != null) {
				listener.textEmitted("Button 2 clicked.\n");
			}
		} else if (clickedButton == button3) {
			if (listener != null) {
				listener.textEmitted("Button 3 clicked.\n");
			}
		} else if (clickedButton == button4) {
			if (listener != null) {
				listener.textEmitted("Button 4 clicked.\n");
			}
		} else if (clickedButton == button5) {
			if (listener != null) {
				listener.textEmitted("Button 5 clicked.\n");
			}
		}
	}
	
	private ImageIcon createIcon(String path) {
		URL url = getClass().getResource(path);
		
		if (url == null) {
			System.err.println("Unable to load image: " + path);
		}
		
		ImageIcon icon = new ImageIcon(url);
		
		return icon;
	}
	
	public void setStringListener(StringListener listener) {
		this.listener = listener;
	}
}

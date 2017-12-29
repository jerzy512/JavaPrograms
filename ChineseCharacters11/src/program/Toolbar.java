package program;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener {

	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;

	private ButtonListener listener;

	public Toolbar() {
		button1 = new JButton("Action 1");
		button2 = new JButton("Action 2");
		button3 = new JButton("Action 3");
		button4 = new JButton("Action 4");
		button5 = new JButton("Action 5");

		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);

		setLayout(new FlowLayout(FlowLayout.LEFT));

		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
	}

	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton) e.getSource();
		if (listener != null) {
			if (clickedButton == button1) {
				listener.buttonAction(1);
			} else if (clickedButton == button2) {
				listener.buttonAction(2);
			} else if (clickedButton == button3) {
				listener.buttonAction(3);
			} else if (clickedButton == button4) {
				listener.buttonAction(4);
			}
		}
	}

	public void setButtonListener(ButtonListener listener) {
		this.listener = listener;
	}
}

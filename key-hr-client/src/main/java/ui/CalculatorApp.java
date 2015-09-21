package ui;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import services.interfaces.CalculatorServiceRemote;

public class CalculatorApp extends JFrame {

	private CalculatorServiceRemote remote = getProxy();
	private JPanel panel = new JPanel();
	private JLabel aLabel = new JLabel("a");
	private JLabel bLabel = new JLabel("b");
	private JTextField aField = new JTextField();
	private JTextField bField = new JTextField();
	private JLabel resultLabel = new JLabel();
	private JButton submitButton = new JButton("result = ");

	public CalculatorApp() {

		setTitle("Calc");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
		setVisible(true);
		pack();
	}

	private CalculatorServiceRemote getProxy() {

		try {
			Context ctx = new InitialContext();
			remote = (CalculatorServiceRemote) ctx
					.lookup("/key-hr/CalculatorService!services.interfaces.CalculatorServiceRemote");
		} catch (NamingException e) {
			e.printStackTrace();
		}

		return remote;
	}

	private void init() {

		panel.setLayout(new GridLayout(3, 2));
		panel.add(aLabel);
		panel.add(aField);
		panel.add(bLabel);
		panel.add(bField);
		panel.add(submitButton);
		panel.add(resultLabel);
		getContentPane().add(panel);
		submitButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int a = Integer.parseInt(aField.getText());
				int b = Integer.parseInt(bField.getText());
				int z = remote.sum(a, b);
				resultLabel.setText(String.valueOf(z));
			}
		});
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new CalculatorApp();
			}
		});
	}

}

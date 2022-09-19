package interfaceGUI;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class window extends JFrame {
	static window frame;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public window() {
		setResizable(false);
		setTitle("Maze - Q-Learning");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(566, 430);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBounds(0, 0, 550, 393);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menu menu = new menu();
		menu.setBounds(0, 0, 550, 393);
		contentPane.add(menu);
		
		
	}
}

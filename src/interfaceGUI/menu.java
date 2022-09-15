package interfaceGUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class menu extends JPanel {
	private JButton x61x61;
	private JButton x6x6;
	private JButton exit;
	/**
	 * Create the panel.
	 */
	public menu() {
		setRequestFocusEnabled(false);
		setFocusTraversalKeysEnabled(false);
		setFocusable(false);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{290, 0};
		gridBagLayout.rowHeights = new int[]{40, 60, 30, 30, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel title = new JLabel("Maze - Reinforcement Learning");
		title.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		title.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_title = new GridBagConstraints();
		gbc_title.insets = new Insets(0, 0, 5, 0);
		gbc_title.gridx = 0;
		gbc_title.gridy = 1;
		add(title, gbc_title);
		
		x6x6 = new JButton("6x6 - Without Obstacle");
		x6x6.setFocusable(false);
		x6x6.setFocusTraversalKeysEnabled(false);
		x6x6.setFocusPainted(false);
		x6x6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		x6x6.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		GridBagConstraints gbc_x6x6 = new GridBagConstraints();
		gbc_x6x6.insets = new Insets(0, 0, 5, 0);
		gbc_x6x6.gridx = 0;
		gbc_x6x6.gridy = 2;
		add(x6x6, gbc_x6x6);
		
		x61x61 = new JButton("61x61 - With Obstacle");
		x61x61.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		x61x61.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		x61x61.setFocusable(false);
		x61x61.setFocusTraversalKeysEnabled(false);
		x61x61.setFocusPainted(false);
		GridBagConstraints gbc_x61x61 = new GridBagConstraints();
		gbc_x61x61.insets = new Insets(0, 0, 5, 0);
		gbc_x61x61.gridx = 0;
		gbc_x61x61.gridy = 3;
		add(x61x61, gbc_x61x61);
		
		exit = new JButton("Exit");
		exit.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		exit.setFocusable(false);
		exit.setFocusTraversalKeysEnabled(false);
		exit.setFocusPainted(false);
		GridBagConstraints gbc_exit = new GridBagConstraints();
		gbc_exit.gridx = 0;
		gbc_exit.gridy = 4;
		add(exit, gbc_exit);
		
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
	}
	
	public JButton get61() {
		return x61x61;
	}
	public JButton get6() {
		return x6x6;
	}
	public JButton getExit() {
		return exit;
	}

}

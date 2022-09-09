package interfaceGUI;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class menu extends JPanel {

	/**
	 * Create the panel.
	 */
	public menu() {
		setRequestFocusEnabled(false);
		setFocusTraversalKeysEnabled(false);
		setFocusable(false);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 396, 0, 0};
		gridBagLayout.rowHeights = new int[]{80, 45, 45, 45, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Maze - Reinforcement Learning");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JButton x6x6 = new JButton("6x6 - Without Obstacle");
		x6x6.setFocusable(false);
		x6x6.setFocusTraversalKeysEnabled(false);
		x6x6.setFocusPainted(false);
		x6x6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		x6x6.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		GridBagConstraints gbc_x6x6 = new GridBagConstraints();
		gbc_x6x6.insets = new Insets(0, 0, 5, 5);
		gbc_x6x6.gridx = 1;
		gbc_x6x6.gridy = 1;
		add(x6x6, gbc_x6x6);
		
		JButton x61x61 = new JButton("61x61 - With Obstacle");
		x61x61.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		x61x61.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		x61x61.setFocusable(false);
		x61x61.setFocusTraversalKeysEnabled(false);
		x61x61.setFocusPainted(false);
		GridBagConstraints gbc_x61x61 = new GridBagConstraints();
		gbc_x61x61.insets = new Insets(0, 0, 5, 5);
		gbc_x61x61.gridx = 1;
		gbc_x61x61.gridy = 2;
		add(x61x61, gbc_x61x61);
		
		

	}

}

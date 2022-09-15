package interfaceGUI;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JTextArea;

import mazeCreate.maze61x61;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class maze61 extends JPanel {
	int[][] mat = new int [61][61];
	/**
	 * Create the panel.
	 */
	public maze61(JTabbedPane table, int index) {
		setSize(305, 305);
		setLayout(null);
		setLocation(0, 0);
		
		JLabel closeTabbed = new JLabel("X");
		closeTabbed.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		closeTabbed.setForeground(Color.RED);
		closeTabbed.setBounds(297, 0, 8, 14);
		add(closeTabbed);
		
		closeTabbed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table.remove(index);;
			}
		});
		
		JLabel imagem = new JLabel( new maze61x61(mat).drawnMaze() );
		imagem.setBounds(0, 0, 305, 305);
		add(imagem);
	}
}

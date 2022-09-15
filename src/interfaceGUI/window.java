package interfaceGUI;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridBagConstraints;
import javax.swing.JTabbedPane;
import java.awt.Cursor;
import javax.swing.JLabel;

public class window extends JFrame {
	static window frame;
	
	private JPanel contentPane;
	private maze61 maze61;
	
	private JButton x61;
	private JButton x6;
	private JButton exit;
	
	private boolean create61 = false;
	private int qtTab = 0;

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
		setTitle("Maze - Q-Learning");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(338, 382);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 312, 333);
		tabbedPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		contentPane.add(tabbedPane);
		
		menu menu = new menu();
		GridBagConstraints gbc_menu = new GridBagConstraints();
		gbc_menu.gridx = 0;
		gbc_menu.gridy = 0;
		
		tabbedPane.addTab("Menu", menu);
		
		x61 = menu.get61();
		x6 = menu.get6();
		exit = menu.getExit();

		x61.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//verificar se ja existe essa tabbed
				qtTab = tabbedPane.getTabCount();
				
				if(qtTab > 1 && tabbedPane.getTitleAt(1).equals("61 x 61")) {
					create61 = true;
				}
				else if(qtTab > 2 && tabbedPane.getTitleAt(2).equals("61 x 61")) {
					create61 = true;
				}
				else {
					create61 = false;
				}
				
				//
				if(!create61) {
					maze61 = new maze61(tabbedPane, tabbedPane.getTabCount());
					//add o panel ao tabbedpane
					tabbedPane.addTab("61 x 61", maze61);
					//move para a aba do tabbed correspondente a esse componente que foi riado
					tabbedPane.setSelectedIndex(tabbedPane.indexOfComponent(maze61));
					//muda o status para saber que ja foi criado e ainda não foi fechado
					qtTab = tabbedPane.getTabCount();
					create61 = true;
				}
			}
		});
		
		
		
	}
}

package interfaceGUI;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;

public class menu extends JPanel {
	private JButton x61x61;
	private JButton x6x6;
	private JButton exit;
	
	private maze61 maze61;
	
	private boolean create61 = false;
	private int qtTab = 0;
	/**
	 * Create the panel.
	 */
	public menu() {
		setRequestFocusEnabled(false);
		setFocusTraversalKeysEnabled(false);
		setFocusable(false);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 21, 550, 370);
		tabbedPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		add(tabbedPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, new Color(0, 0, 0), null));
		menuBar.setBounds(0, 0, 550, 22);
		add(menuBar);
		
		JMenu arquivoBar = new JMenu("Arquivo");
		arquivoBar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuBar.add(arquivoBar);
		
		JMenuItem bar6x6 = new JMenuItem("Create 6x6 - Without Obstacle");
		bar6x6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		arquivoBar.add(bar6x6);
		
		JMenuItem bar61x61 = new JMenuItem("Create 61x61 - With Obstacle");
		bar61x61.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		arquivoBar.add(bar61x61);
		
		JMenuItem barExit = new JMenuItem("Exit");
		barExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		arquivoBar.add(barExit);
		
		JMenu visualization = new JMenu("Visualization");
		menuBar.add(visualization);
		
		JCheckBox animationCheck = new JCheckBox("No creation animation");
		animationCheck.setToolTipText("Disables the maze presentation animation.");
		visualization.add(animationCheck);

		bar61x61.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//verificar se ja existe essa tabbed
				qtTab = tabbedPane.getTabCount();
				
				if(qtTab > 0 && tabbedPane.getTitleAt(0).equals("61 x 61")) {
					create61 = true;
				}
				else if(qtTab > 1 && tabbedPane.getTitleAt(1).equals("61 x 61")) {
					create61 = true;
				}
				else {
					create61 = false;
				}
				//
				if(!create61) {
					maze61 = new maze61(tabbedPane, tabbedPane.getTabCount(), animationCheck.isSelected());
					//add o panel ao tabbedpane
					tabbedPane.addTab("61 x 61", maze61);
					maze61.setThisComponent(maze61);
					//move para a aba do tabbed correspondente a esse componente que foi riado
					tabbedPane.setSelectedIndex(tabbedPane.indexOfComponent(maze61));
					//muda o status para saber que ja foi criado e ainda não foi fechado
					qtTab = tabbedPane.getTabCount();
					create61 = true;
				}
			}
		});
		
		barExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
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

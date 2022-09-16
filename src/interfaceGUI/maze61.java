package interfaceGUI;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import mazeCreate.matriz;
import mazeCreate.maze61x61;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.swing.border.BevelBorder;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import java.awt.Insets;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class maze61 extends JPanel {
	private matriz matr = new matriz();
	private maze61 esse;
	private int[][] mat = matr.getM61();
	private JRadioButton uploadMaze;
	private JRadioButton defaultMaze;
	private JTextField fileField;
	/**
	 * Create the panel.
	 */
	public maze61(JTabbedPane table, int index) {
		setSize(550, 348);
		setLayout(null);
		setLocation(0, 0);
		
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		chooser.setBounds(0	, 0, 400, 400);
		
		JButton selectFileButton = new JButton("Select");
		selectFileButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		selectFileButton.setEnabled(false);
		selectFileButton.setFocusable(false);
		selectFileButton.setBounds(59, 243, 100, 23);
		add(selectFileButton);
		
		fileField = new JTextField();
		fileField.setForeground(Color.RED);
		fileField.setEditable(false);
		fileField.setBounds(45, 219, 130, 20);
		add(fileField);
		fileField.setColumns(10);
		
		uploadMaze = new JRadioButton("Upload maze");
		uploadMaze.setFocusable(false);
		uploadMaze.setToolTipText("Upload a .txt with 0 and 1, where 1 is obstacles and 0 is free way.");
		uploadMaze.setOpaque(false);
		uploadMaze.setMargin(new Insets(0, 0, 0, 0));
		uploadMaze.setFont(new Font("Tahoma", Font.PLAIN, 11));
		uploadMaze.setBounds(111, 195, 85, 23);
		add(uploadMaze);
		
		defaultMaze = new JRadioButton("Default maze");
		defaultMaze.setSelected(true);
		defaultMaze.setFocusable(false);
		defaultMaze.setToolTipText("Create a default maze.");
		defaultMaze.setFont(new Font("Tahoma", Font.PLAIN, 11));
		defaultMaze.setMargin(new Insets(0, 0, 0, 0));
		defaultMaze.setOpaque(false);
		defaultMaze.setBounds(16, 195, 85, 23);
		add(defaultMaze);
		
		JLabel typeMaze = new JLabel("Reference maze");
		typeMaze.setHorizontalAlignment(SwingConstants.CENTER);
		typeMaze.setOpaque(true);
		typeMaze.setBackground(SystemColor.menu);
		typeMaze.setBounds(30, 185, 110, 14);
		add(typeMaze);
		
		JLabel areaSetMaze = new JLabel("");
		areaSetMaze.setBorder(new BevelBorder(BevelBorder.LOWERED, null, Color.BLACK, Color.BLACK, null));
		areaSetMaze.setBounds(13, 190, 193, 80);
		add(areaSetMaze);
		
		JLabel speed = new JLabel("Speed");
		speed.setHorizontalAlignment(SwingConstants.CENTER);
		speed.setBounds(13, 142, 193, 14);
		add(speed);
		
		JSlider slider = new JSlider();
		slider.setValue(20);
		slider.setBounds(13, 157, 193, 26);
		add(slider);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setBounds(213, 15, 1, 310);
		add(separator);
		
		JButton play = new JButton("Play");
		play.setFocusable(false);
		play.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		play.setBounds(13, 273, 193, 23);
		play.setEnabled(false);
		add(play);
		
		JButton closeTab = new JButton("Close");
		closeTab.setFocusable(false);
		closeTab.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		closeTab.setBounds(111, 298, 95, 23);
		add(closeTab);

		
		JLabel areaM = new JLabel();
		areaM.setFocusable(false);
		areaM.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(64, 64, 64), Color.DARK_GRAY, new Color(64, 64, 64), null));
		areaM.setBounds(219, 17, 307, 307);
		add(areaM);
		
		JButton construct = new JButton("Construct");
		construct.setFocusable(false);
		construct.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		construct.setBounds(13, 298, 95, 23);
		add(construct);
		
		JLabel imagem = new JLabel();
		imagem.setBounds(220, 18, 305, 305);
		add(imagem);
		
		JLabel menuLabel = new JLabel("");
		menuLabel.setBorder(new BevelBorder(BevelBorder.RAISED, null, Color.DARK_GRAY, Color.DARK_GRAY, null));
		menuLabel.setBounds(10, 17, 199, 307);
		add(menuLabel);
		
		closeTab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table.remove(index);;
			}
		});
		
		construct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(defaultMaze.isSelected()) {
					construct.setEnabled(false);
					imagem.setIcon( new maze61x61(mat).drawnMaze() );
					play.setEnabled(true);						
				}
			}
		});
		
		defaultMaze.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				construct.setEnabled(true);
				
				if(uploadMaze.isSelected()) {
					uploadMaze.setSelected(false);
					defaultMaze.setSelected(true);
					selectFileButton.setEnabled(false);
				}
				else {
					defaultMaze.setSelected(true);
				}
			}
		});
		uploadMaze.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				construct.setEnabled(false);
				if(defaultMaze.isSelected()) {
					defaultMaze.setSelected(false);
					uploadMaze.setSelected(true);
					selectFileButton.setEnabled(true);
				}
				else {
					uploadMaze.setSelected(true);
				}
			}
		});
		
		selectFileButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int choice = 0;
				if(selectFileButton.isEnabled()) {
					FileNameExtensionFilter filter = new FileNameExtensionFilter(
					        "Arquivo texto", "txt");
					chooser.setFileFilter(filter);
					chooser.setFileSelectionMode(0);
					
					choice = chooser.showOpenDialog(esse);
					
					if(choice == JFileChooser.APPROVE_OPTION) {
						construct.setEnabled(true);
						fileField.setText(chooser.getSelectedFile().getName());
					}
				}
			}
		});
		
	}
	
	public void setThisComponent(maze61 panel) {
		this.esse = panel;
	}
	
	private void RadioGroup() {
		
	}
}

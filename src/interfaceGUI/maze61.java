package interfaceGUI;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import mazeCreate.locationPrint;
import mazeCreate.matriz;
import mazeCreate.maze61x61Thread;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.filechooser.FileNameExtensionFilter;

import IA.reforcement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class maze61 extends JPanel {
	private matriz matr = new matriz();
	private maze61 esse;
	private locationPrint agente;
	private int[][] mat = matr.getM61();
	
	private JRadioButton uploadMazeRB;
	private JRadioButton defaultMazeRB;
	
	private JTextField fileField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private maze61x61Thread mazeThread;
	/**
	 * Create the panel.
	 */
	public maze61(JTabbedPane table, int index, boolean animation) {
		setSize(550, 348);
		setLayout(null);
		setLocation(0, 0);
		
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		chooser.setBounds(0	, 0, 400, 400);
		
		JSpinner nWayOutSpinner = new JSpinner();
		nWayOutSpinner.setEnabled(false);
		nWayOutSpinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		nWayOutSpinner.setBounds(127, 38, 73, 20);
		add(nWayOutSpinner);
		
		JButton stopRun = new JButton("Stop");
		stopRun.setEnabled(false);
		stopRun.setFocusable(false);
		stopRun.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		stopRun.setBounds(111, 111, 92, 23);
		add(stopRun);
		
		JButton clearMaze = new JButton("Clear");
		clearMaze.setEnabled(false);
		clearMaze.setFocusable(false);
		clearMaze.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		clearMaze.setBounds(16, 111, 92, 23);
		add(clearMaze);
		
		JSpinner nStepSpinner = new JSpinner();
		nStepSpinner.setEnabled(false);
		nStepSpinner.setModel(new SpinnerNumberModel(new Integer(100), new Integer(100), null, new Integer(1)));
		nStepSpinner.setBounds(127, 64, 73, 20);
		add(nStepSpinner);
		
		JRadioButton untilFindWayRB = new JRadioButton("Until find way out");
		untilFindWayRB.setSelected(true);
		untilFindWayRB.setEnabled(false);
		buttonGroup.add(untilFindWayRB);
		untilFindWayRB.setToolTipText("");
		untilFindWayRB.setOpaque(false);
		untilFindWayRB.setMargin(new Insets(0, 0, 0, 0));
		untilFindWayRB.setFont(new Font("Tahoma", Font.PLAIN, 11));
		untilFindWayRB.setFocusable(false);
		untilFindWayRB.setBounds(16, 37, 105, 23);
		add(untilFindWayRB);
		
		JRadioButton nStepsRB = new JRadioButton("N steps");
		nStepsRB.setEnabled(false);
		buttonGroup.add(nStepsRB);
		nStepsRB.setToolTipText("");
		nStepsRB.setOpaque(false);
		nStepsRB.setMargin(new Insets(0, 0, 0, 0));
		nStepsRB.setFont(new Font("Tahoma", Font.PLAIN, 11));
		nStepsRB.setFocusable(false);
		nStepsRB.setBounds(16, 63, 57, 23);
		add(nStepsRB);
		
		JLabel optMaze = new JLabel("Options to run");
		optMaze.setOpaque(true);
		optMaze.setHorizontalAlignment(SwingConstants.CENTER);
		optMaze.setBackground(SystemColor.menu);
		optMaze.setBounds(30, 23, 110, 14);
		add(optMaze);
		
		JLabel areaOptMaze = new JLabel("");
		areaOptMaze.setEnabled(false);
		areaOptMaze.setBorder(new BevelBorder(BevelBorder.LOWERED, null, Color.BLACK, Color.BLACK, null));
		areaOptMaze.setBounds(13, 27, 193, 110);
		add(areaOptMaze);
		
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
		
		uploadMazeRB = new JRadioButton("Upload maze");
		uploadMazeRB.setFocusable(false);
		uploadMazeRB.setToolTipText("Upload a .txt with 0 and 1, where 1 is obstacles and 0 is free way.");
		uploadMazeRB.setOpaque(false);
		uploadMazeRB.setMargin(new Insets(0, 0, 0, 0));
		uploadMazeRB.setFont(new Font("Tahoma", Font.PLAIN, 11));
		uploadMazeRB.setBounds(122, 195, 85, 23);
		add(uploadMazeRB);
		
		defaultMazeRB = new JRadioButton("Default maze");
		defaultMazeRB.setSelected(true);
		defaultMazeRB.setFocusable(false);
		defaultMazeRB.setToolTipText("Create a default maze.");
		defaultMazeRB.setFont(new Font("Tahoma", Font.PLAIN, 11));
		defaultMazeRB.setMargin(new Insets(0, 0, 0, 0));
		defaultMazeRB.setOpaque(false);
		defaultMazeRB.setBounds(16, 195, 85, 23);
		add(defaultMazeRB);
		
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
		slider.setEnabled(false);
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
		areaM.setBounds(220, 18, 305, 305);
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
		
		play.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				agente = new locationPrint(areaM);
				agente.start();
				reforcement iaR = new reforcement(mat,1,3000, agente);
				iaR.start();
			}
		});
		stopRun.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				agente.stopMe();
			}
		});
		
		closeTab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table.remove(index);;
			}
		});
		
		clearMaze.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				nWayOutSpinner.setEnabled(false);
				nStepSpinner.setEnabled(false);
				imagem.setIcon(null);
				mazeThread.clearMaze();
				
				construct.setEnabled(true);
				
				uploadMazeRB.setEnabled(true);
				defaultMazeRB.setEnabled(true);
				
				slider.setEnabled(false);
				nStepsRB.setEnabled(false);
				untilFindWayRB.setEnabled(false);
				nWayOutSpinner.setEnabled(false);
				clearMaze.setEnabled(false);
				untilFindWayRB.setSelected(true);
				
				play.setEnabled(false);
			}
		});
		
		construct.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(defaultMazeRB.isSelected()) {
					construct.setEnabled(false);
					
					mazeThread = new maze61x61Thread(mat,imagem,play, animation);
					mazeThread.start();
					
					uploadMazeRB.setEnabled(false);
					defaultMazeRB.setEnabled(false);
					
					slider.setEnabled(true);
					nStepsRB.setEnabled(true);
					untilFindWayRB.setEnabled(true);
					nWayOutSpinner.setEnabled(true);
					clearMaze.setEnabled(true);
				}
			}
		});
		
		defaultMazeRB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				construct.setEnabled(true);
				
				if(uploadMazeRB.isSelected()) {
					uploadMazeRB.setSelected(false);
					defaultMazeRB.setSelected(true);
					selectFileButton.setEnabled(false);
				}
				else {
					defaultMazeRB.setSelected(true);
				}
			}
		});
		uploadMazeRB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				construct.setEnabled(false);
				if(defaultMazeRB.isSelected()) {
					defaultMazeRB.setSelected(false);
					uploadMazeRB.setSelected(true);
					selectFileButton.setEnabled(true);
				}
				else {
					uploadMazeRB.setSelected(true);
				}
			}
		});
		
		untilFindWayRB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					nWayOutSpinner.setEnabled(true);
					nStepSpinner.setEnabled(false);
			}
		});
		nStepsRB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					nWayOutSpinner.setEnabled(false);
					nStepSpinner.setEnabled(true);
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

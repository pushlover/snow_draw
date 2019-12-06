package edu.neu.csye6200.ca;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class CACrystalSet extends CAApp {
	private CACrystalSet() {
		init();
		// this.addWindowListerner
		createAndShowGUI();

	}

	public static CACell findCell(int row, int column) {
		for (CACell cell : cellList) {
			if (cell.getRow() == row && cell.getColumn() == column) {
				return cell;
			}

		}
		return null;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new CACrystalSet();

			}
		});
	}

	// constants and global variables
	static CAThread thread1 = new CAThread(1);
	static CAThread thread2 = new CAThread(2);
	static CAThread thread3 = new CAThread(3);
	static boolean Thread1_flag = false;
	static int rule = 1;
	static int MaxStep = 20;
	DrawingPanel panel = new DrawingPanel();
	// PaintThread paint = new PaintThread("rule 1");
	static List<CACell> cellList = new ArrayList<CACell>();
	final static Color COLOURBACK = Color.WHITE;
	final static Color COLOURCELL = Color.WHITE;
	final static Color COLOURGRID = Color.BLACK;
	final static Color COLOURONE = Color.BLUE;
	//final static Color COLOURONETXT = Color.BLUE;
	final static Color COLOURTWO = Color.BLACK;
//	final static Color COLOURTWOTXT = new Color(255, 100, 255);
	final static int EMPTY = 0;
	final static int BSIZE = 70; // board size.
	final static int HEXSIZE = 10; // hex size in pixels
	final static int BORDERS = 1;
	final static int SCRSIZE = HEXSIZE * (BSIZE + 1) + BORDERS * 3; // screen size (vertical dimension).

	static int[][] board = new int[BSIZE][BSIZE];
	protected JPanel northPanel = null;
	protected JButton startBtn = null;
	protected JButton stopBtn = null;
	protected JComboBox RuleComboBox = null;
	protected JTextField step;
	private CACanvas caPanel = null;

	void init() {

		CACrytal.setXYasVertex(false); // RECOMMENDED: leave this as FALSE.

		CACrytal.setHeight(HEXSIZE); // Either setHeight or setSize must be run to initialize the hex
		CACrytal.setBorders(BORDERS);

		for (int i = 0; i < BSIZE; i++) {
			for (int j = 0; j < BSIZE; j++) {
				board[i][j] = EMPTY;
				cellList.add(new CACell(0, i, j));
			}
		}

		board[BSIZE / 2][BSIZE / 2] = (int) ' ';
		findCell(BSIZE / 2, BSIZE / 2).setStage(1);

	}

	private void createAndShowGUI() {

		Container content = frame.getContentPane();
		content.add(panel);
		frame.setSize((int) (SCRSIZE / 1.23), SCRSIZE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		// createAndShowGUI();
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public JPanel getNorthPanel() {
		northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout());
		step=new JTextField(5);
		step.addActionListener(this);
		//step.setBounds(10, 0, 300, 50);
		step.setSize(400, 400);
		step.setText("20");
		northPanel.add(step);
		startBtn = new JButton("Start");
		startBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
			
				panel.paintsnow(rule);
				MaxStep=Integer.parseInt(step.getText());
				// Thread1_flag=true;
			}
		}); // Allow the app to hear about button pushes
		northPanel.add(startBtn);

		stopBtn = new JButton("Stop"); // Allow the app to hear about button pushes
		stopBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				switch(rule) {
				case 1:thread1.suspend();
				break;
				case 2:thread2.suspend();
				break;
				case 3:thread3.suspend();
				break;
				}
				// Thread1_flag=true;
			}
		});
		northPanel.add(stopBtn);
		String[] Rule = { "Rule 1", "Rule 2", "Rule 3" };
		RuleComboBox = new JComboBox(Rule);
		RuleComboBox.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {// 查看是否为新选中的选项触发的
					if (e.getItem().equals("Rule 1")) {// 查看触发的选项
						for (int a = 0; a < CACrystalSet.BSIZE; a++) {
							for (int b = 0; b < CACrystalSet.BSIZE; b++) {
								CACrystalSet.board[a][b] = CACrystalSet.EMPTY;
								findCell(a, b).setStage(0);
							}
						}

						CACrystalSet.board[CACrystalSet.BSIZE / 2][CACrystalSet.BSIZE / 2] = (int) ' ';
						CACrystalSet.findCell(CACrystalSet.BSIZE / 2, CACrystalSet.BSIZE / 2).setStage(1);
						rule = 1;
						MaxStep = 20;
					} else if (e.getItem().equals("Rule 2")) {// 查看触发的选项
						for (int a = 0; a < CACrystalSet.BSIZE; a++) {
							for (int b = 0; b < CACrystalSet.BSIZE; b++) {
								CACrystalSet.board[a][b] = CACrystalSet.EMPTY;
								findCell(a, b).setStage(0);
							}
						}

						CACrystalSet.board[CACrystalSet.BSIZE / 2][CACrystalSet.BSIZE / 2] = (int) ' ';
						CACrystalSet.findCell(CACrystalSet.BSIZE / 2, CACrystalSet.BSIZE / 2).setStage(1);
						rule = 2;
						MaxStep = 20;
					} else if (e.getItem().equals("Rule 3")) {// 查看触发的选项
						for (int a = 0; a < CACrystalSet.BSIZE; a++) {
							for (int b = 0; b < CACrystalSet.BSIZE; b++) {
								CACrystalSet.board[a][b] = CACrystalSet.EMPTY;
								findCell(a, b).setStage(0);
							}
						}

						CACrystalSet.board[CACrystalSet.BSIZE / 2][CACrystalSet.BSIZE / 2] = (int) ' ';
						CACrystalSet.findCell(CACrystalSet.BSIZE / 2, CACrystalSet.BSIZE / 2).setStage(1);
						rule = 3;
						MaxStep = 20;
					}
				}
			}

		});
		northPanel.add(RuleComboBox);
		return northPanel;
	}

}

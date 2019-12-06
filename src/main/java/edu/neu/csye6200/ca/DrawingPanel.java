package edu.neu.csye6200.ca;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel {

	public class PaintThread extends Thread {

		public PaintThread(String name) {
			// TODO Auto-generated constructor stub
			super(name);
		}

		public void run() {
			int j = 2;
			try {
				while (j > 0) {
					Thread.sleep(100L);
					repaint();
					// j++;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public DrawingPanel() {
		setBackground(CACrystalSet.COLOURBACK);
		// paintsnow();

	}

	public void paintsnow(int rule) {
		// if(CACrystalSet.Thread1_flag==true)
	
		switch (rule) {
		case 1:
			if (!CACrystalSet.thread1.isAlive()) {
				CACrystalSet.thread1.j=2;
				CACrystalSet.thread1.start();
			} else {
				CACrystalSet.thread1.j=2;
				CACrystalSet.thread1.resume();

			}
			break;
		case 2:
			if (!CACrystalSet.thread2.isAlive()) {
				CACrystalSet.thread2.j=2;
				CACrystalSet.thread2.start();
			} else {
				CACrystalSet.thread2.j=2;
				CACrystalSet.thread2.resume();

			}
			break;
		case 3:
			if (!CACrystalSet.thread3.isAlive()) {
				CACrystalSet.thread3.j=2;
				CACrystalSet.thread3.start();
			} else {
				CACrystalSet.thread3.j=2;
				CACrystalSet.thread3.resume();

			}
			break;
		}
		
		PaintThread paint = new PaintThread("rule 1");
		paint.start();
		// repaint();

	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		super.paintComponent(g2);
		// draw grid
		for (int i = 0; i < CACrystalSet.BSIZE; i++) {
			for (int j = 0; j < CACrystalSet.BSIZE; j++) {
				CACrytal.drawHex(i, j, g2);
			}
		}
		// fill in hexesCACrystalSet.
		for (int i = 0; i < CACrystalSet.BSIZE; i++) {
			for (int j = 0; j < CACrystalSet.BSIZE; j++) {
				CACrytal.fillHex(i, j, CACrystalSet.board[i][j], g2);
			}
		}
	}

} // end of DrawingPanel class

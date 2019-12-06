package edu.neu.csye6200.ca;

public class CAThread extends Thread {
	public int rule;
	public int j;
	public CAThread(int rule) {
		// TODO Auto-generated constructor stub
		this.rule = rule;
	}

	public void run() {
		//int j=2;
		CARule rule = new CARule();
		

		if (this.rule == 1) {// 查看触发的选项
			
			while (this.j < CACrystalSet.MaxStep) {
				
				for (CACell c : rule.CARule_1(this.j, CACrystalSet.BSIZE, CACrystalSet.cellList)) {
					if (c.getStage() > 0) {
						CACrystalSet.board[c.getRow()][c.getColumn()] = (int) ' ';
					}
				}
				this.j++;
				try {
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else if (this.rule == 2) {
			
			while (this.j < CACrystalSet.MaxStep) {
				for (CACell c : rule.CARule_2(this.j, CACrystalSet.BSIZE, CACrystalSet.cellList)) {
					if (c.getStage() > 0) {
						CACrystalSet.board[c.getRow()][c.getColumn()] = (int) ' ';
					}
				}
				this.j++;
				try {
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else if (this.rule == 3) {// 查看触发的选项

			
			while (this.j < CACrystalSet.MaxStep) {
				for (CACell c : rule.CARule_3(j, CACrystalSet.BSIZE, CACrystalSet.cellList)) {
					if (c.getStage() > 0) {
						CACrystalSet.board[c.getRow()][c.getColumn()] = (int) ' ';
					}
				}
				this.j++;
				try {
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		// repaint();
	}

}

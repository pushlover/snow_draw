package edu.neu.csye6200.ca;

import java.util.List;

public abstract class findCell {

	public findCell() {
		// TODO Auto-generated constructor stub
	}
	
	public CACell findCell(int row, int column, List<CACell> cellList) {
		for (CACell cell : cellList) {
			if (cell.getRow() == row && cell.getColumn() == column) {
				return cell;
			}

		}
		return null;
	}

}

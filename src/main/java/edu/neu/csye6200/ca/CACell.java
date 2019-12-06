package edu.neu.csye6200.ca;

import java.util.List;

public class CACell extends findCell {
	private int stage;
	private int row;
	private int column;

	public CACell(int stage, int row, int column) {
		this.stage = stage;
		this.row = row;
		this.column = column;
		// TODO Auto-generated constructor stub
	}

	public int getStage() {
		return stage;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int NieghbourCounter(int row, int column, int stage, List<CACell> cellList) {
		int counter = 0;
		stage = stage - 1;
		if (row % 2 != 0) {
			if (findCell(row + 1, column + 1, cellList).getStage() <= stage
					&& findCell(row + 1, column + 1, cellList).getStage() > 0)
				counter++;
			if (findCell(row, column - 1, cellList).getStage() <= stage
					&& findCell(row, column - 1, cellList).getStage() > 0)
				counter++;
			if (findCell(row - 1, column, cellList).getStage() <= stage
					&& findCell(row - 1, column, cellList).getStage() > 0)
				counter++;
			if (findCell(row - 1, column + 1, cellList).getStage() <= stage
					&& findCell(row - 1, column + 1, cellList).getStage() > 0)
				counter++;
			if (findCell(row, column + 1, cellList).getStage() <= stage
					&& findCell(row, column + 1, cellList).getStage() > 0)
				counter++;
			if (findCell(row + 1, column, cellList).getStage() <= stage
					&& findCell(row + 1, column, cellList).getStage() > 0)
				counter++;
			return counter;
		} else {

			if (findCell(row + 1, column - 1, cellList).getStage() <= stage
					&& findCell(row + 1, column - 1, cellList).getStage() > 0)
				counter++;
			if (findCell(row, column + 1, cellList).getStage() <= stage
					&& findCell(row, column + 1, cellList).getStage() > 0)
				counter++;
			if (findCell(row - 1, column, cellList).getStage() <= stage
					&& findCell(row - 1, column, cellList).getStage() > 0)
				counter++;
			if (findCell(row - 1, column - 1, cellList).getStage() <= stage
					&& findCell(row - 1, column - 1, cellList).getStage() > 0)
				counter++;
			if (findCell(row, column - 1, cellList).getStage() <= stage
					&& findCell(row, column - 1, cellList).getStage() > 0)
				counter++;
			if (findCell(row + 1, column, cellList).getStage() <= stage
					&& findCell(row + 1, column, cellList).getStage() >0)
				counter++;
			//System.out.println(counter);
			return counter;
		}

	}
}

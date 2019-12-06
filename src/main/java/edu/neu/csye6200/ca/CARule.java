package edu.neu.csye6200.ca;

import java.util.List;

public class CARule extends findCell {

	public CARule() {

	}

	public List<CACell> CARule_1(int stage, int size, List<CACell> cellList) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (findCell(i, j, cellList).getStage() == stage - 1) {

					if (i % 2 != 0 && j % 2 == 0) { // odd

						if (findCell(i, j - 1, cellList).NieghbourCounter(i, j - 1, stage, cellList) == 1) {
							findCell(i, j - 1, cellList).setStage(stage);
						}
						if (findCell(i + 1, j + 1, cellList).NieghbourCounter(i + 1, j + 1, stage, cellList) == 1) {
							findCell(i + 1, j + 1, cellList).setStage(stage);
						}
						if (findCell(i - 1, j, cellList).NieghbourCounter(i - 1, j, stage, cellList) == 1) {
							findCell(i - 1, j, cellList).setStage(stage);
						}
						if (findCell(i - 1, j + 1, cellList).NieghbourCounter(i - 1, j + 1, stage, cellList) == 1) {
							findCell(i - 1, j + 1, cellList).setStage(stage);
						}
						if (findCell(i, j + 1, cellList).NieghbourCounter(i, j + 1, stage, cellList) == 1) {
							findCell(i, j + 1, cellList).setStage(stage);
						}
						if (findCell(i + 1, j, cellList).NieghbourCounter(i + 1, j, stage, cellList) == 1) {
							findCell(i + 1, j, cellList).setStage(stage);
						}
					} else {

						if (findCell(i, j - 1, cellList).NieghbourCounter(i, j - 1, stage, cellList) == 1) {
							findCell(i, j - 1, cellList).setStage(stage);
						}
						if (findCell(i + 1, j - 1, cellList).NieghbourCounter(i + 1, j - 1, stage, cellList) == 1) {
							findCell(i + 1, j - 1, cellList).setStage(stage);
						}
						if (findCell(i - 1, j, cellList).NieghbourCounter(i - 1, j, stage, cellList) == 1) {
							findCell(i - 1, j, cellList).setStage(stage);
						}
						if (findCell(i - 1, j - 1, cellList).NieghbourCounter(i - 1, j - 1, stage, cellList) == 1) {
							findCell(i - 1, j - 1, cellList).setStage(stage);
						}
						if (findCell(i, j + 1, cellList).NieghbourCounter(i, j + 1, stage, cellList) == 1) {
							findCell(i, j + 1, cellList).setStage(stage);
						}
						if (findCell(i + 1, j, cellList).NieghbourCounter(i + 1, j, stage, cellList) == 1) {
							findCell(i + 1, j, cellList).setStage(stage);
						}

					}

				}
			}
		}
		return cellList;

		// TODO Auto-generated constructor stub
	}
	public List<CACell> CARule_2 (int stage, int size, List<CACell> cellList) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (findCell(i, j, cellList).getStage() == stage - 1) {

					if (i % 2 != 0 ) { // odd

						if (findCell(i, j - 1, cellList).NieghbourCounter(i, j - 1, stage, cellList) == 1) {
							findCell(i, j - 1, cellList).setStage(stage);
						}
						if (findCell(i + 1, j + 1, cellList).NieghbourCounter(i + 1, j + 1, stage, cellList) == 1) {
							findCell(i + 1, j + 1, cellList).setStage(stage);
						}
						if (findCell(i - 1, j, cellList).NieghbourCounter(i - 1, j, stage, cellList) == 1) {
							findCell(i - 1, j, cellList).setStage(stage);
						}
						if (findCell(i - 1, j + 1, cellList).NieghbourCounter(i - 1, j + 1, stage, cellList) == 1) {
							findCell(i - 1, j + 1, cellList).setStage(stage);
						}
						if (findCell(i, j + 1, cellList).NieghbourCounter(i, j + 1, stage, cellList) == 1) {
							findCell(i, j + 1, cellList).setStage(stage);
						}
						if (findCell(i + 1, j, cellList).NieghbourCounter(i + 1, j, stage, cellList) == 1) {
							findCell(i + 1, j, cellList).setStage(stage);
						}
					} else {

						if (findCell(i, j - 1, cellList).NieghbourCounter(i, j - 1, stage, cellList) == 1) {
							findCell(i, j - 1, cellList).setStage(stage);
						}
						if (findCell(i + 1, j - 1, cellList).NieghbourCounter(i + 1, j - 1, stage, cellList) == 1) {
							findCell(i + 1, j - 1, cellList).setStage(stage);
						}
						if (findCell(i - 1, j, cellList).NieghbourCounter(i - 1, j, stage, cellList) == 1) {
							findCell(i - 1, j, cellList).setStage(stage);
						}
						if (findCell(i - 1, j - 1, cellList).NieghbourCounter(i - 1, j - 1, stage, cellList) == 1) {
							findCell(i - 1, j - 1, cellList).setStage(stage);
						}
						if (findCell(i, j + 1, cellList).NieghbourCounter(i, j + 1, stage, cellList) == 1) {
							findCell(i, j + 1, cellList).setStage(stage);
						}
						if (findCell(i + 1, j, cellList).NieghbourCounter(i + 1, j, stage, cellList) == 1) {
							findCell(i + 1, j, cellList).setStage(stage);
						}

					}

				}
			}
		}
		return cellList;

		// TODO Auto-generated constructor stub
	}public List<CACell> CARule_3(int stage, int size, List<CACell> cellList) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (findCell(i, j, cellList).getStage() == stage - 1) {

					if (i % 2 != 0 && j % 2 != 0) { // odd

						if (findCell(i, j - 1, cellList).NieghbourCounter(i, j - 1, stage, cellList) == 1) {
							findCell(i, j - 1, cellList).setStage(stage);
						}
						if (findCell(i + 1, j + 1, cellList).NieghbourCounter(i + 1, j + 1, stage, cellList) == 1) {
							findCell(i + 1, j + 1, cellList).setStage(stage);
						}
						if (findCell(i - 1, j, cellList).NieghbourCounter(i - 1, j, stage, cellList) == 1) {
							findCell(i - 1, j, cellList).setStage(stage);
						}
						if (findCell(i - 1, j + 1, cellList).NieghbourCounter(i - 1, j + 1, stage, cellList) == 1) {
							findCell(i - 1, j + 1, cellList).setStage(stage);
						}
						if (findCell(i, j + 1, cellList).NieghbourCounter(i, j + 1, stage, cellList) == 1) {
							findCell(i, j + 1, cellList).setStage(stage);
						}
						if (findCell(i + 1, j, cellList).NieghbourCounter(i + 1, j, stage, cellList) == 1) {
							findCell(i + 1, j, cellList).setStage(stage);
						}
					} else {

						if (findCell(i, j - 1, cellList).NieghbourCounter(i, j - 1, stage, cellList) == 1) {
							findCell(i, j - 1, cellList).setStage(stage);
						}
						if (findCell(i + 1, j - 1, cellList).NieghbourCounter(i + 1, j - 1, stage, cellList) == 1) {
							findCell(i + 1, j - 1, cellList).setStage(stage);
						}
						if (findCell(i - 1, j, cellList).NieghbourCounter(i - 1, j, stage, cellList) == 1) {
							findCell(i - 1, j, cellList).setStage(stage);
						}
						if (findCell(i - 1, j - 1, cellList).NieghbourCounter(i - 1, j - 1, stage, cellList) == 1) {
							findCell(i - 1, j - 1, cellList).setStage(stage);
						}
						if (findCell(i, j + 1, cellList).NieghbourCounter(i, j + 1, stage, cellList) == 1) {
							findCell(i, j + 1, cellList).setStage(stage);
						}
						if (findCell(i + 1, j, cellList).NieghbourCounter(i + 1, j, stage, cellList) == 1) {
							findCell(i + 1, j, cellList).setStage(stage);
						}

					}

				}
			}
		}
		return cellList;

		// TODO Auto-generated constructor stub
	}

}

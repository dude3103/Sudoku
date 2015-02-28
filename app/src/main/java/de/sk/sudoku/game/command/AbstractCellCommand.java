package de.sk.sudoku.game.command;

import de.sk.sudoku.game.CellCollection;

/**
 * Generic command acting on one or more cells.
 *
 */
public abstract class AbstractCellCommand extends AbstractCommand {

	private CellCollection mCells;

	protected CellCollection getCells() {
		return mCells;
	}

	protected void setCells(CellCollection mCells) {
		this.mCells = mCells;
	}

}

package de.sk.sudoku.gui.importing;

import de.sk.sudoku.db.SudokuInvalidFormatException;

/**
 * Handles import of puzzles via intent's extras.
 *

 */
public class ExtrasImportTask extends AbstractImportTask {

	private String mFolderName;
	private String mGames;
	private boolean mAppendToFolder;

	public ExtrasImportTask(String folderName, String games, boolean appendToFolder) {
		mFolderName = folderName;
		mGames = games;
		mAppendToFolder = appendToFolder;
	}

	@Override
	protected void processImport() throws SudokuInvalidFormatException {
		if (mAppendToFolder) {
			appendToFolder(mFolderName);
		} else {
			importFolder(mFolderName);
		}

		for (String game : mGames.split("\n")) {
			importGame(game);
		}
	}

}

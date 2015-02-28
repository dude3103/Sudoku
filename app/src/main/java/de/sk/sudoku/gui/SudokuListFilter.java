
package de.sk.sudoku.gui;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import de.sk.sudoku.R;
import de.sk.sudoku.utils.StringUtils;

public class SudokuListFilter {

	private Context mContext;

	public boolean showStateNotStarted = true;
	public boolean showStatePlaying = true;
	public boolean showStateCompleted = true;

	public SudokuListFilter(Context context) {
		mContext = context;
	}

	@Override
	public String toString() {
		List<String> visibleStates = new ArrayList<String>();
		if (showStateNotStarted) {
			visibleStates.add(mContext.getString(R.string.not_started));
		}
		if (showStatePlaying) {
			visibleStates.add(mContext.getString(R.string.playing));
		}
		if (showStateCompleted) {
			visibleStates.add(mContext.getString(R.string.solved));
		}
		return StringUtils.join(visibleStates, ",");
	}


}

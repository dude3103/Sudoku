

package de.sk.sudoku.gui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * This activity handles import of files with extension.
 * <p/>
 * It's sole purpose is to catch intents to view files with .sudoku
 * extension and forward it to the ImportSudokuList activity.
 * <p/>
 * I'm doing it this way, because I don't know how to add this kind of
 * intent filtering to the ImportSudokuList activity.
 *
 */
public class FileImportActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Intent i = new Intent(this, ImportSudokuActivity.class);
		i.setData(getIntent().getData());
		startActivity(i);
		finish();
	}

}

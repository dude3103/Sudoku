
package de.sk.sudoku.gui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * This activity is here to keep backward compatibility, use {@link SudokuImportActivity} instead.
 *
 */
public class ImportSudokuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Intent intent = new Intent(getIntent());
		intent.setClass(this, SudokuImportActivity.class);
		startActivity(intent);
		finish();
	}

}

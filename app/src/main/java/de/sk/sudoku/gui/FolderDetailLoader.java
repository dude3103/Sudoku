
package de.sk.sudoku.gui;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import de.sk.sudoku.db.SudokuDatabase;
import de.sk.sudoku.game.FolderInfo;

/**
 * Loads details of given folders on one single background thread.
 * Results are published on GUI thread via {@link FolderDetailCallback} interface.
 * <p/>
 * Please note that instance of this class has to be created on GUI thread!
 * <p/>
 * You should explicitly call {@link #destroy()} when this object is no longer needed.
 *
 */
public class FolderDetailLoader {

	private static final String TAG = "FolderDetailLoader";

	private Context mContext;
	private SudokuDatabase mDatabase;
	private Handler mGuiHandler;
	private ExecutorService mLoaderService = Executors.newSingleThreadExecutor();

	public FolderDetailLoader(Context context) {
		mContext = context;
		mDatabase = new SudokuDatabase(mContext);
		mGuiHandler = new Handler();
	}

	public void loadDetailAsync(long folderID, FolderDetailCallback loadedCallback) {
		final long folderIDFinal = folderID;
		final FolderDetailCallback loadedCallbackFinal = loadedCallback;
		mLoaderService.execute(new Runnable() {
			@Override
			public void run() {
				try {
					final FolderInfo folderInfo = mDatabase.getFolderInfoFull(folderIDFinal);

					mGuiHandler.post(new Runnable() {
						@Override
						public void run() {
							loadedCallbackFinal.onLoaded(folderInfo);
						}
					});
				} catch (Exception e) {
					// this is some unimportant background stuff, do not fail
					Log.e(TAG, "Error occured while loading full folder info.", e);
				}
			}
		});
	}

	public void destroy() {
		mLoaderService.shutdownNow();
		mDatabase.close();
	}

	public interface FolderDetailCallback {
		void onLoaded(FolderInfo folderInfo);
	}
}

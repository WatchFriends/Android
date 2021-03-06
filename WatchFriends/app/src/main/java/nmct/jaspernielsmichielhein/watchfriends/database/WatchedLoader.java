package nmct.jaspernielsmichielhein.watchfriends.database;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.database.Cursor;

public class WatchedLoader extends AsyncTaskLoader<Cursor> {

    private Cursor mData;
    private Context mContext;

    public WatchedLoader(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    protected void onStartLoading() {
        if (mData != null) {
            deliverResult(mData);
        }


        if (takeContentChanged() || mData == null) {
            forceLoad();
        }
    }

    @Override
    public Cursor loadInBackground() {
        String[] columns = new String[]{
                Contract.WatchedEpisodeColumns._ID,
                Contract.WatchedEpisodeColumns.COLUMN_WATCHED_SERIES_NR,
                Contract.WatchedEpisodeColumns.COLUMN_WATCHED_SEASON_NR,
                Contract.WatchedEpisodeColumns.COLUMN_WATCHED_EPISODE_NR
        };

        mData = mContext.getContentResolver().query(nmct.jaspernielsmichielhein.watchfriends.provider.Contract.WATCHED_URI, columns, null, null, null);

        mData.getCount();

        return mData;
    }

    @Override
    public void deliverResult(Cursor cursor) {
        if (isReset()) {
            if (cursor != null) {
                cursor.close();
            }
            return;
        }

        Cursor oldData = mData;
        mData = cursor;

        if (isStarted()) {
            super.deliverResult(cursor);
        }

        if (oldData != null && oldData != cursor && !oldData.isClosed()) {
            oldData.close();
        }
    }

    @Override
    protected void onStopLoading() {
        cancelLoad();
    }

    @Override
    public void onCanceled(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }
}

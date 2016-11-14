package nmct.jaspernielsmichielhein.watchfriends.binder;

import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.RecyclerView;

import nmct.jaspernielsmichielhein.watchfriends.adapter.SeriesListAdapter;
import nmct.jaspernielsmichielhein.watchfriends.model.SeriesList;

public class SeriesListBinder {

    @BindingAdapter("items")
    public static void setSeriesList(RecyclerView recyclerView, ObservableArrayList<SeriesList> seriesLists) {
        SeriesListAdapter seriesListAdapter = new SeriesListAdapter(seriesLists, recyclerView.getContext());
        recyclerView.setAdapter(seriesListAdapter);
        seriesListAdapter.notifyDataSetChanged();
    }
}

package nmct.jaspernielsmichielhein.watchfriends.helper;

import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.widget.ImageView;

import nmct.jaspernielsmichielhein.watchfriends.model.Episode;
import nmct.jaspernielsmichielhein.watchfriends.model.Series;

public class Interfaces {
    public interface headerChangedListener {
        void collapseToolbar();
        void expandToolbar();
        ImageView getHeaderImage();
        FloatingActionButton getActionButton();
        void setTitle(String title);
    }

    public interface onSeriesSelectedListener {
        void onSeriesSelected(Series series);
    }

    public interface onSeasonSelectedListener {
        void onSeasonSelected(String seriesName, int seriesId, int seasonNumber);
    }

    public interface onEpisodeSelectedListener {
        void onEpisodeSelected(Episode episode);
    }

    public interface onAccountRegisteredListener {
        void onAccountRegistered(String mUsername);
    }
}
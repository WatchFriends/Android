package nmct.jaspernielsmichielhein.watchfriends.model;

import android.databinding.BaseObservable;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import nmct.jaspernielsmichielhein.watchfriends.helper.Contract;
import nmct.jaspernielsmichielhein.watchfriends.helper.SeriesHelper;

public class Episode extends BaseObservable implements Parcelable {
    private String air_date = "";
    private int episode_number = 0;
    private String name = "";
    private String overview = "";
    private int id = 0;
    private Uri image_uri;
    private String production_code = "";
    private float rating = 0;
    private int season_number = 0;
    private String shortcode = "";
    private String still_path = "";
    private float vote_average = 0;
    private int vote_count = 0;

    public String getAir_date() {
        if (air_date == null || air_date.equals("")) {
            return "Not available";
        }
        return air_date;
    }

    public void setAir_date(String air_date) {
        this.air_date = air_date;
    }

    public int getEpisode_number() {
        return episode_number;
    }

    public void setEpisode_number(int episode_number) {
        this.episode_number = episode_number;
    }

    public String getName() {
        if (name.equals("")) {
            return getShortcode();
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverview() {
        if (overview.equals("")) {
            return "Not available";
        }
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Uri getImage_uri() {
        return image_uri;
    }

    public void setImage_uri(Uri image_uri) {
        this.image_uri = image_uri;
    }

    public String getProduction_code() {
        return production_code;
    }

    public void setProduction_code(String production_code) {
        this.production_code = production_code;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getSeason_number() {
        return season_number;
    }

    public void setSeason_number(int season_number) {
        this.season_number = season_number;
    }

    public String getShortcode() {
        return shortcode;
    }

    public void setShortcode(String shortcode) {
        this.shortcode = shortcode;
    }

    public String getStill_path() {
        return still_path;
    }

    public void setStill_path(String still_path) {
        this.still_path = still_path;
    }

    public float getVote_average() {
        return vote_average;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public void initExtraFields() {
        makeImage_uri();
        makeShortcode();
        setRating((float) getVote_average() / 2);
    }

    private void makeImage_uri() {
        setImage_uri(Uri.parse(Contract.MOVIEDB_IMAGE_BASE_URL + getStill_path()));
    }

    private void makeShortcode() {
        setShortcode(SeriesHelper.getShortcode(this.getSeason_number(), this.getEpisode_number()));
    }

    // PARCELABLE
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.getAir_date());
        dest.writeInt(this.getEpisode_number());
        dest.writeString(this.getName());
        dest.writeString(this.getOverview());
        dest.writeInt(this.getId());
        dest.writeString(this.getProduction_code());
        dest.writeInt(this.getSeason_number());
        dest.writeString(this.getStill_path());
        dest.writeFloat(this.getVote_average());
        dest.writeInt(this.getVote_count());
    }

    public static final Creator<Episode> CREATOR = new Creator<Episode>() {
        @Override
        public Episode createFromParcel(Parcel in) {
            return new Episode(in);
        }

        @Override
        public Episode[] newArray(int size) {
            return new Episode[size];
        }
    };

    protected Episode(Parcel in) {
        setAir_date(in.readString());
        setEpisode_number(in.readInt());
        setName(in.readString());
        setOverview(in.readString());
        setId(in.readInt());
        setProduction_code(in.readString());
        setSeason_number(in.readInt());
        setStill_path(in.readString());
        setVote_average(in.readFloat());
        setVote_count(in.readInt());
    }
}
package yonsei.xdesign.tochelin.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Stat implements Parcelable {

    public String kind;
    public double score;
    public String[] keywords;
    public Review[] reviews;

    public Stat(String kind, double score, String[] keywords, Review[] reviews) {
        this.kind = kind;
        this.score = score;
        this.keywords = keywords;
        this.reviews = reviews;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.kind);
        dest.writeDouble(this.score);
        dest.writeStringArray(this.keywords);
        dest.writeTypedArray(this.reviews, flags);
    }

    protected Stat(Parcel in) {
        this.kind = in.readString();
        this.score = in.readDouble();
        this.keywords = in.createStringArray();
        this.reviews = in.createTypedArray(Review.CREATOR);
    }

    public static final Parcelable.Creator<Stat> CREATOR = new Parcelable.Creator<Stat>() {
        @Override
        public Stat createFromParcel(Parcel source) {
            return new Stat(source);
        }

        @Override
        public Stat[] newArray(int size) {
            return new Stat[size];
        }
    };
}

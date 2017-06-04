package yonsei.xdesign.tochelin.models;

import android.os.Parcelable;

public class Restaurant implements Parcelable {
    /*
        1. title
        2. location
        3. category
        4. reviewCount
        5. keywords
        6. score
    */
    public String id;
    public String title;
    public String location;
    public String category;
    public int reviewCount;
    public String[] keywords;
    public String score;
    public String imageUrl;
    public Stat[] stats;

    public Restaurant(String id, String title, String location, String category, int reviewCount,
                      String[] keywords, String score, String imageUrl, Stat[] stats) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.category = category;
        this.reviewCount = reviewCount;
        this.keywords = keywords;
        this.score = score;
        this.imageUrl = imageUrl;
        this.stats = stats;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.title);
        dest.writeString(this.location);
        dest.writeString(this.category);
        dest.writeInt(this.reviewCount);
        dest.writeStringArray(this.keywords);
        dest.writeString(this.score);
        dest.writeString(this.imageUrl);
        dest.writeTypedArray(this.stats, flags);
    }

    protected Restaurant(android.os.Parcel in) {
        this.id = in.readString();
        this.title = in.readString();
        this.location = in.readString();
        this.category = in.readString();
        this.reviewCount = in.readInt();
        this.keywords = in.createStringArray();
        this.score = in.readString();
        this.imageUrl = in.readString();
        this.stats = in.createTypedArray(Stat.CREATOR);
    }

    public static final Parcelable.Creator<Restaurant> CREATOR = new Parcelable.Creator<Restaurant>() {
        @Override
        public Restaurant createFromParcel(android.os.Parcel source) {
            return new Restaurant(source);
        }

        @Override
        public Restaurant[] newArray(int size) {
            return new Restaurant[size];
        }
    };
}

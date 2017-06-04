package yonsei.xdesign.tochelin.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Review implements Parcelable {

    public String id;
    public String name;
    public String date;
    public String content;
    public String thumbnailImageUrl;
    public String[] imageUrls;

    public Review(String id, String name, String date, String content, String thumbnailImageUrl,
                  String[] imageUrls) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.content = content;
        this.thumbnailImageUrl = thumbnailImageUrl;
        this.imageUrls = imageUrls;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.date);
        dest.writeString(this.content);
        dest.writeString(this.thumbnailImageUrl);
        dest.writeStringArray(this.imageUrls);
    }

    protected Review(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.date = in.readString();
        this.content = in.readString();
        this.thumbnailImageUrl = in.readString();
        this.imageUrls = in.createStringArray();
    }

    public static final Parcelable.Creator<Review> CREATOR = new Parcelable.Creator<Review>() {
        @Override
        public Review createFromParcel(Parcel source) {
            return new Review(source);
        }

        @Override
        public Review[] newArray(int size) {
            return new Review[size];
        }
    };
}

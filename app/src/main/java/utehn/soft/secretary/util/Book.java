package utehn.soft.secretary.util;

import android.os.Parcel;
import android.os.Parcelable;


public class Book implements Parcelable {
    int id;
    String name;
    double price;
    boolean stock;

    public Book() {
    }


    public Book(int id, String name, double price, boolean stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isStock() {
        return stock;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeDouble(this.price);
        dest.writeByte(stock ? (byte) 1 : (byte) 0);
    }


    protected Book(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.price = in.readDouble();
        this.stock = in.readByte() != 0;
    }

    public static final Parcelable.Creator<Book> CREATOR = new Parcelable.Creator<Book>() {
        public Book createFromParcel(Parcel source) {
            return new Book(source);
        }

        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
}

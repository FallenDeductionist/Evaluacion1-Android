package com.fallendeductionist.evaluacion1;

import android.os.Parcel;
import android.os.Parcelable;

public class ExampleEmployee implements Parcelable{

    private int mImageResource;
    private String mText1;
    private String mText2;
    private String mText3;
    private String mText4;
    private String mText5;

    public ExampleEmployee(int imageResource, String text1, String text2, String text3, String text4, String text5){
        mImageResource = imageResource;
        mText1 = text1;
        mText2 = text2;
        mText3 = text3;
        mText4 = text4;
        mText5 = text5;
    }



    protected ExampleEmployee(Parcel in) {
        mImageResource = in.readInt();
        mText1 = in.readString();
        mText2 = in.readString();
        mText3 = in.readString();
        mText4 = in.readString();
        mText5 = in.readString();
    }

    public static final Creator<ExampleEmployee> CREATOR = new Creator<ExampleEmployee>() {
        @Override
        public ExampleEmployee createFromParcel(Parcel in) {
            return new ExampleEmployee(in);
        }

        @Override
        public ExampleEmployee[] newArray(int size) {
            return new ExampleEmployee[size];
        }
    };

    public int getImageResource() {
        return mImageResource;
    }

    public String getText1() {
        return mText1;
    }

    public String getText2() { return mText2; }

    public String getText3() { return mText3; }

    public String getText4() { return mText4; }

    public String getText5() { return mText5; }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mImageResource);
        dest.writeString(mText1);
        dest.writeString(mText2);
        dest.writeString(mText3);
        dest.writeString(mText4);
        dest.writeString(mText5);
    }
}

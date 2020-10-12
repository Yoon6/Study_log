package com.example.sampleparcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class SimpleData implements Parcelable {
    int number;
    String message;

    public SimpleData(int num, String msg){
        number = num;
        message = msg;
    }

    public SimpleData(Parcel src){ // parcel 객체에서 읽기
        number = src.readInt();
        message = src.readString();
    }

    public static final Creator CREATOR = new Creator() { // CREATOR 정의
        @Override
        public Object createFromParcel(Parcel source) {
            return new SimpleData(source); // SimpleData 생성자 호출해서 Parcel 객체에서 읽기
        }
        @Override
        public Object[] newArray(int size) {
            return new SimpleData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) { // parcel 객체로 쓰기
        dest.writeInt(number);
        dest.writeString(message);
    }
}

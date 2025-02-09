package com.example.peaceble;

import android.os.Parcel;
import android.os.Parcelable;

public class person implements Parcelable {
    private String name;
    private Integer age;
    private String email;
    private String city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeValue(this.age);
        dest.writeString(this.email);
        dest.writeString(this.city);
    }

    public person() {
    }

    protected person(Parcel in) {
        this.name = in.readString();
        this.age = (Integer) in.readValue(Integer.class.getClassLoader());
        this.email = in.readString();
        this.city = in.readString();
    }

    public static final Parcelable.Creator<person> CREATOR = new Parcelable.Creator<person>() {
        @Override
        public person createFromParcel(Parcel source) {
            return new person(source);
        }

        @Override
        public person[] newArray(int size) {
            return new person[size];
        }
    };
}

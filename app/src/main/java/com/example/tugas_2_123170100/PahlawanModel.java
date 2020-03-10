package com.example.tugas_2_123170100;

import android.os.Parcel;
import android.os.Parcelable;

public class PahlawanModel implements Parcelable {

    private String heroName, heroDesc;
    private int heroImage;

    public PahlawanModel() { }

    protected PahlawanModel(Parcel in) {
        heroName = in.readString();
        heroDesc = in.readString();
        heroImage = in.readInt();
    }

    public static final Creator<PahlawanModel> CREATOR = new Creator<PahlawanModel>() {
        @Override
        public PahlawanModel createFromParcel(Parcel in) {
            return new PahlawanModel(in);
        }

        @Override
        public PahlawanModel[] newArray(int size) {
            return new PahlawanModel[size];
        }
    };

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getHeroDesc() {
        return heroDesc;
    }

    public void setHeroDesc(String heroDesc) {
        this.heroDesc = heroDesc;
    }

    public int getHeroImage() {
        return heroImage;
    }

    public void setHeroImage(int heroImage) {
        this.heroImage = heroImage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(heroName);
        dest.writeString(heroDesc);
        dest.writeInt(heroImage);
    }
}

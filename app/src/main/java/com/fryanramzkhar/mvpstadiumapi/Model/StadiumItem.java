package com.fryanramzkhar.mvpstadiumapi.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "stadium")
public class StadiumItem implements Serializable {

    @PrimaryKey
    @ColumnInfo(name = "idTeam")
    @SerializedName("idTeam")
    @NonNull private String idStadium;

    @ColumnInfo(name = "strStadium")
    @SerializedName("strStadium")
    private String strStadium;

    @ColumnInfo(name = "strStadiumThumb")
    @SerializedName("strStadiumThumb")
    private String strImageStadium;

    @ColumnInfo(name = "strStadiumDescription")
    @SerializedName("strStadiumDescription")
    private String strStadiumDescription;

    public StadiumItem(@NonNull String idStadium, String strStadium, String strImageStadium, String strStadiumDescription) {
        this.idStadium = idStadium;
        this.strStadium = strStadium;
        this.strImageStadium = strImageStadium;
        this.strStadiumDescription = strStadiumDescription;
    }

    public String getStrStadiumDescription() {
        return strStadiumDescription;
    }

    public String getIdStadium() {
        return idStadium;
    }

    public void setIdStadium(String idStadium) {
        this.idStadium = idStadium;
    }

    public String getStrStadium() {
        return strStadium;
    }

    public void setStrStadium(String strStadium) {
        this.strStadium = strStadium;
    }

    public String getStrImageStadium() {
        return strImageStadium;
    }

    public void setStrImageStadium(String strImageStadium) {
        this.strImageStadium = strImageStadium;
    }

    public void setStrStadiumDescription(String strStadiumDescription) {
        this.strStadiumDescription = strStadiumDescription;
    }
}

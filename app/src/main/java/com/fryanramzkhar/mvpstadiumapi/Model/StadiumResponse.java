package com.fryanramzkhar.mvpstadiumapi.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StadiumResponse {

    @SerializedName("teams")
    List<StadiumItem> stadiumDataList;

    public List<StadiumItem> getStadiumDataList() {
        return stadiumDataList;
    }

    public void setStadiumDataList(List<StadiumItem> stadiumDataList) {
        this.stadiumDataList = stadiumDataList;
    }
}

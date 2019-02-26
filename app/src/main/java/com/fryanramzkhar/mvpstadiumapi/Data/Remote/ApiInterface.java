package com.fryanramzkhar.mvpstadiumapi.Data.Remote;

import com.fryanramzkhar.mvpstadiumapi.Model.StadiumResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/api/v1/json/1/search_all_teams.php")
    Call<StadiumResponse> stadium(@Query("l") String stadiumName);

    @GET("/api/v1/json/1/lookupteam.php?id=133604")
    Call<StadiumResponse> detail(@Query("id") int StadiumDetail);
}

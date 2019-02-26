package com.fryanramzkhar.mvpstadiumapi.UI.Stadium;

import com.fryanramzkhar.mvpstadiumapi.Data.Remote.ApiClient;
import com.fryanramzkhar.mvpstadiumapi.Data.Remote.ApiInterface;
import com.fryanramzkhar.mvpstadiumapi.Model.StadiumItem;
import com.fryanramzkhar.mvpstadiumapi.Model.StadiumResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StadiumPresenter implements StadiumContract.Presenter{

    private final StadiumContract.View view;
    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    public StadiumPresenter(StadiumContract.View view) {
        this.view = view;
    }

    @Override
    public void getDataListStadium() {
        view.showProgress();
        Call<StadiumResponse> call = apiInterface.stadium("English Premier League");
        call.enqueue(new Callback<StadiumResponse>() {
            @Override
            public void onResponse(Call<StadiumResponse> call, Response<StadiumResponse> response) {
                view.hideProgress();
                if (response.body() != null){
                    view.showDataListStadium(response.body().getStadiumDataList());
                }else {
                    view.showFailureMessage("Data kosong brooo!");
                }
            }

            @Override
            public void onFailure(Call<StadiumResponse> call, Throwable t) {
                view.showFailureMessage(t.getMessage());
                view.hideProgress();
            }
        });
    }
}

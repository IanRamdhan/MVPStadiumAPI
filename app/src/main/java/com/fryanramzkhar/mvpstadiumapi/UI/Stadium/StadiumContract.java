package com.fryanramzkhar.mvpstadiumapi.UI.Stadium;

import android.app.ProgressDialog;

import com.fryanramzkhar.mvpstadiumapi.Model.StadiumItem;

import java.util.List;

public interface StadiumContract {

    interface View{
        void showProgress();
        void hideProgress();
        void showDataListStadium(List<StadiumItem> stadiumItemList);
        void showFailureMessage(String msg);
    }

    interface Presenter{
        void getDataListStadium();
    }
}

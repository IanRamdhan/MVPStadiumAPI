package com.fryanramzkhar.mvpstadiumapi.UI.Detail;

import android.content.Context;
import android.os.Bundle;

import com.fryanramzkhar.mvpstadiumapi.Model.StadiumItem;

public interface DetailContract {

    interface View{
        void showDetailStadium(StadiumItem stadiumItem);
        void showFailureMessage(String msg);
        void showSuccessMessage(String msg);
    }

    interface Presenter{
        void getDetailStadium(Bundle bundle);
        void addToFavorite(Context context, StadiumItem stadiumItem);
        void removeFavorite(Context context, StadiumItem stadiumItem);
        Boolean checkFavorite(Context context, StadiumItem stadiumItem);
    }
}

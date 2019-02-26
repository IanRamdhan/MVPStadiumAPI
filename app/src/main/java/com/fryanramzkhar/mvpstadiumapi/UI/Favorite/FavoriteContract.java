package com.fryanramzkhar.mvpstadiumapi.UI.Favorite;

import android.content.Context;

import com.fryanramzkhar.mvpstadiumapi.Model.StadiumItem;

import java.util.List;

public interface FavoriteContract {

    interface View{
        void showDataList(List<StadiumItem> stadiumItemList);
        void showFailureMessage(String msg);
        void hideRefresh();
    }

    interface Presenter{
        void getDataListItems(Context context);
    }
}

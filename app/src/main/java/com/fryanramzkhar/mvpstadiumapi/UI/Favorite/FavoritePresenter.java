package com.fryanramzkhar.mvpstadiumapi.UI.Favorite;

import android.content.Context;

import com.fryanramzkhar.mvpstadiumapi.Data.Local.FootballDatabase;

public class FavoritePresenter implements FavoriteContract.Presenter {

    private final FavoriteContract.View view;
    private FootballDatabase footballDatabase;

    public FavoritePresenter(FavoriteContract.View view) {
        this.view = view;
    }

    @Override
    public void getDataListItems(Context context) {
        footballDatabase = FootballDatabase.getFootballDatabase(context);
        if (footballDatabase.footballDao().selectFavorite() != null) {
            view.showDataList(footballDatabase.footballDao().selectFavorite());
        }else {
            view.showFailureMessage("Tidak ada data di Favorite");
        }

        view.hideRefresh();

    }
}
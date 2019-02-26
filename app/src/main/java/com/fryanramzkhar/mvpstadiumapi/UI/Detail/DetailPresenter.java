package com.fryanramzkhar.mvpstadiumapi.UI.Detail;

import android.content.Context;
import android.os.Bundle;

import com.fryanramzkhar.mvpstadiumapi.Data.Local.FootballDatabase;
import com.fryanramzkhar.mvpstadiumapi.Model.StadiumItem;
import com.fryanramzkhar.mvpstadiumapi.Utils.Constant;

public class DetailPresenter implements DetailContract.Presenter {

    private final DetailContract.View view;
    private FootballDatabase footballDatabase;

    public DetailPresenter(DetailContract.View view) {
        this.view = view;
    }

    @Override
    public void getDetailStadium(Bundle bundle) {
        if (bundle != null){
            StadiumItem stadiumItem = (StadiumItem) bundle.getSerializable(Constant.KEY_DATA);
            view.showDetailStadium(stadiumItem);
        }else {
            view.showFailureMessage("Data Kosong...");
        }
    }

    @Override
    public void addToFavorite(Context context, StadiumItem stadiumItem) {
        footballDatabase = FootballDatabase.getFootballDatabase(context);
        footballDatabase.footballDao().insertItem(stadiumItem);
        view.showSuccessMessage("Tersimpan...");

    }

    @Override
    public void removeFavorite(Context context, StadiumItem stadiumItem) {
        footballDatabase = FootballDatabase.getFootballDatabase(context);
        footballDatabase.footballDao().delete(stadiumItem);
        view.showSuccessMessage("Terhapus...");
    }

    @Override
    public Boolean checkFavorite(Context context, StadiumItem stadiumItem) {
        Boolean bFavorite = false;
        footballDatabase = FootballDatabase.getFootballDatabase(context);
        return bFavorite = footballDatabase.footballDao().selectedItem(stadiumItem.getIdStadium()) !=null;
    }
}

package com.fryanramzkhar.mvpstadiumapi.Data.Local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.fryanramzkhar.mvpstadiumapi.Model.StadiumItem;

import java.util.List;

@Dao
public interface FootballDao {

    @Insert
    void insertItem(StadiumItem stadiumItem);

    @Query("SELECT * FROM stadium WHERE idTeam = :id")
    StadiumItem selectedItem(String id);

    @Delete
    void delete(StadiumItem stadiumItem);

    @Query("SELECT * FROM stadium ORDER BY strStadium ASC")
    List<StadiumItem> selectFavorite();
}

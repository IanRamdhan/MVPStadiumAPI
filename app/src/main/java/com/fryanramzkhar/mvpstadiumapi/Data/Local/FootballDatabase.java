package com.fryanramzkhar.mvpstadiumapi.Data.Local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.fryanramzkhar.mvpstadiumapi.Model.StadiumItem;

@Database(entities = StadiumItem.class, version = 1)
public abstract class FootballDatabase extends RoomDatabase {

    public abstract FootballDao footballDao();
    private static FootballDatabase footballDatabase;

    public static FootballDatabase getFootballDatabase(Context context){
        synchronized (FootballDatabase.class){
            if (footballDatabase == null){
                footballDatabase = Room.databaseBuilder(context, FootballDatabase.class, "db_football")
                        .allowMainThreadQueries().build();
            }
        }return footballDatabase;

        }
    }



package com.example.film.SqlHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.film.model.Film;

import java.util.ArrayList;
import java.util.List;

import static com.example.film.Util.Util.COUNT_DISLIKE;
import static com.example.film.Util.Util.COUNT_LIKE;
import static com.example.film.Util.Util.COUNT_SEEN;
import static com.example.film.Util.Util.DATE;
import static com.example.film.Util.Util.DESCRIPTION;
import static com.example.film.Util.Util.DURATION;
import static com.example.film.Util.Util.ID_FILM;
import static com.example.film.Util.Util.ID_PLAYLIST;
import static com.example.film.Util.Util.NAME;

public class SqlHelper extends SQLiteOpenHelper {
    static final String DB_NAME = "NEWFILM.db";
    static final String DB_TABLE_ALL_FILM = "AllFilm";
    static final String DB_TABLE_HISTORY = "LichSu";
    static final String DB_TABLE_XEM_SAU = "XemSau";
    static final String DB_TABLE_ACCOUNT = "Account";
    static final int DB_VERSION = 1;
    SQLiteDatabase sqLiteDatabase;
    ContentValues contentValues;

    public SqlHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCreateTableAllfilm = "CREATE TABLE " + DB_TABLE_ALL_FILM + "(" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "name Text," +
                "idFilm Text," +
                "idPlaylist Text," +
                "duration Text," +
                "date Text," +
                "countLike INTEGER," +
                "countDisLike INTEGER," +
                "countSeen INTEGER," +
                "description Text)";
        db.execSQL(queryCreateTableAllfilm);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + DB_NAME);
            onCreate(db);
        }
    }


    public void InsertFilmToAllFilm(Film video) {
        sqLiteDatabase = getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put(NAME, video.getName());
        contentValues.put(ID_FILM, video.getIdFilm());
        contentValues.put(ID_PLAYLIST, video.getIdPlaylist());
        contentValues.put(DURATION, video.getDuration());
        contentValues.put(DATE, video.getDate());
        contentValues.put(COUNT_LIKE, video.getCountLike());
        contentValues.put(COUNT_DISLIKE, video.getCountDisLike());
        contentValues.put(COUNT_SEEN, video.getCountSeen());
        contentValues.put(DESCRIPTION, video.getDescription());
        sqLiteDatabase.insert(DB_TABLE_ALL_FILM, null, contentValues);
    }

    public List<Film> getAllFilm() {
        List<Film> list = new ArrayList<>();
        sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(false, DB_TABLE_ALL_FILM,
                null,
                null,
                null,
                null,
                null,
                null,
                null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex(NAME));
            String idfilm = cursor.getString(cursor.getColumnIndex(ID_FILM));
            String idtplaylis = cursor.getString(cursor.getColumnIndex(ID_PLAYLIST));
            String duration = cursor.getString(cursor.getColumnIndex(DURATION));
            String date = cursor.getString(cursor.getColumnIndex(DATE));
            String countlike = cursor.getString(cursor.getColumnIndex(COUNT_LIKE));
            String countdislike = cursor.getString(cursor.getColumnIndex(COUNT_DISLIKE));
            String countseen = cursor.getString(cursor.getColumnIndex(COUNT_SEEN));
            String description = cursor.getString(cursor.getColumnIndex(DESCRIPTION));
            list.add(new Film(id, name, idfilm, idtplaylis, duration, date, countlike, countdislike, countseen, description));
        }
        return list;
    }
}

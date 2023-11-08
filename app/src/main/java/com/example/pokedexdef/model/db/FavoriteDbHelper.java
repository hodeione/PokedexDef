package com.example.pokedexdef.model.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FavoriteDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "favorites.db";
    private static final int DATABASE_VERSION = 1;

    public FavoriteDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crea la tabla de favoritos
        db.execSQL(
                "CREATE TABLE favorites (" +
                        "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "pokemon_id INTEGER UNIQUE NOT NULL, " +
                        "name TEXT NOT NULL, " +
                        "type TEXT, " +
                        "image_url TEXT, " +
                        "is_favorite INTEGER DEFAULT 0)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Puedes implementar lógica de actualización de la base de datos si es necesario
    }
}

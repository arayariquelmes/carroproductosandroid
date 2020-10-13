package cl.inacap.carroproductos.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import cl.inacap.carroproductos.dto.Producto;

public class ProductosSQLiteHelper extends SQLiteOpenHelper {
    String sqlCreate = "CREATE TABLE productos(codigo INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
            "valor INTEGER, nombre TEXT,foto TEXT, descripcion TEXT)";
    public ProductosSQLiteHelper(@Nullable Context context, @Nullable String name
            , @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sqlCreate);
        //Creamos algunos registros por defecto
        sqLiteDatabase.execSQL(
                "INSERT INTO productos(valor,nombre,foto,descripcion) VALUES(" +
                "1000" +
                        ",'Coca cola zero'" +
                        ", 'https://jumbo.vteximg.com.br/arquivos/ids/336745/Principal-3942.jpg?v=637237316746070000'" +
                        ", 'Descripcion pulenta')");
        sqLiteDatabase.execSQL(
                "INSERT INTO productos(valor,nombre,foto,descripcion) VALUES(" +
                        "1000" +
                        ",'Coca cola zero'" +
                        ", 'https://jumbo.vteximg.com.br/arquivos/ids/336745/Principal-3942.jpg?v=637237316746070000'" +
                        ", 'Descripcion pulenta')");
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS productos");
        sqLiteDatabase.execSQL(sqlCreate);
    }
}

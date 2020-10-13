package cl.inacap.carroproductos.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.carroproductos.dto.Producto;
import cl.inacap.carroproductos.helpers.ProductosSQLiteHelper;

public class ProductosDAOSQLite implements ProductosDAO {

    private ProductosSQLiteHelper db;

    public ProductosDAOSQLite(Context context){
        this.db = new ProductosSQLiteHelper(context, "DBProductos", null, 1);
    }

    @Override
    public List<Producto> getAll() {
        List<Producto> productos = new ArrayList<>();
        SQLiteDatabase dbProd = this.db.getReadableDatabase();
        if(db != null){
            Cursor c = dbProd.rawQuery("SELECT codigo, valor, nombre, foto, descripcion "
            + "FROM productos", null);
            if(c.moveToFirst()){
                do{
                   Producto p = new Producto();
                   p.setCodigo(c.getInt(0));
                   p.setValor(c.getInt(1));
                   p.setNombre(c.getString(2));
                   p.setFoto(c.getString(3));
                   p.setDescripcion(c.getString(4));
                   productos.add(p);
                }while(c.moveToNext());
            }
        }
        db.close();

        return productos;
    }

    @Override
    public Producto save(Producto prod) {
        SQLiteDatabase writer = this.db.getWritableDatabase();
        writer.execSQL(String.format("INSERT into productos(valor,nombre,foto,descripcion)" +
                " VALUES(%d,'%s','%s','%s')",prod.getValor()
                        , prod.getNombre(),prod.getFoto(), prod.getDescripcion()));

        writer.close();
        return prod;
    }
}

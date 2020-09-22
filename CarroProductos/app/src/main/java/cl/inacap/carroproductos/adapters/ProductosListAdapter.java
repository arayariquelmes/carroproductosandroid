package cl.inacap.carroproductos.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.List;

import cl.inacap.carroproductos.R;
import cl.inacap.carroproductos.dto.Producto;

public class ProductosListAdapter extends ArrayAdapter<Producto> {
    private List<Producto> productos;
    private final Activity activity;
    public ProductosListAdapter(@NonNull Activity context, int resource, @NonNull List<Producto> objects) {
        super(context, resource, objects);
        this.activity = context;
        this.productos = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.activity.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_productos,null, true);
        TextView nombreProd = rowView.findViewById(R.id.nombreProdTv);
        ImageView imagenProd = rowView.findViewById(R.id.imagenProdIv);
        nombreProd.setText(this.productos.get(position).getNombre());
        Picasso.get().load(this.productos.get(position)
                .getFoto())
                .resize(300,300)
                .centerCrop()
                .into(imagenProd);
        return rowView;
    }
}

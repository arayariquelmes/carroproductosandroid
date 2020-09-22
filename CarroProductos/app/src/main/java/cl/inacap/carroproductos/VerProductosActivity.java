package cl.inacap.carroproductos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import cl.inacap.carroproductos.dto.Producto;

public class VerProductosActivity extends AppCompatActivity {

    private Producto prod;
    private TextView nombreProdTv;
    private ImageView imagenProdTv;
    private TextView descripcionProdTv;

    private TextView valorProdTv;
    private TextView tituloToolbar;
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_productos);
        this.setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        this.tituloToolbar = findViewById(R.id.tituloToolbar);
        if(getIntent().getExtras() != null){

            this.prod = (Producto) getIntent().getSerializableExtra("producto");
            this.nombreProdTv = findViewById(R.id.nombreProdViewTv);
            this.tituloToolbar.setText(this.prod.getNombre());
            this.descripcionProdTv = findViewById(R.id.descTextView);
            this.imagenProdTv = findViewById(R.id.imagenProdVerTv);
            this.valorProdTv = findViewById(R.id.precioViewTv);
            this.nombreProdTv.setText(this.prod.getNombre());
            this.descripcionProdTv.setText(this.prod.getDescripcion());
            this.valorProdTv.setText(String.valueOf("$" +this.prod.getValor()));
            Picasso.get().load(this.prod.getFoto()).resize(500,500)
                    .centerCrop().into(this.imagenProdTv);
        }
    }
}
package cl.inacap.carroproductos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import cl.inacap.carroproductos.adapters.ProductosListAdapter;
import cl.inacap.carroproductos.dao.ProductosDAO;
import cl.inacap.carroproductos.dao.ProductosDAOLista;
import cl.inacap.carroproductos.dao.ProductosDAOSQLite;
import cl.inacap.carroproductos.dto.Producto;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton agregarBtn;
    private List<Producto> productos;
    private ProductosDAO prodDAO = new ProductosDAOSQLite(this);
    private ProductosListAdapter adapter;
    private ListView productosListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        productos = this.prodDAO.getAll();
        setContentView(R.layout.activity_main);
        this.setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        this.adapter = new ProductosListAdapter(this,R.layout.list_productos
                ,this.productos);
        this.productosListView = findViewById(R.id.productosListView);
        this.agregarBtn = findViewById(R.id.agregarBtnFb);
        this.productosListView.setAdapter(this.adapter);
        this.productosListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, VerProductosActivity.class);
                intent.putExtra("producto", productos.get(i));
                startActivity(intent);
            }
        });
        this.agregarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CrearProductoActivity.class);
                startActivity(intent);
            }
        });
    }
}
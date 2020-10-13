package cl.inacap.carroproductos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.carroproductos.dao.ProductosDAO;
import cl.inacap.carroproductos.dao.ProductosDAOSQLite;
import cl.inacap.carroproductos.dto.Producto;

public class CrearProductoActivity extends AppCompatActivity {

    private EditText nombreProd;
    private EditText urlFoto;
    private EditText descProd;
    private EditText precioProd;
    private Button crearBtn;
    private ProductosDAO prodDAO = new ProductosDAOSQLite(this);
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_crear_producto);
        this.setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        this.nombreProd = findViewById(R.id.nombreProdTxt);
        this.urlFoto = findViewById(R.id.fotoProdTxt);
        this.descProd = findViewById(R.id.descProdTxt);
        this.precioProd = findViewById(R.id.precioProdTxt);
        this.crearBtn = findViewById(R.id.guardarProdBtn);
        this.crearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> errores = new ArrayList<>();
                String nombre = nombreProd.getText().toString().trim();
                if(nombre.isEmpty()){
                    errores.add("Debe ingresar nombre");
                }
                String foto = urlFoto.getText().toString().trim();
                if(foto.isEmpty()){
                    errores.add("Debe ingresar foto");
                }
                String descProducto = descProd.getText().toString().trim();
                if(descProducto.isEmpty()){
                    errores.add("Debe ingresar descripcion");
                }
                int precio = 0;
                try {
                    precio = Integer.parseInt(precioProd.getText().toString());
                }catch(Exception ex){
                    errores.add("Debe ingresar precio valido");
                }
                if(errores.isEmpty()) {
                    Producto p = new Producto();
                    p.setNombre(nombre);
                    p.setFoto(foto);
                    p.setDescripcion(descProducto);
                    p.setValor(precio);
                    prodDAO.save(p);
                    Intent intent = new Intent(CrearProductoActivity.this, MainActivity.class);
                    startActivity(intent);
                }else {
                    AlertDialog.Builder alertBuilder =
                            new AlertDialog.Builder(CrearProductoActivity.this);
                    String mensaje = "";
                    for(String e:errores){
                        mensaje+="-" + e + "\n";

                    }
                    alertBuilder.setTitle("Errores de validación")
                            .setMessage(mensaje)
                            .setPositiveButton("Aceptar", null)
                            .create()
                            .show();
                }
            }
        });

    }
}
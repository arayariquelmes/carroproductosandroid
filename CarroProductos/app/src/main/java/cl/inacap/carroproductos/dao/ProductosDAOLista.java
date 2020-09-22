package cl.inacap.carroproductos.dao;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.carroproductos.dto.Producto;

public class ProductosDAOLista implements ProductosDAO {
    private static List<Producto> productos =  new ArrayList<>();
    private static ProductosDAOLista instancia;

    private ProductosDAOLista(){
        Producto p = new Producto();
        p.setValor(1000);
        p.setFoto("https://jumbo.vteximg.com.br/arquivos/ids/336745/Principal-3942.jpg?v=637237316746070000");
        p.setNombre("Coca cola Zero");
        p.setDescripcion("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse gravida semper erat nec interdum. Pellentesque lorem nisl, tempor eu dignissim eu, congue id dui. Vestibulum eget nulla at arcu vestibulum lacinia. Aliquam lorem ipsum, sollicitudin non lacus vitae, cursus condimentum velit. Aenean rutrum ut tortor eu tincidunt.");
        productos.add(p);
        p = new Producto();
        p.setValor(400);
        p.setNombre("Frac Chocolate");
        p.setFoto("https://cdnx.jumpseller.com/distribuidora-express/image/8251459/resize/540/540?1586911877");
        p.setDescripcion("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse gravida semper erat nec interdum. Pellentesque lorem nisl, tempor eu dignissim eu, congue id dui. Vestibulum eget nulla at arcu vestibulum lacinia. Aliquam lorem ipsum, sollicitudin non lacus vitae, cursus condimentum velit. Aenean rutrum ut tortor eu tincidunt.");

        productos.add(p);
        p = new Producto();
        p.setValor(100);
        p.setNombre("Centella papu!");
        p.setFoto("https://dojiw2m9tvv09.cloudfront.net/21884/product/X_4_20817.png?56");
        p.setDescripcion("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse gravida semper erat nec interdum. Pellentesque lorem nisl, tempor eu dignissim eu, congue id dui. Vestibulum eget nulla at arcu vestibulum lacinia. Aliquam lorem ipsum, sollicitudin non lacus vitae, cursus condimentum velit. Aenean rutrum ut tortor eu tincidunt.");
        productos.add(p);
    }

    public static ProductosDAOLista getInstance(){

        if(instancia == null){
            instancia = new ProductosDAOLista();
        }
        return instancia;
    }

    @Override
    public List<Producto> getAll() {
        return productos;
    }

    @Override
    public Producto save(Producto prod) {
        productos.add(prod);
        return prod;
    }
}

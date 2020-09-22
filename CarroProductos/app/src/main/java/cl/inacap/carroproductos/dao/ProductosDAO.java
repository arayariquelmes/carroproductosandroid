package cl.inacap.carroproductos.dao;

import java.util.List;

import cl.inacap.carroproductos.dto.Producto;

public interface ProductosDAO {

    List<Producto> getAll();
    Producto save(Producto prod);
}

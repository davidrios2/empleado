package com.co.empleado.service;


import com.co.empleado.dao.IProductoDao;
import com.co.empleado.exemption.ModelNotFound;
import com.co.empleado.model.Almacen;
import com.co.empleado.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
//Se recomienda que el servicio sea una interface y halla una implementación
@Service//Indica que pertenece a la capa de servicio
public class ProductoService {

    @Autowired//Inyecioón de dependencia para poder tener acceso al servicio
    private IProductoDao dao;

    private AlmacenService almacenService;

    @Autowired
    public ProductoService(AlmacenService almacenService) {
        this.almacenService = almacenService;
    }

    public Producto save(Producto p) {
        return dao.save(p);
    }

    public Producto update(Producto p) {
        return dao.save(p);
    }

    public void delete(Producto p) {
        dao.delete(p);
    }

    public Iterable<Producto> list() {
        return dao.findAll();
    }

    public Optional<Producto> listId(long id) {
        return dao.findById(id);
    }

    //Añadir cualquier otra operación necesaria en definida en el dao
    public Producto addProductToAlmacen(Producto producto, Long almacenId) {

        if (almacenService.getAlmacenById(almacenId) != null) {
            // Setear almacen en producto
            producto.setAlmacen(almacenService.getAlmacenById(almacenId));
            // guardar la entidad de producto
            return dao.save(producto);
        } else {
            throw new ModelNotFound("Almacen no encontrado");
        }
    }

}
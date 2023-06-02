package com.co.empleado.service;


import com.co.empleado.dao.IAlmacenDao;
import com.co.empleado.exemption.ModelNotFound;
import com.co.empleado.model.Almacen;
import com.co.empleado.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AlmacenService {

    @Autowired//Inyecioón de dependencia para poder tener acceso al servicio
    private IAlmacenDao dao;

    public Almacen save(Almacen a) {
        return dao.save(a);
    }

    public Almacen update(Almacen a) {
        return dao.save(a);
    }

    public void delete(Almacen a) {
        dao.delete(a);
    }

    public Iterable<Almacen> list() {
        return dao.findAll();
    }

    public Optional<Almacen> listId(long id) {
        return dao.findById(id);
    }

    public Almacen getAlmacenById(long id) {
        return dao.findById(id)
                .orElseThrow(() -> new ModelNotFound("Almacen no encontrado: " + id));
    }

    public List<Producto> getProductosByAlmacenId(Long almacenId) {
        Optional<Almacen> optionalAlmacen = dao.findById(almacenId);
        if (optionalAlmacen.isPresent()) {
            Almacen almacen = optionalAlmacen.get();
            return almacen.getProductos();
        }
        return Collections.emptyList();
    }

    //Añadir cualquier otra operación necesaria en definida en el dao

}

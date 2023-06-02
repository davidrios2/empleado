package com.co.empleado.dao;


import com.co.empleado.model.Almacen;
import org.springframework.data.repository.CrudRepository;

public interface IAlmacenDao extends CrudRepository<Almacen,Long> {
        //Automáticamnte crea el crud con los tipos de datos que definí y tiene sus clases como findAll, findById, etc
}

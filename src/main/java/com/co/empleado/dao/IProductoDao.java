package com.co.empleado.dao;


import com.co.empleado.model.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoDao extends CrudRepository<Producto,Long> {
    //Automáticamnte crea el crud con los tipos de datos que definí y tiene sus clases como findAll, findById, etc
    //Aquí van las búsquedas particulares
}

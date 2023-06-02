package com.co.empleado.controller;


import com.co.empleado.exemption.ModelNotFound;
import com.co.empleado.model.Producto;
import com.co.empleado.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/producto") //Definicón del endpoint
@CrossOrigin("*") //Definir que la puede consumir desde donde sea, usualmente para evitar problemas en el options
public class ProductoController {

    @Autowired //Inyection del sercio
    ProductoService productoService;

    @PostMapping("/save") // /producto/save
    public long save(@RequestBody Producto producto){ //En el POST necesita enviarle una parsona para guardarla
        productoService.save(producto);
        return producto.getId(); //Cada que guarde un dato retorna el id
    }

    @GetMapping("/listAll") //mostrar todas las personas
    public Iterable<Producto> listAllProducts(){return productoService.list();}

    @GetMapping("/list/{id}") //mostrar una persona
    public Producto listProductById(@PathVariable("id") int id){ //La busqueda por id se hace por parámetro
        Optional<Producto> producto = productoService.listId(id);
        if(producto.isPresent()){
            return producto.get();
        }
        throw new ModelNotFound("Id de producto no encontrado");
    }
}

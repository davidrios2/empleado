package com.co.empleado.controller;


import com.co.empleado.model.Almacen;
import com.co.empleado.model.Producto;
import com.co.empleado.service.AlmacenService;
import com.co.empleado.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/almacen")
@CrossOrigin("*")
public class AlmacenController {

    @Autowired
    AlmacenService almacenService;

    @Autowired
    ProductoService productoService;

    @GetMapping("/{id}")
    public List<Producto> getProductosByAlmacenId(@PathVariable Long id) {
        return almacenService.getProductosByAlmacenId(id);
    }

    @PostMapping("/{almacenId}/addProduct")
    public Producto addProductToAlmacen(@PathVariable Long almacenId, @RequestBody Producto producto){
        return productoService.addProductToAlmacen(producto, almacenId);
    }

    @PostMapping("/save")
    public long save(@RequestBody Almacen almacen) {
        Almacen savedAlmacen = almacenService.save(almacen);
        if(!savedAlmacen.getProductos().isEmpty()){
            for(Producto producto : savedAlmacen.getProductos()){
                productoService.save(producto);
            }
        }
        return savedAlmacen.getIdAlmacen();
    }


    @GetMapping("/listAll") //mostrar todos los almacenes
    public Iterable<Almacen> listAllProducts(){return almacenService.list();}

    @GetMapping("/list/{id}")
    public Almacen getAlmacenById(@PathVariable Long id){
        return almacenService.getAlmacenById(id);
    }
}

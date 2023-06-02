package com.co.empleado.controller;


import com.co.empleado.model.Almacen;
import com.co.empleado.model.Producto;
import com.co.empleado.service.AlmacenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/almacen")
@CrossOrigin("*")
public class AlmacenController {

    @Autowired
    AlmacenService almacenService;

    @GetMapping("/{id}")
    public List<Producto> getProductosByAlmacenId(@PathVariable Long id) {
        return almacenService.getProductosByAlmacenId(id);
    }

    @PostMapping("/save") // /producto/save
    public long save(@RequestBody Almacen almacen){ //En el POST necesita enviarle una parsona para guardarla
        almacenService.save(almacen);
        return almacen.getIdAlmacen(); //Cada que guarde un dato retorna el id
    }

    @GetMapping("/listAll") //mostrar todas las personas
    public Iterable<Almacen> listAllProducts(){return almacenService.list();}
}

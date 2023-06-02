package com.co.empleado.model;

import jakarta.persistence.*;
import lombok.*;


//POJO
@Data // Asociación con la BD
@Entity //Creación como entity bean
@Table(name = "producto")
@NoArgsConstructor(force = true) //Constructor con y sin argumentos pongo el force porque tiene campos obligatorios
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="nombre", nullable = false, length = 80)
    private @NonNull String nombre; //Not null = obligatorio

    @Column(name="inventario", nullable = true)
    private Long inventario;

    @ManyToOne
    @JoinColumn(name = "idAlmacen")
    private Almacen almacen;
}
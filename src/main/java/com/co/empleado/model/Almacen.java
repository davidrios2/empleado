package com.co.empleado.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data // Asociación con la BD
@Entity //Creación como entity bean
@Table(name = "almacen")
@NoArgsConstructor(force = true) //Constructor con y sin argumentos pongo el force porque tiene campos obligatorios
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Almacen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idAlmacen")
    private Long idAlmacen;

    @Column(name="nombre", nullable = false, length = 80)
    private @NonNull String nombre; //Not null = obligatorio

    @OneToMany(mappedBy = "almacen", cascade = CascadeType.ALL)
    @JsonManagedReference // Para evitar ciclos infinitos en la respuesta
    private List<Producto> productos;
}
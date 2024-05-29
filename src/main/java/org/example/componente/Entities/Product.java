package org.example.componente.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Product")
@Table(name = "PRODUCT")
public class Product implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PRODUCT")
    @SequenceGenerator(name = "SEQ_PRODUCT", sequenceName = "SEQ_PRODUCT", allocationSize = 1)

    @Column(name = "EQU_CODIGO", nullable = false)
    private long id;

    @Column(name = "EQU_NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "EQU_TIPO", nullable = false)
    private String tipo;

    @Column(name = "EQU_PRECIOUNIDAD", nullable = false)
    private int precioUnidad;

    @Column(name = "EQU_PESO", nullable = false)
    private int peso;

    @Column(name = "EQU_ESTADO", nullable = false)
    private Boolean estado;
}

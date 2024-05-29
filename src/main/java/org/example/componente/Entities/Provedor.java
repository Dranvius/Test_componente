package org.example.componente.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "PROVEDOR")
@Table(name = "PROVEDOR")
public class Provedor implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PROVEDOR")
    @SequenceGenerator(name = "SEQ_PROVEDOR", sequenceName = "SEQ_PROVEDOR", allocationSize = 1)

    @Column(name = "EQU_CODIGO", nullable = false)
    private long id;

    @Column(name = "EQU_NOMBREPROVEDOR", nullable = false)
    private String nombreProvedor;

    @Column(name = "EQU_NUMERO", nullable = false)
    private int numero;

    @Column(name = "EQU_codigoProducto", nullable = false)
    private int idProducto;

}

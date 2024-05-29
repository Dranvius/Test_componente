package org.example.componente.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DtoProduct implements Serializable{
    private int id;
    private String nombre;
    private String tipo;
    private int precioUnidad;
    private int peso;
    private boolean estado;
}

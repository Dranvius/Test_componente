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
public class DtoProvedor implements Serializable {
    private int id;
    private String nombreProvedor;
    private long numero;
    private int idProducto;
}

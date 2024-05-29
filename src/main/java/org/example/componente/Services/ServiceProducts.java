package org.example.componente.Services;

import org.example.componente.Dto.DtoProduct;
import org.example.componente.Entities.Product;
import org.example.componente.Repositories.RepositoryProduct;

import org.example.componente.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import java.lang.reflect.Array;
import java.util.stream.Collectors;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Service
public class ServiceProducts implements Serializable {

    private final ModelMapper modelMapper;
    private final RepositoryProduct repoProduct;

    public String Alarma(List<DtoProduct> DtoProductes) {
        List<Product> Productes = DtoProductes.stream()
                .map(dto -> modelMapper.map(dto, Product.class))
                .collect(Collectors.toList());

        System.out.println("Objeto instanciado");

        int i = 0;

        int producto_1 = 0;
        int producto_2 = 0;
        int producto_3 = 0;
        int producto_4 = 0;
        int producto_5 = 0;

        for (Product producte : Productes) {
            if(producte.getTipo().equals("Tipo 5")){
                producto_5 = producto_5 +1 ;
            }

            if(producte.getTipo().equals("Tipo 4")){
                producto_4 = producto_4 +1;
            }
            if(producte.getTipo().equals("Tipo 3")){
                producto_3 = producto_3 +1;
            }
            if(producte.getTipo().equals("Tipo 2")){
                producto_2 = producto_2 +1;
            }
            if(producte.getTipo().equals("Tipo 1")){
                producto_1 = producto_1 +1;
            }

        }


        //!Lista de productos
        System.out.println("Stock de productos con alertas : \nProducto 1 : " +producto_1+ "\nProducto 2 : " +producto_2+ "\nProducto 3 : " +producto_3+ "\nProducto 4 : "+producto_4+ "\nProducto 5 : "+producto_5  );

        //!Lista de productos
        String a = "Es ncesario realizar un abastatecimiento de  el producto : ";

        //MENSAJE QUE PRODUCTOS QUE ESTAN BAJO DE 20
        if(producto_5 < 20){
            a = a + "\nProducto 5";
        }

        if(producto_4 < 20){
            a = a + "\nProducto 4";
        }
        if(producto_3 < 20){
            a = a + "\nProducto 3";
        }
        if(producto_2 < 20){
            a = a + "\nProducto 2";
        }
        if(producto_1 < 20){
            a = a + "\nProducto 1";
        }

        return a;
    }


}

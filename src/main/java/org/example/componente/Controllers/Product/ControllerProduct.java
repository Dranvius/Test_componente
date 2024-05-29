package org.example.componente.Controllers.Product;

import org.example.componente.Dto.DtoProduct;
import org.example.componente.Entities.Product;
import org.example.componente.Services.ServiceProducts;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@Controller
public class ControllerProduct {

    private static final Logger logger = LogManager.getLogger(ControllerProduct.class);

    @Autowired
    ServiceProducts serviciosProducts;

    //Alarma
    @GetMapping({"/alert"})
    public String usuarios(@NotNull Model model){
        logger.info("Verificando ");
        //model.addAttribute("product", serviciosProducts.obtenerproduct());
        //return "cuenta";
        return "asd";
    }

    @PostMapping("/alarma")
    public ResponseEntity<String> alarmaProductos(@RequestBody List<DtoProduct> productos) {
        // Aquí puedes llamar a tu servicio para manejar la lógica de alarma
                //serviciosProducts.Alarma(productos);
                //System.out.println(productos);


        // Devuelve una respuesta apropiada, por ejemplo, un mensaje indicando que la alarma fue activada
        return ResponseEntity.ok(serviciosProducts.Alarma(productos));
    }


    //Invocacción por URL a esa Ruta del back
    //DTO
    //Enlistar product
    @GetMapping({"/cuenta"})
    public String listarProduct(@NotNull Model model){
        logger.info("Verificando ");
        //model.addAttribute("product", serviciosProducts.obtenerproduct());
        //return "cuenta";
        return "asd";
    }


    //Mostrar formulario
    @GetMapping("/product/nuevo")
    public String mostrarFormulario(Model model){
        DtoProduct DtoProduct = new DtoProduct();
        model.addAttribute("product",DtoProduct);
        return "crear_cuenta";
    }

    //Registrar product

    @PostMapping("/product")
    public String registrar(@ModelAttribute("product") DtoProduct cuenta) {
        serviciosProducts.registrar(cuenta);
        //Re dirige a product cuando termine el servicio
        return "redirect:/product";
    }

    //Editar

    @GetMapping("/product/modificar/{serial}")
    public String mostrarFormularioEditar(@PathVariable long serial, Model model){
        DtoProduct DtoProduct = new DtoProduct();
        model.addAttribute("cuenta", serviciosProducts.obtenerProduct(serial));
        return "editar_equipo";
    }


    @PostMapping("/product/{serial}")
    public String modificarCuenta(@PathVariable long serial,@ModelAttribute( "cuenta") DtoProduct DtoProduct, Model model){
        model.addAttribute("cuenta", serviciosProducts.actualizar(DtoProduct));
        return "redirect:/cuenta";
    }


    @GetMapping("/product/{serial}")
    public String eliminarCuenta(@PathVariable long serial){
        serviciosProducts.eliminar(serial);
        return "redirect:/cuenta";
    }


}

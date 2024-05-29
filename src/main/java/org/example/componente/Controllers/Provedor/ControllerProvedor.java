package org.example.componente.Controllers.Provedor;

import org.example.componente.Dto.DtoProvedor;
import org.example.componente.Services.ServiceProvedor;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Log4j2
@Controller
public class ControllerProvedor {

    private static final Logger logger = LogManager.getLogger(ControllerProvedor.class);

    @Autowired
    ServiceProvedor serviciosProvedor;

    //Invocacción por URL a esa Ruta del back
    //DTO
    //Enlistar provedors

    @GetMapping({"/provedor"})
    public String listarprovedors(@NotNull Model model){
        logger.info("Verificando ");
        model.addAttribute("provedors", serviciosProvedor.obtenerProvedores());
        return "provedor";
    }

    //Mostrar formulario
    @GetMapping("/provedors/nuevo")
    public String mostrarFormulario(Model model){
        DtoProvedor DtoProvedor = new DtoProvedor();
        model.addAttribute("provedor",DtoProvedor);
        return "crear_provedor";
    }

    //Registrar provedors
    @PostMapping("/provedors")
    public String registrar(@ModelAttribute("provedor") DtoProvedor provedor) {
        serviciosProvedor.registrar(provedor);
      //Re dirige a provedors cuando termine el servicio
        return "redirect:/provedors";
    }

    //Editar
    @GetMapping("/provedors/modificar/{serial}")
    public String mostrarFormularioEditar(@PathVariable long serial, Model model){
        DtoProvedor DtoProvedor = new DtoProvedor();
        model.addAttribute("provedor", serviciosProvedor.obtenerProvedor(serial));
        return "editar_equipo";
    }


    @PostMapping("/provedors/{serial}")
    public String modificarprovedor(@PathVariable long serial,@ModelAttribute( "provedor") DtoProvedor DtoProvedor, Model model){
        model.addAttribute("provedor", serviciosProvedor.actualizar(DtoProvedor));
        return "redirect:/provedor";
    }


    @GetMapping("/provedors/{serial}")
    public String eliminarprovedor(@PathVariable long serial){
        serviciosProvedor.eliminar(serial);
        return "redirect:/provedor";
    }

}

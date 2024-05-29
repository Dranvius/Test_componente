package org.example.componente.Controllers.Provedor;

// Parametros de definición
import org.example.componente.Dto.DtoProvedor;
import org.example.componente.Services.ServiceProvedor;

// Utilidades
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/api/provedor")
public class ControllerProvedorANG {
    private static final Logger logger = LogManager.getLogger(ControllerProvedor.class);

    @Autowired
    private ServiceProvedor servicioProvedor;

    @GetMapping("/")
    public ResponseEntity<List<DtoProvedor>> listarProvedor() {
        List<DtoProvedor> provedores = servicioProvedor.obtenerProvedores();
        return ResponseEntity.ok(provedores);
    }

//    @GetMapping("/{serial}")
//    public ResponseEntity<DtoProvedor> obtenerPorId(@PathVariable("serial") Long serial) {
//        log.info("Ingresa serial " + serial);
//        DtoProvedor provedor = servicioProvedor.obtenerProvedor(serial);
//        if (provedor == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(provedor);
//    }
//
//    @PostMapping("/")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<DtoProvedor> crear(@Validated @RequestBody DtoProvedor entityDto) {
//        DtoProvedor nuevoProvedor = servicioProvedor.registrar(entityDto);
//        return new ResponseEntity<>(nuevoProvedor, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<DtoProvedor> modificar(@Validated @RequestBody DtoProvedor entityDto) {
//        DtoProvedor actualizadoProvedor = servicioProvedor.actualizar(entityDto);
//        if (actualizadoProvedor == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return new ResponseEntity<>(actualizadoProvedor, HttpStatus.CREATED);
//    }
//
//    @DeleteMapping("/{serial}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void borrado(@PathVariable("serial") Long serial) {
//        servicioProvedor.eliminar(serial);
//    }
}

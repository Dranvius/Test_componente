package org.example.componente.Controllers.Product;

//Parametros de definición
import org.example.componente.Controllers.Product.ControllerProduct;
import org.example.componente.Dto.DtoProduct;
import org.example.componente.Services.ServiceProducts;

//Utilidades
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@RestController
@RequestMapping("/api/cuenta")
public class ControllerProductANG {
    private static final Logger logger = LogManager.getLogger(ControllerProduct.class);


    private ServiceProducts servicioproducto;

    @GetMapping("/")
    public ResponseEntity <List<DtoProduct>> listarProvedores(){
        return ResponseEntity.ok(servicioproducto.obtenerProducts());
    }

    @GetMapping("/{serial}")
    public ResponseEntity<DtoProduct> obtenerPorId(@PathVariable("serial") Long serial) {
        log.info( " Ïngresa serial "+ serial);
        return ResponseEntity.ok(servicioproducto.obtenerProduct(serial));
    }


    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<DtoProduct> crear(@Validated @RequestBody DtoProduct entityDto) {
        entityDto = servicioproducto.registrar(entityDto);

        return new ResponseEntity<>(entityDto, HttpStatus.CREATED);
    }
    @PutMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<DtoProduct> modificar(@Validated @RequestBody DtoProduct entityDto) {
        entityDto = servicioproducto.actualizar(entityDto);

        return new ResponseEntity<>(entityDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{serial}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrado(@PathVariable("serial") Long serial) {

        servicioproducto.eliminar(serial);
    }
}

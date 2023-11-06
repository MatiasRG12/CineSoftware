package co.edu.uniquindio.cineSoftware.modelo.controladores;

import co.edu.uniquindio.cineSoftware.modelo.dto.MensajeDTO;
import co.edu.uniquindio.cineSoftware.modelo.servicios.interfaces.ServiciosCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/boleteria")
public class BoleteriaController {

    private final ServiciosCliente serviciosCliente;
    private final MessageSource ms;

    @GetMapping("/obtenerPrecioBoleta")
    public ResponseEntity<MensajeDTO> obtenerPrecio (@PathVariable int codigoCliente)throws Exception{
        Double precio = serviciosCliente.obtenerPrecioBoletas(codigoCliente);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, ms.getMessage("bienvenida.mensaje", null, LocaleContextHolder.getLocale()),precio));
    }

}

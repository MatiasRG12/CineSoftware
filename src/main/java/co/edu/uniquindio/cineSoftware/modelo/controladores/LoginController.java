package co.edu.uniquindio.cineSoftware.modelo.controladores;

import co.edu.uniquindio.cineSoftware.modelo.dto.*;
import co.edu.uniquindio.cineSoftware.modelo.servicios.interfaces.AutenticacionServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/autenticacion")
public class LoginController {

    private AutenticacionServicio autenticacionServicio;
    private MessageSource ms;

    @PostMapping("/login")
    public ResponseEntity<MensajeDTO> authentication(@RequestBody @Valid LoginDTO sesionDTO) throws Exception {
        TokenDTO token = autenticacionServicio.login(sesionDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, ms.getMessage("usuario.loggeado", null, LocaleContextHolder.getLocale()), token));
    }
}

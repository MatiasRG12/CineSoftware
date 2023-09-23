package co.edu.uniquindio.cineSoftware.modelo.controladores;

import co.edu.uniquindio.cineSoftware.modelo.dto.MensajeDTO;
import co.edu.uniquindio.cineSoftware.modelo.dto.SesionDTO;
import co.edu.uniquindio.cineSoftware.modelo.dto.TokenDTO;
import co.edu.uniquindio.cineSoftware.modelo.servicios.ServiciosGenerales;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/autenticacion")
public class LoginController {

    private ServiciosGenerales serviciosGenerales;
    private MessageSource ms;

    @PostMapping("/login")
    public ResponseEntity<MensajeDTO> authentication(@RequestBody @Valid SesionDTO sesionDTO) throws Exception {
        Map<String, TokenDTO> tokens = serviciosGenerales.login(sesionDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, ms.getMessage("", new Object[]{sesionDTO.getUserId()}, LocaleContextHolder.getLocale()), tokens));
    }

    @GetMapping("/refreshToken")
    public ResponseEntity<MensajeDTO> refreshToken(HttpServletRequest request) throws Exception {
        TokenDTO refreshToken = serviciosGenerales.refreshToken(request.getHeader("Authorization"));
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, ms.getMessage("", null, LocaleContextHolder.getLocale()), refreshToken));
    }

}

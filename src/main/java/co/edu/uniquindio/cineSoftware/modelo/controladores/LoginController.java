package co.edu.uniquindio.cineSoftware.modelo.controladores;

import co.edu.uniquindio.cineSoftware.modelo.dto.MensajeDTO;
import co.edu.uniquindio.cineSoftware.modelo.dto.SesionDTO;
import co.edu.uniquindio.cineSoftware.modelo.dto.TokenDTO;
import co.edu.uniquindio.cineSoftware.modelo.servicios.interfaces.ServiciosGenerales;
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


}

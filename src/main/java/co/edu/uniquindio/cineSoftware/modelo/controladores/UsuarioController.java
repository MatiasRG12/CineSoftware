package co.edu.uniquindio.cineSoftware.modelo.controladores;

import co.edu.uniquindio.cineSoftware.modelo.dto.MensajeDTO;
import co.edu.uniquindio.cineSoftware.modelo.dto.ClienteDTO;
import co.edu.uniquindio.cineSoftware.modelo.servicios.interfaces.ServiciosCliente;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/usuario")
public class UsuarioController {

    private ServiciosCliente serviciosCliente;
    @Autowired
    private MessageSource ms;

    @PostMapping("/agregar")
    public ResponseEntity<MensajeDTO> agregarUsuario (@RequestBody @Valid ClienteDTO usuarioDTO) throws Exception {
        String usuarioId = serviciosCliente.agregar(usuarioDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, ms.getMessage("bienvenida.mensaje", new Object[]{usuarioId}, LocaleContextHolder.getLocale()), usuarioId));
    }



}

package co.edu.uniquindio.cineSoftware.modelo.controladores;


import co.edu.uniquindio.cineSoftware.modelo.dto.MensajeDTO;
import co.edu.uniquindio.cineSoftware.modelo.dto.PeliculaDTO;
import co.edu.uniquindio.cineSoftware.modelo.servicios.interfaces.ServiciosAdministrador;
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
@RequestMapping("/catalogoP")
public class CatalogoPeliculasController {

    private ServiciosAdministrador sa;
    private MessageSource ms;

    @PostMapping("/agregarP")
    public ResponseEntity<MensajeDTO> agregarPelicula(@RequestBody @Valid PeliculaDTO peliculaDTO) throws Exception {
        String pelicula = sa.agregarPelicula(peliculaDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, ms.getMessage("", new Object[]{pelicula}, LocaleContextHolder.getLocale()), pelicula));
    }

    @DeleteMapping ("/eliminarP/{peliculaId}")
    public ResponseEntity<MensajeDTO> eliminarPelicula(@PathVariable String peliculaId) throws Exception {
        String peliculaEliminada = sa.eliminarPelicula(peliculaId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, ms.getMessage("", new Object[]{peliculaEliminada}, LocaleContextHolder.getLocale()), peliculaEliminada));
    }

    @GetMapping("/listar")
    public ResponseEntity<MensajeDTO> listarPeliculas()throws Exception{
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, ms.getMessage("bienvenida.mensaje", null, LocaleContextHolder.getLocale()), sa.listarPeliculas()));
    }
}

package co.edu.uniquindio.cineSoftware.modelo.servicios;

import co.edu.uniquindio.cineSoftware.modelo.dto.PeliculaDTO;
import org.springframework.stereotype.Service;


@Service
public interface ServiciosAdministrador {

    String agregarPelicula(PeliculaDTO peliculaDTO) throws Exception;

    String eliminarPelicula(String peliculaId) throws Exception;


}

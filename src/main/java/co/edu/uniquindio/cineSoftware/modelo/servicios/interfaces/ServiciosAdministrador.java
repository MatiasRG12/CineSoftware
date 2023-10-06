package co.edu.uniquindio.cineSoftware.modelo.servicios.interfaces;

import co.edu.uniquindio.cineSoftware.modelo.dto.PeliculaDTO;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ServiciosAdministrador {

    String agregarPelicula(PeliculaDTO peliculaDTO) throws Exception;

    String eliminarPelicula(String peliculaId) throws Exception;

    List<PeliculaDTO> listarPeliculas() throws Exception;
}
package co.edu.uniquindio.cineSoftware.modelo.servicios.impl;

import co.edu.uniquindio.cineSoftware.modelo.Repositorios.PeliculaRepo;
import co.edu.uniquindio.cineSoftware.modelo.dto.PeliculaDTO;
import co.edu.uniquindio.cineSoftware.modelo.entidades.Pelicula;
import co.edu.uniquindio.cineSoftware.modelo.servicios.interfaces.ServiciosAdministrador;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ServicioAdministrador")
@AllArgsConstructor
public class ServiciosAdministradorimpl implements ServiciosAdministrador {

    private PeliculaRepo peliculaRepo;
    private MessageSource ms;

    @Override
    public String agregarPelicula(PeliculaDTO peliculaDTO) throws Exception {
        if (peliculaRepo.existsById(peliculaDTO.getCodigo())) {
            throw new Exception(ms.getMessage("ya existe la pelicula", new Object[]{peliculaDTO.getCodigo()}, LocaleContextHolder.getLocale()));
        }
        Pelicula pelicula = convertirAEntidad(peliculaDTO);
        return peliculaRepo.save(pelicula).getCodigo();
    }

    @Override
    public String eliminarPelicula(String peliculaId) throws Exception {
        if(!peliculaRepo.existsById(peliculaId)){
            throw new Exception(ms.getMessage("pelicula no encontrada", new Object[]{peliculaId}, LocaleContextHolder.getLocale()));
        }
        peliculaRepo.deleteById(peliculaId);
        return peliculaId;
    }

    @Override
    public List<PeliculaDTO> listarPeliculas() throws Exception {
        List<Pelicula> peliculas = peliculaRepo.findAll();
        List<PeliculaDTO> peliculaDTOS = new ArrayList<>();
        if(peliculas.isEmpty()){
            throw new Exception(ms.getMessage("no hay peliculas", null, LocaleContextHolder.getLocale()));
        }
        for(Pelicula pelicula : peliculas){
            peliculaDTOS.add(convertirADTO(pelicula));
        }
        return peliculaDTOS;
    }

    private PeliculaDTO convertirADTO(Pelicula pelicula) {
        return new PeliculaDTO(
                pelicula.getCodigo(),
                pelicula.getNombre(),
                pelicula.getDuracion()
        );
    }

    private Pelicula convertirAEntidad(PeliculaDTO peliculaDTO) {
        Pelicula pelicula = new Pelicula();
        pelicula.setCodigo(peliculaDTO.getCodigo());
        pelicula.setNombre(peliculaDTO.getNombre());
        pelicula.setDuracion(peliculaDTO.getDuracionMinutos());

        return pelicula;
    }

}

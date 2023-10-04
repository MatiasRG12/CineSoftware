package co.edu.uniquindio.cineSoftware.modelo.servicios.interfaces;

import co.edu.uniquindio.cineSoftware.modelo.dto.SesionDTO;
import co.edu.uniquindio.cineSoftware.modelo.dto.TokenDTO;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface ServiciosGenerales {

    void login(SesionDTO sesionDTO) throws Exception;

}

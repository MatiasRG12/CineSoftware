package co.edu.uniquindio.cineSoftware.modelo.servicios;

import co.edu.uniquindio.cineSoftware.modelo.dto.SesionDTO;
import co.edu.uniquindio.cineSoftware.modelo.dto.TokenDTO;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface ServiciosGenerales {

    Map<String, TokenDTO> login(SesionDTO sesionDTO) throws Exception;

    TokenDTO refreshToken(String authorization) throws Exception;


}

package co.edu.uniquindio.cineSoftware.modelo.servicios.interfaces;

import co.edu.uniquindio.cineSoftware.modelo.dto.LoginDTO;
import co.edu.uniquindio.cineSoftware.modelo.dto.SesionDTO;
import co.edu.uniquindio.cineSoftware.modelo.dto.TokenDTO;

public interface AutenticacionServicio {

    TokenDTO login(LoginDTO loginDTO) throws Exception;

}

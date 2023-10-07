package co.edu.uniquindio.cineSoftware.modelo.servicios.impl;

import co.edu.uniquindio.cineSoftware.modelo.Repositorios.UsuarioRepo;
import co.edu.uniquindio.cineSoftware.modelo.dto.SesionDTO;
import co.edu.uniquindio.cineSoftware.modelo.dto.TokenDTO;
import co.edu.uniquindio.cineSoftware.modelo.servicios.interfaces.ServiciosGenerales;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service("ServiciosGenerales")
@AllArgsConstructor
public class ServiciosGeneralesimpl implements ServiciosGenerales {

    private UsuarioRepo usuarioRepo;
    private MessageSource ms;


    @Override
    public boolean login(SesionDTO sesionDTO) throws Exception {
        String nombreUsuario = sesionDTO.getNombreUsuario();
        String contrasenia = sesionDTO.getContrasenia();
        if(!usuarioRepo.buscarUsuario(nombreUsuario,contrasenia)){
            return false;
        }
        return true;
    }
}

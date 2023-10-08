package co.edu.uniquindio.cineSoftware.modelo.servicios.impl;

import co.edu.uniquindio.cineSoftware.modelo.Repositorios.UsuarioRepo;
import co.edu.uniquindio.cineSoftware.modelo.dto.SesionDTO;
import co.edu.uniquindio.cineSoftware.modelo.dto.TokenDTO;
import co.edu.uniquindio.cineSoftware.modelo.dto.UsuarioDTO;
import co.edu.uniquindio.cineSoftware.modelo.entidades.Usuario;
import co.edu.uniquindio.cineSoftware.modelo.servicios.interfaces.ServiciosGenerales;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service("ServiciosGenerales")
@AllArgsConstructor
public class ServiciosGeneralesimpl implements ServiciosGenerales {

    private UsuarioRepo usuarioRepo;
    private MessageSource ms;


    @Override
    public UsuarioDTO login(SesionDTO sesionDTO) throws Exception {
        String nombreUsuario = sesionDTO.getNombreUsuario();
        String contrasenia = sesionDTO.getContrasenia();
        Optional<Usuario> usuario = usuarioRepo.buscarUsuario(nombreUsuario,contrasenia);
        if(usuario.isEmpty()){
            throw new Exception(ms.getMessage("Usuario no existe", null, LocaleContextHolder.getLocale()));
        }
        UsuarioDTO usuarioEncontrado = new UsuarioDTO();
        usuarioEncontrado.setNombreUsuario(nombreUsuario);
        usuarioEncontrado.setCodigo(String.valueOf(usuario.get().getCodigo()));
        return usuarioEncontrado;
    }
}

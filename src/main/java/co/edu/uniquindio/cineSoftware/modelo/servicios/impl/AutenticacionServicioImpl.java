package co.edu.uniquindio.cineSoftware.modelo.servicios.impl;

import co.edu.uniquindio.cineSoftware.modelo.Repositorios.UsuarioRepo;
import co.edu.uniquindio.cineSoftware.modelo.dto.LoginDTO;
import co.edu.uniquindio.cineSoftware.modelo.dto.SesionDTO;
import co.edu.uniquindio.cineSoftware.modelo.dto.TokenDTO;
import co.edu.uniquindio.cineSoftware.modelo.dto.UsuarioDTO;
import co.edu.uniquindio.cineSoftware.modelo.entidades.Administrador;
import co.edu.uniquindio.cineSoftware.modelo.entidades.Cliente;
import co.edu.uniquindio.cineSoftware.modelo.entidades.Usuario;
import co.edu.uniquindio.cineSoftware.modelo.servicios.interfaces.AutenticacionServicio;
import co.edu.uniquindio.cineSoftware.utils.FiltroToken;
import co.edu.uniquindio.cineSoftware.utils.JWTUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AutenticacionServicioImpl implements AutenticacionServicio {

    @Autowired
    private UsuarioRepo usuarioRepo;
    private final JWTUtils jwtUtils;
    @Autowired
    private MessageSource ms;


    @Override
    public TokenDTO login(LoginDTO sesionDTO) throws Exception {
        String nombreUsuario = sesionDTO.usuario();
        String contrasenia = sesionDTO.contrasenia();
        Optional<Usuario> usuario = usuarioRepo.buscarUsuario(nombreUsuario,contrasenia);
        if(usuario.isEmpty()){
            throw new Exception(ms.getMessage("Usuario no existe", null, LocaleContextHolder.getLocale()));
        }
        UsuarioDTO usuarioEncontrado = new UsuarioDTO();
        usuarioEncontrado.setNombreUsuario(nombreUsuario);
        usuarioEncontrado.setCodigo(String.valueOf(usuario.get().getCodigo()));
        return new TokenDTO(crearToken(usuario.get()));
    }

    private String crearToken(Usuario usuario) {

        String rol;
        String nombre;
        if( usuario instanceof Administrador){
            rol = "administrador";
            nombre = ((Administrador) usuario).getNombreUsuario();
        }else{
            rol = "cliente";
            nombre = ((Cliente) usuario).getNombre();
        }
        Map<String, Object> map = new HashMap<>();
        map.put("rol", rol);
        map.put("nombre", nombre);
        map.put("id", usuario.getCodigo());
        return jwtUtils.generarToken(usuario.getNombreUsuario(), map);

    }

}

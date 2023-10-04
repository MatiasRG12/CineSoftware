package co.edu.uniquindio.cineSoftware.modelo.servicios.interfaces;


import co.edu.uniquindio.cineSoftware.modelo.dto.ClienteDTO;
import org.springframework.stereotype.Service;

@Service
public interface ServiciosCliente {
    String agregar(ClienteDTO usuarioDTO) throws Exception;
}

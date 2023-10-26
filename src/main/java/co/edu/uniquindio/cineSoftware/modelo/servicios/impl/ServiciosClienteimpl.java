package co.edu.uniquindio.cineSoftware.modelo.servicios.impl;

import co.edu.uniquindio.cineSoftware.modelo.Repositorios.ClienteRepo;
import co.edu.uniquindio.cineSoftware.modelo.Repositorios.UsuarioRepo;
import co.edu.uniquindio.cineSoftware.modelo.dto.ClienteDTO;
import co.edu.uniquindio.cineSoftware.modelo.entidades.Cliente;
import co.edu.uniquindio.cineSoftware.modelo.servicios.interfaces.ServiciosCliente;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("ServiciosCliente")
@AllArgsConstructor
public class ServiciosClienteimpl implements ServiciosCliente {

    private ClienteRepo clienteRepo;
    private MessageSource ms;

    @Override
    public String agregar(ClienteDTO clienteDTO) throws Exception {
        if(clienteRepo.existsById(clienteDTO.getCodigo())){
            throw  new Exception(ms.getMessage("Usuario ya existe", new Object[]{clienteDTO.getCodigo()}, LocaleContextHolder.getLocale()));
        }
        Cliente cliente = convertirAEntidad(clienteDTO);
        return String.valueOf(clienteRepo.save(cliente));
    }

    @Override
    public Double obtenerPrecioBoletas(int codigoCliente) throws Exception {
        Optional<Cliente> opcional = clienteRepo.findById(codigoCliente);
        if (opcional.isEmpty()){
            throw new Exception("Cliente no existe");
        }
        Cliente cliente = opcional.get();
        if(cliente.isMembresia()){
            return 10000.0;
        }
        return 15000.0;
    }

    private Cliente convertirAEntidad(ClienteDTO clienteDTO) {

        Cliente cliente = new Cliente();
        cliente.setCodigo(clienteDTO.getCodigo());
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setNombreUsuario(clienteDTO.getNombreUsuario());
        cliente.setContrasenia(clienteDTO.getContrasenia());
        return cliente;
    }
}

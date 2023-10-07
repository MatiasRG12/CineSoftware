package co.edu.uniquindio.cineSoftware.modelo.Repositorios;

import co.edu.uniquindio.cineSoftware.modelo.dto.SesionDTO;
import co.edu.uniquindio.cineSoftware.modelo.dto.UsuarioDTO;
import co.edu.uniquindio.cineSoftware.modelo.entidades.Cliente;
import co.edu.uniquindio.cineSoftware.modelo.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepo extends JpaRepository<Cliente,String> {


    @Query("SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario AND u.contrasenia = :contrasenia")
    Optional<Usuario> buscarUsuario(String nombreUsuario, String contrasenia);
}

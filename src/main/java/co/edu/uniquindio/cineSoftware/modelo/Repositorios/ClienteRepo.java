package co.edu.uniquindio.cineSoftware.modelo.Repositorios;

import co.edu.uniquindio.cineSoftware.modelo.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepo extends JpaRepository<Cliente, Integer> {
}

package co.edu.uniquindio.cineSoftware.modelo.Repositorios;

import co.edu.uniquindio.cineSoftware.modelo.entidades.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepo extends JpaRepository<Pelicula,String> {


}

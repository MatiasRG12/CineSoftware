package co.edu.uniquindio.cineSoftware.modelo.entidades;

import co.edu.uniquindio.cineSoftware.modelo.enumeraciones.Ciudad;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Teatro implements Serializable {

    @Id
    private String codigo;

    private Ciudad ciudad;

    @OneToMany(mappedBy = "teatro")
    private List<Sala> listaSalas;

    @OneToOne
    private Administrador administrador;
}

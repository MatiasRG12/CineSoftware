package co.edu.uniquindio.cineSoftware.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.io.Serializable;
import java.util.List;

@Entity
public class Administrador extends Usuario implements Serializable {

    @OneToOne
    private Teatro teatro;

    @OneToMany(mappedBy = "administrador")
    private List<Pqrs> listaPqrs;
}

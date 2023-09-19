package co.edu.uniquindio.cineSoftware.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.io.Serializable;
import java.util.List;

@Entity
public class Cliente extends Usuario implements Serializable {

    private String cedula;

    @OneToOne
    private Membresia membresia;

    @OneToMany(mappedBy = "cliente")
    private List<Boleto> listaBoleto;

    @OneToMany(mappedBy = "cliente")
    private List<Pqrs> listaPqrsCliente;
}

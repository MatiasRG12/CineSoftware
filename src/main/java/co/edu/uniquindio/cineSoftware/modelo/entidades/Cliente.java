package co.edu.uniquindio.cineSoftware.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Cliente extends Usuario implements Serializable {

    private String nombre;

    @OneToOne
    private Membresia membresia;

    @OneToMany(mappedBy = "cliente")
    private List<Boleto> listaBoleto;

    @OneToMany(mappedBy = "cliente")
    private List<Pqrs> listaPqrsCliente;
}

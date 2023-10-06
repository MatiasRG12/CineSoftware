package co.edu.uniquindio.cineSoftware.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Pelicula implements Serializable {

    @Id
    private String codigo;

    private String nombre;

    private int duracion;

    @OneToMany(mappedBy = "pelicula")
    private List<Boleto> listaBoletos;
}

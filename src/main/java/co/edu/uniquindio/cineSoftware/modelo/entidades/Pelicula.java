package co.edu.uniquindio.cineSoftware.modelo.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Pelicula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;

    private String nombre;

    private int duracion;

    /**
     * Cambiecito
     */
    private String link;

    @OneToMany(mappedBy = "pelicula")
    private List<Boleto> listaBoletos;
}

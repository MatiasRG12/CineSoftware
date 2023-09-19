package co.edu.uniquindio.cineSoftware.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.List;

@Entity
public class Pelicula implements Serializable {

    @Id
    private String codigo;

    private String nombre;

    @OneToMany(mappedBy = "pelicula")
    private List<Boleto> listaBoletos;



}

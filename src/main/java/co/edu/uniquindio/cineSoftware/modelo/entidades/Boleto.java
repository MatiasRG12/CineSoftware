package co.edu.uniquindio.cineSoftware.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.io.Serializable;

@Entity
public class Boleto implements Serializable {

    @Id
    private String codigo;

    private float precio;

    @ManyToOne
    private Cliente cliente;

    @OneToOne
    private Silla silla;

    @ManyToOne
    private Pelicula pelicula;
}

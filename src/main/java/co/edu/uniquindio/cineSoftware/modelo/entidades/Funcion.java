package co.edu.uniquindio.cineSoftware.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Entity
public class Funcion implements Serializable {

    @Id
    private String codigo;

    private int duracionMinutos;

    @ManyToOne
    private Sala sala;
}

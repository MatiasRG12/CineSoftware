package co.edu.uniquindio.cineSoftware.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.io.Serializable;

@Entity
public class Silla implements Serializable {

    @Id
    private String codigo;

    @OneToOne
    private Boleto boleto;

    @ManyToOne
    private Sala sala;
}

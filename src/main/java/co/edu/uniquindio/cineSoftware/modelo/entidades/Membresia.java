package co.edu.uniquindio.cineSoftware.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.io.Serializable;

@Entity
public class Membresia implements Serializable {

    @Id
    private String codigo;

    private float saldo;

    @OneToOne
    private Cliente cliente;
}

package co.edu.uniquindio.cineSoftware.modelo.entidades;

import co.edu.uniquindio.cineSoftware.modelo.enumeraciones.EstadoPqrs;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Entity
public class Pqrs implements Serializable {

    @Id
    private String codigo;

    private String motivo;

    private EstadoPqrs estado;

    @ManyToOne
    private Administrador administrador;

    @ManyToOne
    private Cliente cliente;
}

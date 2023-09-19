package co.edu.uniquindio.cineSoftware.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.io.Serializable;

@Entity
public class Producto implements Serializable {

    @Id
    private String codigo;

    private String nombre;

    private float precio;

}

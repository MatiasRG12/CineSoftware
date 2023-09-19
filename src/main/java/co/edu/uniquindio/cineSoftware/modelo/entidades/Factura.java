package co.edu.uniquindio.cineSoftware.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Factura implements Serializable {

    @Id
    private String codigo;

    //relacion muchos a muchos con producto (tabla intermedia)


}

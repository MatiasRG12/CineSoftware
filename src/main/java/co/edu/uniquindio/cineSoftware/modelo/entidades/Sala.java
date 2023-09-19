package co.edu.uniquindio.cineSoftware.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.List;

@Entity
public class Sala implements Serializable {

    @Id
    private String codigo;

    private String nombre;
    private int capacidad;

    @OneToMany(mappedBy = "sala")
    private List<Funcion> listaFunciones;

    @OneToMany(mappedBy = "sala")
    private List<Silla> listaSillas;

    @ManyToOne
    private Teatro teatro;
}

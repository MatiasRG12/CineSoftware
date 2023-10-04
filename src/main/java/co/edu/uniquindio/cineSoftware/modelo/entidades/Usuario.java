package co.edu.uniquindio.cineSoftware.modelo.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    private String nombreUsuario;
    private String contrasenia;
}

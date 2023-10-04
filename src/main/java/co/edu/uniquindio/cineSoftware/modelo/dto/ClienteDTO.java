package co.edu.uniquindio.cineSoftware.modelo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ClienteDTO {

    @NotNull
    private int codigo;

    private String nombre;

    @NotNull
    private String nombreUsuario;

    @NotNull
    private String contrasenia;


}

package co.edu.uniquindio.cineSoftware.modelo.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@Getter
@Setter
public class SesionDTO {

    @NotEmpty(message = "No puede estar vacio")
    @Length(max = 30, message = "{user.id.length}")
    private String nombreUsuario;

    @NotEmpty(message = "contraseña no puede ser vacia")
    @Length(max = 150, message = "{user.password.length}")
    private String contrasenia;
}

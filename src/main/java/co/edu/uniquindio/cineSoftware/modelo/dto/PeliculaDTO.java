package co.edu.uniquindio.cineSoftware.modelo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@Getter
@Setter
public class PeliculaDTO {

    @NotNull
    private String codigo;

    @NotNull
    @Length(max = 50)
    private String nombre;

    @NotNull
    @Length(max = 3)
    private int duracionMinutos;

    //imagen

}

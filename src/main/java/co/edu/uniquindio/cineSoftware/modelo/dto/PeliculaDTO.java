package co.edu.uniquindio.cineSoftware.modelo.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@Getter
@Setter
public class PeliculaDTO {

    @NotEmpty
    @Length(max = 50)
    private String nombre;

    @NotEmpty
    @Length(max = 3)
    private int duracionMinutos;

    //imagen

}

package co.edu.uniquindio.cineSoftware.modelo.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class PeliculaDTO {

    @NotNull
    private Long codigo;

    @NotNull
    @Length(max = 50)
    private String nombre;

    @NotNull
    private int duracionMinutos;

    /**
     * Cambio
     */
    @NotNull
    private String link;

    //imagen

    private List<String> listaHorarios;
}

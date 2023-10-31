package co.edu.uniquindio.cineSoftware.modelo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginDTO(

        @NotBlank
        String usuario,

        @NotBlank
        String contrasenia
) {
}

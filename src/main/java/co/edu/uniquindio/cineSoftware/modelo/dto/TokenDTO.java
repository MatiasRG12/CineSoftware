package co.edu.uniquindio.cineSoftware.modelo.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TokenDTO {
    @NotEmpty(message = "{token.empty}")
    private String token;
}

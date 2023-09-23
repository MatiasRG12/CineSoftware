package co.edu.uniquindio.cineSoftware.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class MensajeDTO<T> {

    private HttpStatus status;
    private boolean error;
    private T message;
    private T response;

}

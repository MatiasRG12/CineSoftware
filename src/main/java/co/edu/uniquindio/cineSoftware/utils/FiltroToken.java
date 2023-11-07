package co.edu.uniquindio.cineSoftware.utils;

import co.edu.uniquindio.cineSoftware.modelo.dto.MensajeDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.Base64;
import java.util.Enumeration;

@Component
@RequiredArgsConstructor
public class FiltroToken implements Filter{

    private final JWTUtils jwtUtils;
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String requestURI = req.getRequestURI();
        String token = getToken(req);
        boolean error = true;
        try{
            if ((requestURI.startsWith("/catalogoP/eliminarP") && req.getMethod().equals("DELETE")) || (requestURI.startsWith("/catalogoP/agregarP") && req.getMethod().equals("POST")) || requestURI.startsWith("/boleteria")){

                if (token != null) {

                    //Jws<Claims> jws = jwtUtils.parseJwt(token);
                    String rol = decodificarToken(token);
                    if (!rol.contains("administrador") && !rol.contains("cliente")){
                        crearRespuestaError("No tiene los permisos para acceder",HttpServletResponse.SC_FORBIDDEN,res);
                    }else{
                        error = false;
                    }
                }else{
                    crearRespuestaError("No hay un Token",HttpServletResponse.SC_FORBIDDEN,res);
                }
            }else {
                error = false;
            }
        }catch (MalformedJwtException | SignatureException e){
            crearRespuestaError("El token es incorrecto", HttpServletResponse.SC_INTERNAL_SERVER_ERROR, res);
        }catch (ExpiredJwtException e ){
            crearRespuestaError("El token está vencido", HttpServletResponse.SC_INTERNAL_SERVER_ERROR, res);
        }catch (Exception e){
            crearRespuestaError(e.getMessage(), HttpServletResponse.SC_INTERNAL_SERVER_ERROR, res);
        }
        chain.doFilter(request, response);
    }

    private String decodificarToken(String token) {
        String[] partes = token.split("\\.");
        byte[] aux = Base64.getDecoder().decode(partes[1]);
        return new String(aux);
    }

    private void crearRespuestaError(String mensaje, int scForbidden, HttpServletResponse response) throws IOException{
        MensajeDTO<String> dto = new MensajeDTO<>(null,true, mensaje,null);
        response.setContentType("application/json");
        response.getWriter().write(new ObjectMapper().writeValueAsString(dto));
        response.getWriter().flush();
        response.getWriter().close();
    }

    private String getToken(HttpServletRequest req) {
        String header = req.getHeader("Authorization");
        if(header != null && header.startsWith("Bearer "))
            return header.replace("Bearer ", "");
        return null;
    }

}

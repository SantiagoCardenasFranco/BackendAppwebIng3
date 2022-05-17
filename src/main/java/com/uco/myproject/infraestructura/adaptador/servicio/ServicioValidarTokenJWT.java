package com.uco.myproject.infraestructura.adaptador.servicio;

import com.auth0.jwt.JWT;
import com.uco.myproject.infraestructura.servicio.ServicioValidarToken;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import io.jsonwebtoken.impl.crypto.DefaultJwtSignatureValidator;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

@Component
public class ServicioValidarTokenJWT implements ServicioValidarToken {

    private final Environment environment;

    public ServicioValidarTokenJWT(Environment environment) {
        this.environment = environment;
    }


    @Override
    public boolean esValido(String token) {
        if(token == null || token.isBlank()) {
            return false;
        }

        SignatureAlgorithm algorithm = SignatureAlgorithm.HS256;
        SecretKeySpec secretKeySpec = new SecretKeySpec(TextCodec.BASE64.decode(this.environment.getRequiredProperty("token.key")),
                algorithm.getJcaName());

        String[] chunks = token.split("\\.");
        String tokenWithoutSignature = chunks[0] + "." + chunks[1];
        String signature = chunks[2];

        DefaultJwtSignatureValidator validator = new DefaultJwtSignatureValidator(algorithm, secretKeySpec);

        return validator.isValid(tokenWithoutSignature, signature) && JWT.decode(token).getExpiresAt().after(new Date());

    }
}

package com.uco.myproject.infraestructura.configuracion;

import com.uco.myproject.infraestructura.filtro.FiltroAutenticacion;
import com.uco.myproject.infraestructura.servicio.ServicioValidarToken;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationSecurity {

    private static final String URL_PATTERN = "/*";

    @Bean
    public FilterRegistrationBean<FiltroAutenticacion> authenticationFilter(ServicioValidarToken tokenValidationService){
        FilterRegistrationBean<FiltroAutenticacion> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new FiltroAutenticacion(tokenValidationService, new String[]{"/api/login","/api/usuarios",
                "/swagger-ui.html","/swagger-ui/index.html","/v3/api-docs/swagger-config","/v3/api-docs",
                "*.js","*.css","*.png"}));
        registrationBean.addUrlPatterns(URL_PATTERN);

        return registrationBean;
    }
}

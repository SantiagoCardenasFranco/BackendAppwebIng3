package com.uco.myproject.infraestructura.controlador;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uco.myproject.aplicacion.dto.DtoLogin;
import com.uco.myproject.aplicacion.dto.DtoTamano;
import com.uco.myproject.aplicacion.dto.respuesta.DtoRespuesta;
import com.uco.myproject.dominio.puerto.RepositorioTamano;
import com.uco.myproject.infraestructura.ApplicationMock;
import com.uco.myproject.infraestructura.testdatabuilder.DtoLoginTestDataBuilder;
import com.uco.myproject.infraestructura.testdatabuilder.DtoTamanoTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = ApplicationMock.class)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ControladorTamanoTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    RepositorioTamano repositorioTamano;

    @Test
    @DisplayName("Debe crear un tamaño de forma exitosa y luego fallar al crear el mismo")
    void crearDuplicadaTest() throws Exception {

        // arrange
        var dto = new DtoTamanoTestDataBuilder().build();

        String token = obtenerToken();

        crear(dto, token);

        // act - assert
        mocMvc.perform(MockMvcRequestBuilders.post("/api/tamanos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization",token)
                        .content(objectMapper.writeValueAsString(dto))
                )
                .andExpect(status().isConflict());
    }


    @Test
    @DisplayName("Debe crear un tamaño de forma exitosa y validar que si quedó guardado")
    void crearTest() throws Exception {

        var dto = new DtoTamanoTestDataBuilder().build();

        String token = obtenerToken();

        crear(dto, token);
    }

    private void crear(DtoTamano dto, String token) throws Exception {
        // arrange

        // act
        var result = mocMvc.perform(MockMvcRequestBuilders.post("/api/tamanos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto))
                        .header("Authorization",token)
                )
                .andExpect(status().isOk())
                .andReturn();

        //assert
        var jsonResult = result.getResponse().getContentAsString();
        DtoRespuesta<Integer> respuesta = objectMapper.readValue(jsonResult, DtoRespuesta.class);

        Long id = respuesta.getValor().longValue();
        Assertions.assertNotNull(id);

        var tamano = repositorioTamano.consultarPorId(id);

        Assertions.assertEquals(dto.getNombre(), tamano.getNombre());
        Assertions.assertEquals(dto.getEspecificacion(), tamano.getEspecificacion());
    }

    @Test
    @DisplayName("Debe listar los tamaños luego de crearlos")
    void listarTest() throws Exception {

        var dto = new DtoTamanoTestDataBuilder().build();

        String token = obtenerToken();

        crear(dto, token);

        mocMvc.perform(get("/api/tamanos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization",token))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[1].nombre", is(dto.getNombre())))
                .andExpect(jsonPath("$[1].especificacion", is(dto.getEspecificacion())));
    }

    private String obtenerToken() throws Exception {
        DtoLogin login = new DtoLoginTestDataBuilder().build();
        var resultLogin = mocMvc.perform(MockMvcRequestBuilders.post("/api/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(login))
                )
                .andExpect(status().isOk())
                .andReturn();

        return (String) objectMapper.readValue(resultLogin.getResponse().getContentAsString(), DtoRespuesta.class).getValor();
    }
}
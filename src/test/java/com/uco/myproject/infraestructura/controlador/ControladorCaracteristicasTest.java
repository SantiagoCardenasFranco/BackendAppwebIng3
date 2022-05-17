package com.uco.myproject.infraestructura.controlador;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uco.myproject.aplicacion.dto.DtoCaracteristica;
import com.uco.myproject.aplicacion.dto.respuesta.DtoRespuesta;
import com.uco.myproject.dominio.puerto.RepositorioCaracteristica;
import com.uco.myproject.infraestructura.ApplicationMock;
import com.uco.myproject.infraestructura.testdatabuilder.DtoCaracteristicaTestDataBuilder;
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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = ApplicationMock.class)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ControladorCaracteristicasTest {

    /*@Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    RepositorioCaracteristica repositorioCaracteristica;

    @Test
    @DisplayName("Debe crear una caracteristica de forma exitosa y luego fallar al crear el mismo")
    void crearDuplicadaTest() throws Exception {

        // arrange
        var dto = new DtoCaracteristicaTestDataBuilder().build();

        crear(dto);

        // act - assert
        mocMvc.perform(MockMvcRequestBuilders.post("/api/caracteristicas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto))
                )
                .andExpect(status().isConflict());
    }


    @Test
    @DisplayName("Debe crear una caracteristica de forma exitosa y validar que si quedó guardado")
    void crearTest() throws Exception {

        var dto = new DtoCaracteristicaTestDataBuilder().build();

        crear(dto);
    }

    private void crear(DtoCaracteristica dto) throws Exception {
        // arrange

        // act
        var result = mocMvc.perform(MockMvcRequestBuilders.post("/api/caracteristicas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto))
                )
                .andExpect(status().isOk())
                .andReturn();

        //assert
        var jsonResult = result.getResponse().getContentAsString();
        DtoRespuesta<Integer> respuesta = objectMapper.readValue(jsonResult, DtoRespuesta.class);

        Long id = respuesta.getValor().longValue();
        Assertions.assertNotNull(id);

        var caracteristica = repositorioCaracteristica.consultarPorId(id);

        Assertions.assertEquals(dto.getMarca(), caracteristica.getMarca());
        Assertions.assertEquals(dto.getDescripcion(), caracteristica.getDescripcion());
        Assertions.assertEquals(dto.getDtoTamano().getNombre(), caracteristica.getTamano().getNombre());
        Assertions.assertEquals(dto.getDtoTamano().getEspecificacion(), caracteristica.getTamano().getEspecificacion());
        Assertions.assertEquals(dto.getProveedor(), caracteristica.getProveedor());
    }
*/
}
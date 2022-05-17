package com.uco.myproject.infraestructura.controlador;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uco.myproject.aplicacion.dto.DtoProducto;
import com.uco.myproject.aplicacion.dto.respuesta.DtoRespuesta;
import com.uco.myproject.dominio.puerto.RepositorioProducto;
import com.uco.myproject.infraestructura.ApplicationMock;
import com.uco.myproject.infraestructura.testdatabuilder.DtoProductoTestDataBuilder;
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
class ControladorProductoTest {

    /*@Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    RepositorioProducto repositorioProducto;

    @Test
    @DisplayName("Debe crear un producto de forma exitosa y luego fallar al crear el mismo")
    void crearDuplicadaTest() throws Exception {

        // arrange
        var dto = new DtoProductoTestDataBuilder().build();

        crear(dto);

        // act - assert
        mocMvc.perform(MockMvcRequestBuilders.post("/api/productos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto))
                )
                .andExpect(status().isConflict());
    }


    @Test
    @DisplayName("Debe crear un producto de forma exitosa y validar que si quedó guardado")
    void crearTest() throws Exception {

        var dto = new DtoProductoTestDataBuilder().build();

        crear(dto);
    }

    private void crear(DtoProducto dto) throws Exception {
        // arrange

        // act
        var result = mocMvc.perform(MockMvcRequestBuilders.post("/api/productos")
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

        var producto = repositorioProducto.consultarPorId(id);

        Assertions.assertEquals(dto.getNombre(), producto.getNombre());
        Assertions.assertEquals(dto.getDtoUsuario().getNombre(), producto.getUsuario().getNombre());
        Assertions.assertEquals(dto.getDtoUsuario().getApellido(), producto.getUsuario().getApellido());
        Assertions.assertEquals(dto.getDtoUsuario().getCorreo(), producto.getUsuario().getCorreo());
        Assertions.assertEquals(dto.getDtoUsuario().getPassword(), producto.getUsuario().getPassword());
        Assertions.assertEquals(dto.getDtoCaracteristica().getMarca(), producto.getCaracteristica().getMarca());
        Assertions.assertEquals(dto.getDtoCaracteristica().getDescripcion(), producto.getCaracteristica().getDescripcion());
        Assertions.assertEquals(dto.getDtoCaracteristica().getDtoTamano().getNombre(), producto.getCaracteristica().getTamano().getNombre());
        Assertions.assertEquals(dto.getDtoCaracteristica().getDtoTamano().getEspecificacion(), producto.getCaracteristica().getTamano().getEspecificacion());
        Assertions.assertEquals(dto.getDtoCaracteristica().getProveedor(), producto.getCaracteristica().getProveedor());
    }
*/
}
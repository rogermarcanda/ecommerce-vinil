package br.com.ecommercevinil.controller;

import br.com.ecommercevinil.service.DiscoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = DiscoController.class)
public class DiscoControllerTests {

    private static final String URL_DISCO = "/disco";
    private static final String PARAMETRO_ID_GENERO = "idGenero";
    private static final String PARAMETRO_ID_DISCO = "idDisco";

    private static final MediaType CONTENT_TYPE = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    public MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private DiscoService discoService;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void buscar_discos_filtrado_pelo_genero_paginado_ordenado_nome() throws Exception {

        mockMvc.perform(
                get(URL_DISCO)
                .contentType(CONTENT_TYPE)
                .param(PARAMETRO_ID_GENERO, "1")
            )
            .andExpect(status().isOk())
            .andReturn();
    }

    @Test
    public void buscar_disco_por_id() throws Exception {

        mockMvc.perform(
                get(URL_DISCO + "/1")
                        .contentType(CONTENT_TYPE)
        )
                .andExpect(status().isOk())
                .andReturn();
    }
}

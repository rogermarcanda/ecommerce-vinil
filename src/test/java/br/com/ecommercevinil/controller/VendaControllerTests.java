package br.com.ecommercevinil.controller;

import br.com.ecommercevinil.model.Venda;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = VendaController.class)
@Ignore("")
public class VendaControllerTests {

    private static final String URL_VENDA = "/venda";
    private static final String PARAMETRO_DATA_INICIAL = "dataInicial";
    private static final String PARAMETRO_DATA_FINAL = "dataFinal";

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static final MediaType CONTENT_TYPE = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    public MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void buscar_vendas_filtrado_por_range_data_paginado_ordenado_data() throws Exception {

        mockMvc.perform(
                get(URL_VENDA)
                        .contentType(CONTENT_TYPE)
                        .param(PARAMETRO_DATA_INICIAL,"2019-02-01")
                        .param(PARAMETRO_DATA_FINAL,"2019-02-28")
        )
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void buscar_venda_por_id() throws Exception {

        mockMvc.perform(
                get(URL_VENDA + "/1")
                        .contentType(CONTENT_TYPE)
        )
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void vender() throws Exception {
        Venda venda = Venda.builder().build();
        mockMvc.perform(
                post(URL_VENDA)
                .contentType(CONTENT_TYPE)
                .content(asJsonString(venda))
        )
                .andExpect(status().isCreated())
                .andReturn();
    }

}

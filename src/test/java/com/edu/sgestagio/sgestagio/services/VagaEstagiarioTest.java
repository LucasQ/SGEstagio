package com.edu.sgestagio.sgestagio.services;

import com.edu.sgestagio.sgestagio.domain.Estagiario;
import com.edu.sgestagio.sgestagio.domain.Vaga;
import com.edu.sgestagio.sgestagio.domain.VagaEstagiario;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class VagaEstagiarioTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;

    @Test
    public void insertVagaEstagiarioTest() throws Exception {
        MvcResult mocVg = this.mockMvc.perform(get("/vagas/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        MvcResult mocEstagiario = this.mockMvc.perform(get("/estagiarios/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String vgResult = mapper.writeValueAsString(mocVg.getResponse().getContentAsString());

        String estResult = mapper.writeValueAsString(mocEstagiario.getResponse().getContentAsString());

        Vaga vg = mapper.readValue(vgResult, Vaga.class);
        Estagiario est = mapper.readValue(estResult, Estagiario.class);

        VagaEstagiario obj = new VagaEstagiario(null, vg, new Estagiario(1), new Date(),
                null, new Date());
        MvcResult mvcResultVE = this.mockMvc.perform(post("/vagaestagiario")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(obj)))
                .andExpect(status().isCreated())
                .andReturn();

        String result = mvcResultVE.getResponse().getContentAsString();
        VagaEstagiario ve = mapper.readValue(result, VagaEstagiario.class);

        Assertions.assertNull(ve.getDt_fim());
        Assertions.assertEquals(1, (int) ve.getId_vaga_estagiario());
        Assertions.assertTrue(equalsDate(ve.getDt_hr_atualiz(), new Date()));
    }

    private static boolean equalsDate(Date d1, Date d2) throws ParseException {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.parse(format.format(d1)).compareTo(format.parse(format.format(d2))) == 0;
    }
}

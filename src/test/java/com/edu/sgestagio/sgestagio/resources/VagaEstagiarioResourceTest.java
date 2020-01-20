package com.edu.sgestagio.sgestagio.resources;

import com.edu.sgestagio.sgestagio.domain.Estagiario;
import com.edu.sgestagio.sgestagio.domain.Vaga;
import com.edu.sgestagio.sgestagio.domain.VagaEstagiario;
import com.edu.sgestagio.sgestagio.domain.enums.Status;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

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
public class VagaEstagiarioResourceTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;

    @Test
    public void insertVagaEstagiarioTest() throws Exception {
//        Vaga vg = (Vaga) this.mockMvc.perform(get("/vagas/1"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andReturn();

//        String vgResult = mapper.writeValueAsString(mocVg.getResponse().getContentAsString());

//        Vaga vg = mapper.readValue(vgResult, Vaga.class);

        VagaEstagiario obj = new VagaEstagiario(null, new Vaga(1, Status.DISPONIVEL), new Estagiario(1), new Date(),
                null, new Date());
        this.mockMvc.perform(post("/vagaestagiario")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(obj)))
                .andExpect(status().isCreated());

//        String result = mvcResultVE.getResponse().getContentAsString();
//        VagaEstagiario ve = mapper.readValue(result, VagaEstagiario.class);
    }
}

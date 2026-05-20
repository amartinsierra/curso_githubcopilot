package com.capgemini.micropersonas.web;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.caixaba.absis.micropersonas.service.PersonasService;
import com.capgemini.micropersonas.api.domain.Persona;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(PersonasController.class)
@AutoConfigureMockMvc(addFilters = false)
class PersonasControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PersonasService personasService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testPersonasGet() throws Exception {
        Persona p1 = new Persona();
        p1.setNombre("Juan");
        p1.setEdad(30);
        p1.setEmail("juan@mail.com");
        
        Persona p2 = new Persona();
        p2.setNombre("Ana");
        p2.setEdad(25);
        p2.setEmail("ana@mail.com");
        
        List<Persona> personas = Arrays.asList(p1, p2);
        
        when(personasService.getAllPersonas()).thenReturn(personas);

        mockMvc.perform(get("/personas")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].nombre").value("Juan"))
                .andExpect(jsonPath("$[1].nombre").value("Ana"));
    }

    @Test
    void testPersonasIdGetFound() throws Exception {
        Persona p1 = new Persona();
        p1.setId(1);
        p1.setNombre("Juan");
        p1.setEmail("juan@mail.com");
        
        when(personasService.getPersonaById(1)).thenReturn(p1);

        mockMvc.perform(get("/personas/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Juan"));
    }

    @Test
    void testPersonasIdGetNotFound() throws Exception {
        when(personasService.getPersonaById(anyInt())).thenReturn(null);

        mockMvc.perform(get("/personas/99")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void testPersonasPost() throws Exception {
        Persona p1 = new Persona();
        p1.setNombre("Juan");
        p1.setEdad(30);
        p1.setEmail("juan@mail.com");
        
        Persona savedPersona = new Persona();
        savedPersona.setId(1);
        savedPersona.setNombre("Juan");
        savedPersona.setEdad(30);
        savedPersona.setEmail("juan@mail.com");
        
        when(personasService.createPersona(any(Persona.class))).thenReturn(savedPersona);

        mockMvc.perform(post("/personas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(p1)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nombre").value("Juan"));
    }

    @Test
    void testPersonasIdDelete() throws Exception {
        Persona p1 = new Persona();
        p1.setId(1);
        p1.setNombre("Juan");
        p1.setEmail("juan@mail.com");
        
        when(personasService.deletePersonaById(1)).thenReturn(p1);

        mockMvc.perform(delete("/personas/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    void testPersonasEdadesGet() throws Exception {
        Persona p1 = new Persona();
        p1.setNombre("Juan");
        p1.setEdad(30);
        p1.setEmail("juan@mail.com");
        
        List<Persona> personas = Arrays.asList(p1);
        
        when(personasService.getPersonasByEdadRange(20, 40)).thenReturn(personas);

        mockMvc.perform(get("/personas/edades")
                .param("min", "20")
                .param("max", "40")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].nombre").value("Juan"));
    }
}
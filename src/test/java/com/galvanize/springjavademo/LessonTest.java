package com.galvanize.springjavademo;

import com.galvanize.springjavademo.dao.LessonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import javax.transaction.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
public class LessonTest {

    @Autowired
    MockMvc mvc;
    @Autowired
    LessonRepository repository;

    @Test
    @Transactional
    @Rollback
    public void testCreate() throws Exception {
        MockHttpServletRequestBuilder request = post("/lesson")
                .contentType(MediaType.APPLICATION_JSON)
                .contentType("{\"1\": \"Physics 101\"}");
    }

    @Test
    @Transactional
    @Rollback
    public void testPatch() throws Exception {
        MockHttpServletRequestBuilder request = patch("/lessons/2")
                .contentType(MediaType.APPLICATION_JSON)
                .contentType("{\"2\": \"SQL\"}");
    }

}

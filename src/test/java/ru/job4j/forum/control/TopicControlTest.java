package ru.job4j.forum.control;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;

import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import ru.job4j.forum.Main;
import ru.job4j.forum.model.Topic;
import ru.job4j.forum.service.Service;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
class TopicControlTest {

    @MockBean
    private Service service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    public void createShouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/topic/edit")
                .param("id", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("topic/edit"));
    }

    @Test
    @WithMockUser
    public void topicShouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/topic")
                .param("id", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("topic/topic"));
    }

    @Test
    @WithMockUser
    public void saveShouldReturnDefaultMessage() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("id", "0");
        params.add("name", "Черный экран!");
        params.add("description", "Причина?");
        this.mockMvc.perform(post("/topic/save")
                .params(params))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<Topic> argument = ArgumentCaptor.forClass(Topic.class);
        verify(service).save(argument.capture());
        assertThat(argument.getValue().getName(), is("Черный экран!"));
        assertThat(argument.getValue().getDescription(), is("Причина?"));
    }
}
package com.grek.github.information.infrastructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void shouldReturnCorrectUserInformationDto() throws Exception {
        //given
        UserInformationDto userInformationDto = getUserInformationDto();
        Mockito.when(userService.getUserByLogin(any(String.class))).thenReturn(userInformationDto);
        //when
        MvcResult result = mockMvc.perform(get("/users/test")).andExpect(status().isOk())
                .andReturn();
        //then
        String body = result.getResponse().getContentAsString();
        UserInformationDto responseDto = objectMapper.readValue(body, UserInformationDto.class);
        assertEquals(userInformationDto,responseDto);
    }

    private UserInformationDto getUserInformationDto() {
        return UserInformationDto.builder()
                .login("login")
                .id(1L)
                .name("name")
                .type("type")
                .avatarUrl("avatarUrl")
                .createdAt(LocalDateTime.MIN)
                .calculations(12.5)
                .build();
    }

}
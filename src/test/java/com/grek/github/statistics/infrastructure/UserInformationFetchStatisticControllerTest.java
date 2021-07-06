package com.grek.github.statistics.infrastructure;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserInformationFetchStatisticControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserInformationFetchStatisticService fetchStatisticService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void shouldReturnCorrectFetchStatisticsDto() throws Exception {
        //given
        List<UserInformationFetchStatisticDto> statisticsDto = getUserInformationFetchStatisticsDto();
        Mockito.when(fetchStatisticService.getUserInformationFetchStatistics()).thenReturn(statisticsDto);
        //when
        MvcResult result = mockMvc.perform(get("/statistics")).andExpect(status().isOk())
                .andReturn();
        //then
        String body = result.getResponse().getContentAsString();
        List<UserInformationFetchStatisticDto> response = objectMapper.readValue(body, new TypeReference<>() {
        });
        assertEquals(statisticsDto, response);
    }

    @Test
    public void shouldReturnCorrectFetchStatisticsAfterPrepareThen() throws Exception {
        //given
        List<UserInformationFetchStatisticDto> statisticsDto = getUserInformationFetchStatisticsDto();
        Mockito.when(fetchStatisticService.prepareUserInformationFetchStatistic()).thenReturn(statisticsDto);
        //when
        MvcResult result = mockMvc.perform(put("/statistics")).andExpect(status().isCreated())
                .andReturn();
        //then
        String body = result.getResponse().getContentAsString();
        List<UserInformationFetchStatisticDto> response = objectMapper.readValue(body, new TypeReference<>() {
        });
        assertEquals(statisticsDto, response);
    }

    private List<UserInformationFetchStatisticDto> getUserInformationFetchStatisticsDto() {
        return Arrays.asList(
                UserInformationFetchStatisticDto.builder()
                        .login("testLogin")
                        .requestCount(12L)
                        .build(),
                UserInformationFetchStatisticDto.builder()
                        .login("testLogin2")
                        .requestCount(14L)
                        .build()
        );
    }
}
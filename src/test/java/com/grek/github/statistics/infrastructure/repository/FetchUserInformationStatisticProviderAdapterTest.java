package com.grek.github.statistics.infrastructure.repository;

import com.grek.github.statistics.domain.FetchUserInformationStatisticRequestCountData;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@DataJpaTest
class FetchUserInformationStatisticProviderAdapterTest {

    @Autowired
    private RequestCountRepository requestCountRepository;

    @Test
    void afterPrepareFetchUserInformationStatisticsRelationalDatabaseShouldHasThisStatistics() {
        //given
        FetchUserInformationStatisticRepository fetchUserInformationStatisticRepository = mock(FetchUserInformationStatisticRepository.class);
        Mockito.when(fetchUserInformationStatisticRepository
                .getStatisticForUserInformationRequestCount())
                .thenReturn(getFetchUserInformationStatisticsRequestCountData());
        FetchUserInformationStatisticProviderAdapter adapter = new FetchUserInformationStatisticProviderAdapter(
                fetchUserInformationStatisticRepository,
                requestCountRepository
        );
        //when
        adapter.prepareStatisticForUserInformationRequestCount();
        //then
        List<RequestCountEntity> requestCountEntities = requestCountRepository.findAll();
        assertEquals(requestCountEntities.size(), 2);
        List<FetchUserInformationStatisticRequestCountData> requestStatisticsData = requestCountEntities.stream()
                .map(RequestCountEntity::toData)
                .collect(Collectors.toList());
        assertEquals(requestStatisticsData, getFetchUserInformationStatisticsRequestCountData());
    }

    private List<FetchUserInformationStatisticRequestCountData> getFetchUserInformationStatisticsRequestCountData() {
        return Arrays.asList(
                FetchUserInformationStatisticRequestCountData.builder()
                        .login("test1")
                        .requestCount(1L)
                        .build(),
                FetchUserInformationStatisticRequestCountData.builder()
                        .login("test2")
                        .requestCount(2L)
                        .build()
        );
    }
}
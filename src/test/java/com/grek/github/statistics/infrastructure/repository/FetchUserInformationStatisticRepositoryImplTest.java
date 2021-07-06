package com.grek.github.statistics.infrastructure.repository;

import com.grek.github.statistics.domain.FetchUserInformationStatisticRequestCountData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
@ExtendWith(SpringExtension.class)
class FetchUserInformationStatisticRepositoryImplTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private FetchUserInformationStatisticRepository statisticRepository;

    private static final String LOGIN_1 = "login1";
    private static final String LOGIN_2 = "login2";

    @Test
    void shouldReturnCorrectStatisticsOfUserInformationRequestNumber() {
        //given
        FetchUserInformationStatisticRepositoryImpl repositoryImp = new FetchUserInformationStatisticRepositoryImpl(mongoTemplate);
        statisticRepository.saveAll(getFetchUserInformationStatisticDocuments());
        //when
        List<FetchUserInformationStatisticRequestCountData> result = repositoryImp.getStatisticForUserInformationRequestCount();
        //then
        assertEquals(result.size(), 2);
        assertEquals(getStatisticsRequestCountByLogin(LOGIN_1, result).getRequestCount(), 2);
        assertEquals(getStatisticsRequestCountByLogin(LOGIN_2, result).getRequestCount(), 1);
    }

    private FetchUserInformationStatisticRequestCountData getStatisticsRequestCountByLogin(String login, List<FetchUserInformationStatisticRequestCountData> response) {
        return response.stream()
                .filter(v -> v.getLogin().equals(login))
                .findAny()
                .orElse(FetchUserInformationStatisticRequestCountData.builder().build());
    }

    private List<FetchUserInformationStatisticDocument> getFetchUserInformationStatisticDocuments() {
        return Arrays.asList(
                new FetchUserInformationStatisticDocument(LOGIN_1, LocalDateTime.now()),
                new FetchUserInformationStatisticDocument(LOGIN_1, LocalDateTime.now()),
                new FetchUserInformationStatisticDocument(LOGIN_2, LocalDateTime.now())
        );
    }
}
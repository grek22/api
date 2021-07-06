package com.grek.github.statistics.infrastructure.repository;

import com.grek.github.statistics.domain.FetchUserInformationStatisticRequestCountData;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
class FetchUserInformationStatisticRequestCountResponse {

    @Field("_id")
    private String login;

    private Long requestCount;

    public FetchUserInformationStatisticRequestCountData toData() {
        return FetchUserInformationStatisticRequestCountData.builder()
                .login(login)
                .requestCount(requestCount)
                .build();
    }
}

package com.grek.github.statistics.domain;

import com.grek.github.statistics.infrastructure.UserInformationFetchStatisticDto;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class FetchUserInformationStatisticRequestCountData {
    private String login;
    private Long requestCount;

    public static UserInformationFetchStatisticDto toDto(FetchUserInformationStatisticRequestCountData countData) {
        return UserInformationFetchStatisticDto.builder()
                .requestCount(countData.getRequestCount())
                .login(countData.getLogin())
                .build();
    }
}


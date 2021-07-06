package com.grek.github.statistics.infrastructure;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserInformationFetchStatisticDto {
    private String login;
    private Long requestCount;
}

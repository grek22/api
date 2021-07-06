package com.grek.github.statistics.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class FetchUserInformationStatisticData {
    private String id;
    private String login;
    private LocalDateTime createdAt;
}

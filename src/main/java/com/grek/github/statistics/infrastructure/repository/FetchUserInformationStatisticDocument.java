package com.grek.github.statistics.infrastructure.repository;

import com.grek.github.statistics.domain.FetchUserInformationStatisticData;
import lombok.Data;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
class FetchUserInformationStatisticDocument {

    @Id
    private String id;

    private final String login;
    private final LocalDateTime createdAt;

    public FetchUserInformationStatisticDocument(String login, LocalDateTime createdAt) {
        this.login = login;
        this.createdAt = createdAt;
    }

    private void setId(String id) {

    }

    public FetchUserInformationStatisticData toData() {
        return FetchUserInformationStatisticData.builder()
                .id(id)
                .login(login)
                .createdAt(createdAt)
                .build();
    }
}

package com.grek.github.statistics.infrastructure.repository;

import com.grek.github.statistics.domain.FetchUserInformationStatisticRequestCountData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
class RequestCountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long requestCount;
    private String login;

    public FetchUserInformationStatisticRequestCountData toData() {
        return FetchUserInformationStatisticRequestCountData.builder()
                .requestCount(requestCount)
                .login(login)
                .build();
    }

    static RequestCountEntity fromData(FetchUserInformationStatisticRequestCountData countData) {
        return RequestCountEntity.builder()
                .requestCount(countData.getRequestCount())
                .login(countData.getLogin())
                .build();
    }
}

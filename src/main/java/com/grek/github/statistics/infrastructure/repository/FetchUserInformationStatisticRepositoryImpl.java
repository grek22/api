package com.grek.github.statistics.infrastructure.repository;


import com.grek.github.statistics.domain.FetchUserInformationStatisticRequestCountData;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;

@Repository
@RequiredArgsConstructor
class FetchUserInformationStatisticRepositoryImpl implements FetchUserInformationStatisticRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    @Override
    public List<FetchUserInformationStatisticRequestCountData> getStatisticForUserInformationRequestCount() {
        Aggregation agg = newAggregation(
                group("login").count().as("requestCount")
        );
        AggregationResults<FetchUserInformationStatisticRequestCountResponse> result = mongoTemplate
                .aggregate(agg, "fetchUserInformationStatisticDocument", FetchUserInformationStatisticRequestCountResponse.class);
        List<FetchUserInformationStatisticRequestCountResponse> requestCountResponse = result.getMappedResults();
        return requestCountResponse.stream()
                .map(FetchUserInformationStatisticRequestCountResponse::toData)
                .collect(Collectors.toList());
    }
}

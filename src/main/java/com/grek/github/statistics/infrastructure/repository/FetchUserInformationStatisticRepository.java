package com.grek.github.statistics.infrastructure.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface FetchUserInformationStatisticRepository extends MongoRepository<FetchUserInformationStatisticDocument, String>,
        FetchUserInformationStatisticRepositoryCustom {
}

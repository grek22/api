package com.grek.github.statistics.infrastructure.repository;

import com.grek.github.statistics.domain.FetchUserInformationStatisticRequestCountData;

import java.util.List;

interface FetchUserInformationStatisticRepositoryCustom {
    List<FetchUserInformationStatisticRequestCountData> getStatisticForUserInformationRequestCount();
}

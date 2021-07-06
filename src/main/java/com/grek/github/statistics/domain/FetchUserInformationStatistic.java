package com.grek.github.statistics.domain;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
class FetchUserInformationStatistic {

    protected final FetchUserInformationStatisticProvider statisticProvider;

    void saveTrayOfFetchUserInformationForStatistic(String login) {
        statisticProvider.saveTrayOfFetchUserInformationForStatistic(login);
    }

    public List<FetchUserInformationStatisticRequestCountData> prepareStatisticsForUserInformationRequestCount() {
        return statisticProvider.prepareStatisticForUserInformationRequestCount();
    }

    public List<FetchUserInformationStatisticRequestCountData> getStatisticsForUserInformationRequestCount() {
       return statisticProvider.getStatisticsForUserInformationRequestCount();
    }
}

package com.grek.github.statistics.domain;

import java.util.List;

public class FetchUserInformationStatisticFacade {

    private final FetchUserInformationStatistic informationStatistic;

    public FetchUserInformationStatisticFacade(FetchUserInformationStatisticProvider statisticProvider) {
        informationStatistic = new FetchUserInformationStatistic(statisticProvider);
    }

    public void saveTrayOfFetchUserInformationForStatistic(String login) {
        informationStatistic.saveTrayOfFetchUserInformationForStatistic(login);
    }

    public List<FetchUserInformationStatisticRequestCountData> prepareStatisticsForUserInformationRequestCount() {
        return informationStatistic.prepareStatisticsForUserInformationRequestCount();
    }

    public List<FetchUserInformationStatisticRequestCountData> getStatisticsForUserInformationRequestCount() {
        return informationStatistic.getStatisticsForUserInformationRequestCount();
    }
}

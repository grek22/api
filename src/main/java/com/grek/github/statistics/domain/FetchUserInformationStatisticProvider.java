package com.grek.github.statistics.domain;

import java.util.List;

public interface FetchUserInformationStatisticProvider {
    FetchUserInformationStatisticData saveTrayOfFetchUserInformationForStatistic(String login);

    List<FetchUserInformationStatisticRequestCountData> prepareStatisticForUserInformationRequestCount();

    List<FetchUserInformationStatisticRequestCountData> getStatisticsForUserInformationRequestCount();
}

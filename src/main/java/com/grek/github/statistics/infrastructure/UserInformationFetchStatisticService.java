package com.grek.github.statistics.infrastructure;

import com.grek.github.statistics.domain.FetchUserInformationStatisticFacade;
import com.grek.github.statistics.domain.FetchUserInformationStatisticRequestCountData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class UserInformationFetchStatisticService {

    private final FetchUserInformationStatisticFacade fetchUserInformationStatisticFacade;

    List<UserInformationFetchStatisticDto> prepareUserInformationFetchStatistic() {
        return fetchUserInformationStatisticFacade.prepareStatisticsForUserInformationRequestCount().stream()
                .map(FetchUserInformationStatisticRequestCountData::toDto)
                .collect(Collectors.toList());
    }

    List<UserInformationFetchStatisticDto> getUserInformationFetchStatistics() {
       return fetchUserInformationStatisticFacade.getStatisticsForUserInformationRequestCount().stream()
                .map(FetchUserInformationStatisticRequestCountData::toDto)
                .collect(Collectors.toList());
    }
}

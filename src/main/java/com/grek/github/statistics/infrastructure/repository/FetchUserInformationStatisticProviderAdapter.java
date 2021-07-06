package com.grek.github.statistics.infrastructure.repository;

import com.grek.github.statistics.domain.FetchUserInformationStatisticData;
import com.grek.github.statistics.domain.FetchUserInformationStatisticProvider;
import com.grek.github.statistics.domain.FetchUserInformationStatisticRequestCountData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
class FetchUserInformationStatisticProviderAdapter implements FetchUserInformationStatisticProvider {

    private final FetchUserInformationStatisticRepository statisticRepository;
    private final RequestCountRepository requestCountRepository;

    @Override
    public FetchUserInformationStatisticData saveTrayOfFetchUserInformationForStatistic(String login) {
        FetchUserInformationStatisticDocument statisticDocument = new FetchUserInformationStatisticDocument(login, LocalDateTime.now());
        statisticDocument = statisticRepository.save(statisticDocument);
        return statisticDocument.toData();
    }

    @Override
    public List<FetchUserInformationStatisticRequestCountData> prepareStatisticForUserInformationRequestCount() {
        List<FetchUserInformationStatisticRequestCountData> statisticRequestCountData =
                getStatisticForUserInformationRequestCount();
        return saveRequestCountStatistic(statisticRequestCountData);
    }

    @Override
    public List<FetchUserInformationStatisticRequestCountData> getStatisticsForUserInformationRequestCount() {
        return getStatisticForUserInformationRequestCount();
    }

    private List<FetchUserInformationStatisticRequestCountData> saveRequestCountStatistic(List<FetchUserInformationStatisticRequestCountData> statisticsRequestCount) {
        List<RequestCountEntity> requestCountEntities = statisticsRequestCount.stream()
                .map(RequestCountEntity::fromData)
                .collect(Collectors.toList());
        requestCountRepository.deleteAll();
        return requestCountRepository.saveAll(requestCountEntities).stream()
                .map(RequestCountEntity::toData)
                .collect(Collectors.toList());
    }

    private List<FetchUserInformationStatisticRequestCountData> getStatisticForUserInformationRequestCount() {
        return statisticRepository.getStatisticForUserInformationRequestCount();
    }
}

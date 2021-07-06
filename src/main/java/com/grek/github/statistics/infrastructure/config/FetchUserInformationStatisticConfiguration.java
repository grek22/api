package com.grek.github.statistics.infrastructure.config;

import com.grek.github.statistics.domain.FetchUserInformationStatisticFacade;
import com.grek.github.statistics.domain.FetchUserInformationStatisticProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class FetchUserInformationStatisticConfiguration {

    @Bean
    FetchUserInformationStatisticFacade fetchUserInformationStatisticFacade(
            FetchUserInformationStatisticProvider statisticProvider) {
        return new FetchUserInformationStatisticFacade(statisticProvider);
    }
}

package com.grek.github.information.infrastructure;

import com.grek.github.information.domain.UserInformationData;
import com.grek.github.information.domain.UserInformationFacade;
import com.grek.github.statistics.domain.FetchUserInformationStatisticFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class UserService {

    private final UserInformationFacade userInformationFacade;
    private final FetchUserInformationStatisticFacade statisticFacade;

    UserInformationDto getUserByLogin(String login) {
        final UserInformationData userInformationData = userInformationFacade.getUserInformationByLogin(login);
        statisticFacade.saveTrayOfFetchUserInformationForStatistic(login);
        return userInformationData.toDto();
    }
}

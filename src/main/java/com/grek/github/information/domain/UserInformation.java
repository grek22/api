package com.grek.github.information.domain;

import com.grek.github.information.infrastructure.exception.InformationException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class UserInformation {

    private final UserInformationProvider userInformationProvider;

    UserInformationData getUserInformationByLogin(String login) {
        final UserInformationData userInformationData =
                userInformationProvider.getUserInformationByLogin(login)
                        .orElseThrow(() -> new InformationException("user not found"));
        userInformationData.setCalculations(getCalculations(userInformationData));
        return userInformationData;
    }

    private double getCalculations(UserInformationData userInformationData) {
        final Long followersNumber = userInformationData.getFollowers();
        final Long publicReposNumber = userInformationData.getPublicRepos();
        return followersNumber == 0 ? -1 : 6.0 / followersNumber * (2 + publicReposNumber);
    }
}

package com.grek.github.information.domain;

import java.util.Optional;

public interface UserInformationProvider {

    Optional<UserInformationData> getUserInformationByLogin(String login);

}

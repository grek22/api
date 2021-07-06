package com.grek.github.information.domain;


public class UserInformationFacade {

    private final UserInformation userInformation;

    public UserInformationFacade(UserInformationProvider userInformationProvider) {
        this.userInformation = new UserInformation(userInformationProvider);
    }

    public UserInformationData getUserInformationByLogin(String login) {
      return userInformation.getUserInformationByLogin(login);
    }

}

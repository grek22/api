package com.grek.github.information.infrastructure.config;

import com.grek.github.information.domain.UserInformationFacade;
import com.grek.github.information.domain.UserInformationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserInformationConfiguration {

    @Bean
    UserInformationFacade userFacade(UserInformationProvider userInformationProvider) {
        return new UserInformationFacade(userInformationProvider);
    }

}

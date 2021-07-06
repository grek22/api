package com.grek.github.information.infrastructure.repository;

import com.grek.github.information.domain.UserInformationData;
import com.grek.github.information.domain.UserInformationProvider;
import com.grek.github.information.infrastructure.exception.InformationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class UserInformationProviderAdapter implements UserInformationProvider {
    @Override
    public Optional<UserInformationData> getUserInformationByLogin(String login) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.github.com/users/";
        Optional<UserInformationData> userInformationData;
        try {
            ResponseEntity<UserInformationResponse> userResponseEntity = restTemplate
                    .getForEntity(url + login, UserInformationResponse.class);
            userInformationData = getUserInformationData(userResponseEntity);
        } catch (Exception ex) {
            throw new InformationException("error while fetch user information");
        }
        return userInformationData;
    }

    private Optional<UserInformationData> getUserInformationData(ResponseEntity<UserInformationResponse> userResponseEntity) {
        if (userResponseEntity.getBody() == null) {
            return Optional.empty();
        } else {
            return Optional.of(userResponseEntity.getBody().toData());
        }
    }

}

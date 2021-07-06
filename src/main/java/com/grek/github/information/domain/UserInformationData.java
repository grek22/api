package com.grek.github.information.domain;

import com.grek.github.information.infrastructure.UserInformationDto;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserInformationData {
    private String nodeId;
    private String avatarUrl;
    private String gravatarId;
    private String followersUrl;
    private String followingUrl;
    private String gistsUrl;
    private String starredUrl;
    private String subscriptionsUrl;
    private String organizationsUrl;
    private String reposUrl;
    private String eventsUrl;
    private String receivedEventsUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String siteAdmin;
    private String twitterUsername;
    private String htmlUrl;
    private Long publicRepos;
    private Long publicGists;
    private String type;
    private String name;
    private String company;
    private String blog;
    private String location;
    private String email;
    private String hireable;
    private String bio;
    private Long followers;
    private Long following;
    private String url;
    private String login;
    private Long id;
    private Double calculations;

    public UserInformationDto toDto() {
        return UserInformationDto.builder()
                .id(id)
                .login(login)
                .name(name)
                .type(type)
                .avatarUrl(avatarUrl)
                .createdAt(createdAt)
                .calculations(calculations)
                .build();
    }
}

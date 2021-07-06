package com.grek.github.information.infrastructure.repository;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.grek.github.information.domain.UserInformationData;
import lombok.Data;

import java.time.LocalDateTime;

@Data
class UserInformationResponse {

    @JsonProperty("node_id")
    private String nodeId;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    @JsonProperty("gravatar_id")
    private String gravatarId;

    @JsonProperty("followers_url")
    private String followersUrl;

    @JsonProperty("following_url")
    private String followingUrl;

    @JsonProperty("gists_url")
    private String gistsUrl;

    @JsonProperty("starred_url")
    private String starredUrl;

    @JsonProperty("subscriptions_url")
    private String subscriptionsUrl;

    @JsonProperty("organizations_url")
    private String organizationsUrl;

    @JsonProperty("repos_url")
    private String reposUrl;

    @JsonProperty("events_url")
    private String eventsUrl;

    @JsonProperty("received_events_url")
    private String receivedEventsUrl;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    @JsonProperty("site_admin")
    private String siteAdmin;

    @JsonProperty("twitter_username")
    private String twitterUsername;

    @JsonProperty("html_url")
    private String htmlUrl;

    @JsonProperty("public_repos")
    private Long publicRepos;

    @JsonProperty("public_gists")
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

    public UserInformationData toData() {
        return UserInformationData.builder()
                .nodeId(nodeId)
                .avatarUrl(avatarUrl)
                .gravatarId(gravatarId)
                .followersUrl(followersUrl)
                .followingUrl(followingUrl)
                .gistsUrl(gistsUrl)
                .starredUrl(starredUrl)
                .subscriptionsUrl(subscriptionsUrl)
                .organizationsUrl(organizationsUrl)
                .reposUrl(reposUrl)
                .eventsUrl(eventsUrl)
                .receivedEventsUrl(receivedEventsUrl)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .type(type)
                .siteAdmin(siteAdmin)
                .name(name)
                .company(company)
                .blog(blog)
                .location(location)
                .email(email)
                .hireable(hireable)
                .bio(bio)
                .twitterUsername(twitterUsername)
                .publicRepos(publicRepos)
                .publicGists(publicGists)
                .followers(followers)
                .following(following)
                .url(url)
                .htmlUrl(htmlUrl)
                .login(login)
                .id(id)
                .build();
    }
}

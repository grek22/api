package com.grek.github.information.domain

import spock.lang.Specification

class UserInformationTest extends Specification {

    def "should return correct value of calculations"() {
        given:
        def userInformationProvider = Stub(UserInformationProvider)
        userInformationProvider.getUserInformationByLogin(_ as String) >> getUserInformationDataOptional(followers, publicRepos)
        def userInformation = new UserInformation(userInformationProvider)
        when:
        def userInformationData = userInformation.getUserInformationByLogin("123")
        then:
        userInformationData.calculations == calculations
        where:
        followers | publicRepos || calculations
        1         | 2           || 24
        0         | 2           || -1
    }

    static getUserInformationDataOptional(Long followers, Long publicRepos) {
        def userInformationData = UserInformationData.builder()
                .followers(followers)
                .publicRepos(publicRepos)
                .build()
        Optional.of(userInformationData)
    }
}

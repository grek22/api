package com.grek.github.statistics.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/statistics")
@RequiredArgsConstructor
public class UserInformationFetchStatisticController {

    private final UserInformationFetchStatisticService userInformationFetchStatisticService;

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserInformationFetchStatisticDto>> prepareUserInformationFetchStatistics() {
        final List<UserInformationFetchStatisticDto> fetchStatistics = userInformationFetchStatisticService
                .prepareUserInformationFetchStatistic();
        return new ResponseEntity<>(fetchStatistics, HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserInformationFetchStatisticDto>> getUserInformationFetchStatistics() {
        final List<UserInformationFetchStatisticDto> fetchStatistics = userInformationFetchStatisticService
                .getUserInformationFetchStatistics();
        return new ResponseEntity<>(fetchStatistics, HttpStatus.OK);
    }
}
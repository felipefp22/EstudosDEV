package com.aprendendoRest.aprendendoRestViajens.controller;

import com.aprendendoRest.aprendendoRestViajens.model.Statistic;
import com.aprendendoRest.aprendendoRestViajens.model.Travel;
import com.aprendendoRest.aprendendoRestViajens.service.StatisticService;
import com.aprendendoRest.aprendendoRestViajens.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;


@RestController
@RequestMapping("/api-travels/statistics")
public class StatisticController {

    private static final Logger logger = Logger.getLogger(StatisticController.class);

    @Autowired
    private TravelService travelService;

    @Autowired
    private StatisticService statisticsService;

    @GetMapping(produces = { "application/json" })
    public ResponseEntity<Statistic> getStatistics() {

        List<Travel> travels = travelService.find();
        Statistic statistics = statisticsService.create(travels);

        logger.info(statistics);

        return ResponseEntity.ok(statistics);
    }
}
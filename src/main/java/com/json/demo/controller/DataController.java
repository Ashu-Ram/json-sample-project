package com.json.demo.controller;

import com.json.demo.Service.DataService;
import com.json.demo.model.MergedData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/data")
public class DataController {
    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/count")
    public Map<String, Long> getValidPointsCount() {
        return dataService.countValidPointsPerType();
    }

    @GetMapping("/average-ratings")
    public Map<String, Double> getAverageRatings() {
        return dataService.calculateAverageRatingPerType();
    }

    @GetMapping("/highest-reviewed")
    public MergedData getHighestReviewedLocation() {
        return dataService.findHighestReviewedLocation();
    }
}
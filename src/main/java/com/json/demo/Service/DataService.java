package com.json.demo.Service;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.json.demo.model.Location;
import com.json.demo.model.MergedData;
import com.json.demo.model.Metadata;
import com.json.demo.repository.DataRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;


import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DataService {
    private final DataRepository dataRepository;
    private List<Location> locations = new ArrayList<>();
    private List<Metadata> metadataList = new ArrayList<>();

    public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @PostConstruct
    public void loadData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        locations = mapper.readValue(new File("src/main/resources/sample/locations.json"), new TypeReference<>() {});
        metadataList = mapper.readValue(new File("src/main/resources/sample/metadata.json"), new TypeReference<>() {});
    }

    public Map<String, Long> countValidPointsPerType() {
        return dataRepository.getAllMergedData()
                .stream()
                .collect(Collectors.groupingBy(MergedData::getType, Collectors.counting()));
    }

    public Map<String, Double> calculateAverageRatingPerType() {
        return dataRepository.getAllMergedData()
                .stream()
                .collect(Collectors.groupingBy(MergedData::getType, Collectors.averagingDouble(MergedData::getRating)));
    }

    public MergedData findHighestReviewedLocation() {
        return dataRepository.getAllMergedData()
                .stream()
                .max(Comparator.comparingInt(MergedData::getReviews))
                .orElse(null);
    }
}

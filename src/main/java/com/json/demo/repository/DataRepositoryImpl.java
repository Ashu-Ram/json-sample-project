package com.json.demo.repository;


import com.json.demo.model.MergedData;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class DataRepositoryImpl implements DataRepository {
    private final List<MergedData> mergedData;

    public DataRepositoryImpl(List<MergedData> mergedData) {
        this.mergedData = mergedData;
    }

    @Override
    public List<MergedData> getAllMergedData() {
        return mergedData;
    }
}

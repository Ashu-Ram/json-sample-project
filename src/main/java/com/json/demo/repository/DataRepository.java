package com.json.demo.repository;


import com.json.demo.model.MergedData;

import java.util.List;

public interface DataRepository {
    List<MergedData> getAllMergedData();
}

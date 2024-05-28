package com.asorg.votingsystem.service;

import com.asorg.votingsystem.entity.District;
import com.asorg.votingsystem.entity.State;
import com.asorg.votingsystem.utils.JsonMapperUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
public class CacheService {

    private final ConcurrentMap<String, State> states = new ConcurrentHashMap<>();

    public ConcurrentMap<String, State> getStates() {
        return states;
    }

    public State getDistrictsList(String state) {
        return states.get(state);
    }

    @PostConstruct
    private void loadState() throws FileNotFoundException {
        List<District> districts = JsonMapperUtils.toObject(
                new FileReader("src/main/resources/districts.json"),
                new TypeReference<>() {
                });

        List<State> stateList = JsonMapperUtils.toObject(
                new FileReader("src/main/resources/states.json"),
                new TypeReference<>() {
                });

        stateList.forEach(state -> states.put(state.getName(), state));
        districts.forEach(district -> {
            if (states.containsKey(district.getState())) {
                states.get(district.getState()).getDistricts().add(district);
            }
        });
    }


}

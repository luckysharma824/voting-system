package com.asorg.votingsystem.entity;

import java.util.ArrayList;
import java.util.List;

public class State {
    private String iso;
    private String name;
    private List<District> districts;

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<District> getDistricts() {
        if (districts == null) {
            districts = new ArrayList<>();
        }
        return districts;
    }
}

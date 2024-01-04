package com.asorg.votingsystem.dto;

import com.asorg.votingsystem.enums.StateEnum;

public class BoothDetailDto {
    private Integer id;
    private StateEnum state;
    private String district;
    private String block;
    private String booth;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StateEnum getState() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getBooth() {
        return booth;
    }

    public void setBooth(String booth) {
        this.booth = booth;
    }
}

package com.asorg.votingsystem.dto;

import com.asorg.votingsystem.entity.BoothDetail;
import com.asorg.votingsystem.enums.StatusEnum;

public class VoterDto {
    private Integer id;
    private String voterId;
    private String name;
    private String username;
    private String password;
    private BoothDetailDto booth;
    private StatusEnum status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVoterId() {
        return voterId;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BoothDetailDto getBooth() {
        return booth;
    }

    public void setBooth(BoothDetailDto booth) {
        this.booth = booth;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}

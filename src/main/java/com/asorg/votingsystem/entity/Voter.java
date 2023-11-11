package com.asorg.votingsystem.entity;

import com.asorg.votingsystem.enums.StatusEnum;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
public class Voter extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Identity> identity;
    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private BoothDetail booth;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    public List<Identity> getIdentity() {
        return identity;
    }

    public void setIdentity(List<Identity> identity) {
        this.identity = identity;
    }

    public BoothDetail getBooth() {
        return booth;
    }

    public void setBooth(BoothDetail booth) {
        this.booth = booth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}

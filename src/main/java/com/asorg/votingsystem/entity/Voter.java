package com.asorg.votingsystem.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
public class Voter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Identity> identity;
    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private BoothDetail booth;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

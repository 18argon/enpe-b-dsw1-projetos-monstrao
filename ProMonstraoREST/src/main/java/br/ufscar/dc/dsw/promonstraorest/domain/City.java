package br.ufscar.dc.dsw.promonstraorest.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@JsonIgnoreProperties(value = {"id"})
public class City extends AbstractEntity<Long> {

    @NotBlank
    @Column(nullable = false, length = 128, unique = true)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "city")
    private List<Theater> theaters;

    public City(String name) {
        this.name = name;
    }

    public City() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Theater> getTheaters() {
        return theaters;
    }

    public void setTheaters(List<Theater> theaters) {
        this.theaters = theaters;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                '}';
    }
}


package com.arun.eventmanagementapi.entities;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Objects;

@Getter
@Setter
@Entity
@JsonPropertyOrder({"venueId","name"})
public class Venue extends AbstractEntity {

    private String name;
    private String streetAddress;
    private String streetAddress2;
    private String city;
    private String state;
    private String country;
    private String postalCode;

    public Long getVenueId(){
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Venue)) return false;
        Venue venue = (Venue) o;
        return getId().equals(venue.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}


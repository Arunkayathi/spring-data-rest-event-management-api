package com.arun.eventmanagementapi.entities;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Objects;
import java.util.Set;


@Getter
@Setter
@Entity
@JsonPropertyOrder({"organizerId","name"})
public class Organizer extends  AbstractEntity {

    private String name;
    @OneToMany(mappedBy = "organizer")
    private Set<Event> events;
    public Long getOrganizerId(){
        return id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Organizer)) return false;
        Organizer organizer = (Organizer) o;
        return getId().equals(organizer.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}


package com.arun.eventmanagementapi.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;


@Getter
@Setter
@Entity
@JsonPropertyOrder({"eventId","name","eventDesc"})
public class Event extends AbstractEntity {


    private String name;
    @JsonProperty("eventDesc")
    private String description;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;
    private ZoneId zoneId;
    private Boolean started;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Organizer organizer;
    @ManyToOne(fetch = FetchType.EAGER, cascade = ALL)
    @RestResource(exported = false)
    private Venue venue;
    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY, cascade = ALL, orphanRemoval = true)
    private Set<Participant> participants;

    public Long getEventId(){
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return getId().equals(event.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

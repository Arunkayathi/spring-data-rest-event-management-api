package com.arun.eventmanagementapi.entities;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Entity
@JsonPropertyOrder({"participantId","name","email"})
public class Participant extends AbstractEntity {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    private Boolean checkedIn;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "ID", nullable = false, updatable = false)
    private  Event event;
    public Long getParticipantId(){
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Participant)) return false;
        Participant participant = (Participant) o;
        return getId().equals(participant.getId());
    }


    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

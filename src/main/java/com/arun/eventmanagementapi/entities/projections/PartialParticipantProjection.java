package com.arun.eventmanagementapi.entities.projections;

import com.arun.eventmanagementapi.entities.Participant;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="partialParticipant", types = {Participant.class})
public interface PartialParticipantProjection {

    String getName();
    Boolean getCheckedIn();
}

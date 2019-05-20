package com.arun.eventmanagementapi.controllers;

import com.arun.eventmanagementapi.entities.Participant;
import com.arun.eventmanagementapi.exceptions.AlreadyCheckedInException;
import com.arun.eventmanagementapi.exceptions.NotCheckInException;
import com.arun.eventmanagementapi.repositories.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@RepositoryRestController
@RequestMapping("/events")
public class ParticipantController {

    @Autowired
    private ParticipantRepository participantRepository;

    @PostMapping("/checkin/{id}")
    public ResponseEntity<PersistentEntityResource> checkIn(@PathVariable("id") Long participantId, PersistentEntityResourceAssembler persistentEntityResourceAssembler) {
        Optional<Participant> participant= participantRepository.findById(participantId);
        if(!participant.isPresent()){
            throw new ResourceNotFoundException();
        }
        if(participant.get().getCheckedIn()){
            throw new AlreadyCheckedInException("Participant already checked In");
        }

        Participant selectedParticipant = participant.get();
        selectedParticipant.setCheckedIn(true);
        participantRepository.save(selectedParticipant);
        return ResponseEntity.ok(persistentEntityResourceAssembler.toResource(selectedParticipant));
    }

    @PostMapping("/checkout/{id}")
    public ResponseEntity<PersistentEntityResource> checkout(@PathVariable("id")Long participantId, PersistentEntityResourceAssembler persistentEntityResourceAssembler){
        Optional<Participant> participant = participantRepository.findById(participantId);
        if(!participant.isPresent()){
            throw new ResourceNotFoundException();
        }
        Participant selectedParticipant= participant.get();
        if(!selectedParticipant.getCheckedIn()){
            throw new NotCheckInException("Participant not checked in");
        }
        selectedParticipant.setCheckedIn(false);
        participantRepository.save(selectedParticipant);
        return ResponseEntity.ok(persistentEntityResourceAssembler.toResource(selectedParticipant));
    }
}

package com.arun.eventmanagementapi.repositories;

import com.arun.eventmanagementapi.entities.Participant;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends PagingAndSortingRepository<Participant, Long> {
}

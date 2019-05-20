package com.arun.eventmanagementapi.repositories;

import com.arun.eventmanagementapi.entities.Participant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends PagingAndSortingRepository<Participant, Long> {

    Page<Participant> findByEmail(@Param("emailId") String emailId, Pageable pageable);
}

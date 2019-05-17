package com.arun.eventmanagementapi.repositories;

import com.arun.eventmanagementapi.entities.Organizer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizerRepository extends PagingAndSortingRepository<Organizer, Long> {
}

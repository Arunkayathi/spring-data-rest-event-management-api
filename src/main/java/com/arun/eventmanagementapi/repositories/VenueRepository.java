package com.arun.eventmanagementapi.repositories;

import com.arun.eventmanagementapi.entities.Venue;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository extends PagingAndSortingRepository<Venue, Long> {
}

package com.arun.eventmanagementapi.repositories;

import com.arun.eventmanagementapi.entities.Venue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository extends PagingAndSortingRepository<Venue, Long> {

    Page<Venue> findByPostalCode (@Param("postalCode") String postalCode, Pageable pageable);
}

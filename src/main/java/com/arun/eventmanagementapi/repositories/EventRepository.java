package com.arun.eventmanagementapi.repositories;

import com.arun.eventmanagementapi.entities.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.ZoneId;


@Repository
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {

    Page<Event> findByName(@Param("name") String name, Pageable pageable);

    Page<Event> findByNameAndZoneId(@Param("name") String name, @Param("zoneId") ZoneId zoneId, Pageable pageable);
}

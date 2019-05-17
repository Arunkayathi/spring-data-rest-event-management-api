package com.arun.eventmanagementapi.repositories;

import com.arun.eventmanagementapi.entities.Event;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {

    List<Event> findByName(@Param("name") String name);
}

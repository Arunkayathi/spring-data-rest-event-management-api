package com.arun.eventmanagementapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
public class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    protected  Long id;

    @CreationTimestamp
    @Column(updatable = false)
    @JsonIgnore
    protected Instant created;
}

package com.pivovaroff.esb.domain;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "route")
@Setter
@Getter
@ToString
public class RouteDomain {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

}

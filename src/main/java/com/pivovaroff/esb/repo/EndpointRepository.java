package com.pivovaroff.esb.repo;

import com.pivovaroff.esb.domain.EndpointDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EndpointRepository extends JpaRepository<EndpointDomain, Long> {
    EndpointDomain getByName(String name);

}

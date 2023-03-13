package com.pivovaroff.esb.repo;

import com.pivovaroff.esb.domain.RouteDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<RouteDomain, Long> {
}

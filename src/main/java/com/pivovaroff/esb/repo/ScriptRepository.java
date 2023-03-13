package com.pivovaroff.esb.repo;

import com.pivovaroff.esb.domain.ScriptDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScriptRepository extends JpaRepository<ScriptDomain, Long> {
    ScriptDomain getByName(String name);
}

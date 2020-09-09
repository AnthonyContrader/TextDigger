package com.contrader.textdigger.repository;

import com.contrader.textdigger.domain.InterestGroup;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the InterestGroup entity.
 */
@SuppressWarnings("unused")
@Repository
public interface InterestGroupRepository extends JpaRepository<InterestGroup, Long> {
}

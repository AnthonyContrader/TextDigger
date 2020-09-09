package com.contrader.textdigger.repository;

import com.contrader.textdigger.domain.Interest;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Interest entity.
 */
@SuppressWarnings("unused")
@Repository
public interface InterestRepository extends JpaRepository<Interest, Long> {
}

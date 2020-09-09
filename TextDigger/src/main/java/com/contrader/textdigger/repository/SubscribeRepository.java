package com.contrader.textdigger.repository;

import com.contrader.textdigger.domain.Subscribe;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Subscribe entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SubscribeRepository extends JpaRepository<Subscribe, Long> {
}

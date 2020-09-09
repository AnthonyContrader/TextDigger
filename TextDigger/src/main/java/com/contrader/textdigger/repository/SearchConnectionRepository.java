package com.contrader.textdigger.repository;

import com.contrader.textdigger.domain.SearchConnection;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the SearchConnection entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SearchConnectionRepository extends JpaRepository<SearchConnection, Long> {
}

package com.contrader.textdigger.repository;

import com.contrader.textdigger.domain.Library;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Library entity.
 */
@SuppressWarnings("unused")
@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {
}

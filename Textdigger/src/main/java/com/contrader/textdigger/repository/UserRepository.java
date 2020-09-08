package com.contrader.textdigger.repository;

import com.contrader.textdigger.domain.User;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the User entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

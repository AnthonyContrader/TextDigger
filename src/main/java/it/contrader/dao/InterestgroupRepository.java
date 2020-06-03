package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Interestgroup;

@Repository
@Transactional
public interface InterestgroupRepository extends CrudRepository<Interestgroup, Long> {

	Interestgroup findByInterestgroup(String interestgroup);

}

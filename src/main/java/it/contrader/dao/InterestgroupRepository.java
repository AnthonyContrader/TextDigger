package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Interestgroup;
import it.contrader.model.Interest;

@Repository
@Transactional
public interface InterestgroupRepository extends CrudRepository<Interestgroup, Long> {

	Interest findByInterest(Interest interest);
	
	Interestgroup findByInterestgroup(String interestgroup);

}

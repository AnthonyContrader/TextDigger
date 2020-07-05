package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Interest;

@Repository
@Transactional
public interface InterestRepository extends CrudRepository<Interest, Long> {

	Interest findByInterest(String interest);

}

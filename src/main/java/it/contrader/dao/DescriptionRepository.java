package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.contrader.model.Description;

@Repository
@Transactional
public interface DescriptionRepository extends CrudRepository<Description, Long> {
	
	Description findDescriptionByDescription(String description);

}

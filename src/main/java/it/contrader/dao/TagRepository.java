package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Tag;
import it.contrader.model.Description;

@Repository
@Transactional
public interface TagRepository extends CrudRepository<Tag, Long> {

	Tag findByTag(String tag);
	
	Description findByDescription(Description description);

}

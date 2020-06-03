package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Tag;

@Repository
@Transactional
public interface TagRepository extends CrudRepository<Tag, Long> {

	Tag findByTag(String tag);

}

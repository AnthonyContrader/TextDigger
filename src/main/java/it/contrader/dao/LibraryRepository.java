package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.contrader.model.Library;

@Repository
@Transactional
public interface LibraryRepository extends CrudRepository<Library, Long>{
	
	Library findLibraryByName(String name);

}

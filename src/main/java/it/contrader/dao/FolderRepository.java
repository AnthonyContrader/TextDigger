package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.contrader.model.Folder;

@Repository
@Transactional
public interface FolderRepository extends CrudRepository<Folder, Long> {
	
	Folder findFolderByName(String name);

}

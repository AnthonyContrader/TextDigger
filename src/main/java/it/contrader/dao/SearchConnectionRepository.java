package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import it.contrader.model.SearchConnection;

@Repository
@Transactional
public interface SearchConnectionRepository extends CrudRepository<SearchConnection, Long> {

	SearchConnection findByIdDocumentAndIdTag(int idDocument, int idTag);

}
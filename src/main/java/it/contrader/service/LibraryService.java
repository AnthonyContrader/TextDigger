package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.LibraryConverter;
import it.contrader.dao.LibraryRepository;
import it.contrader.dto.LibraryDTO;
import it.contrader.model.Library;

@Service
public class LibraryService extends AbstractService<Library, LibraryDTO> {
	
	@Autowired
	private LibraryConverter libraryConverter;
	
	@Autowired
	private LibraryRepository libraryRepository;
	
	public LibraryDTO findLibraryByName(String name) {
		return libraryConverter.toDTO(libraryRepository.findLibraryByName(name));
	}

}

package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.LibraryRepository;
import it.contrader.dto.LibraryDTO;
import it.contrader.model.Library;

@Service
public class LibraryService extends AbstractService<Library, LibraryDTO> {
	
	public LibraryDTO findLibraryByName(String name) {
		return converter.toDTO(((LibraryRepository)repository).findLibraryByName(name));
	}

}

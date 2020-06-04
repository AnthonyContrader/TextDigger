package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.LibraryDTO;
import it.contrader.model.Library;

@Component
public class LibraryConverter extends AbstractConverter<Library, LibraryDTO> {

	@Override
	public Library toEntity(LibraryDTO libraryDto) {
		Library library = null;
		if(libraryDto != null) {
			library = new Library(libraryDto.getIdLibrary(), libraryDto.getName(), libraryDto.getFolders(), libraryDto.getDescription(),
					libraryDto.getInterest());
		}
		return library;
	}

	@Override
	public LibraryDTO toDTO(Library library) {
		LibraryDTO libraryDTO = null;
		if(library != null) {
			libraryDTO = new LibraryDTO(library.getIdLibrary(), library.getName(), library.getFolders(), library.getDescription(),
					library.getInterest());
		}
		return libraryDTO;
	}

}

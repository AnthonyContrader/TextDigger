package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.FolderRepository;
import it.contrader.dto.FolderDTO;
import it.contrader.model.Folder;

@Service
public class FolderService extends AbstractService<Folder, FolderDTO> {
	
	private FolderDTO findFolderByName(String name) {
		return converter.toDTO(((FolderRepository)repository).findFolderByName(name));
	}

}

package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.FolderDTO;
import it.contrader.model.Folder;

@Component
public class FolderConverter extends AbstractConverter<Folder, FolderDTO> {

	@Override
	public Folder toEntity(FolderDTO folderDto) {
		Folder folder = null;
		if(folderDto != null) {
			folder = new Folder(folderDto.getId(), folderDto.getName(), folderDto.getLibrary(), folderDto.getDescription());
		}
		return folder;
	}

	@Override
	public FolderDTO toDTO(Folder folder) {
		FolderDTO folderDTO = null;
		if(folder != null) {
			folderDTO = new FolderDTO(folder.getId(), folder.getName(), folder.getLibrary(), folder.getDescription());
		}
		return folderDTO;
	}

}

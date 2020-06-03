package it.contrader.converter;

import it.contrader.dto.FolderDTO;
import it.contrader.model.Folder;

public class FolderConverter extends AbstractConverter<Folder, FolderDTO> {

	@Override
	public Folder toEntity(FolderDTO folderDto) {
		Folder folder = null;
		if(folderDto != null) {
			folder = new Folder(folderDto.getIdFolder(), folderDto.getName(), folderDto.getDocuments());
		}
		return folder;
	}

	@Override
	public FolderDTO toDTO(Folder folder) {
		FolderDTO folderDTO = null;
		if(folder != null) {
			folderDTO = new FolderDTO(folder.getIdFolder(), folder.getName(), folder.getDocuments());
		}
		return folderDTO;
	}

}

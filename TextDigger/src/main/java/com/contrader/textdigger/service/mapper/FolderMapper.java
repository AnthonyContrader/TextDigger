package com.contrader.textdigger.service.mapper;


import com.contrader.textdigger.domain.*;
import com.contrader.textdigger.service.dto.FolderDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Folder} and its DTO {@link FolderDTO}.
 */
@Mapper(componentModel = "spring", uses = {LibraryMapper.class})
public interface FolderMapper extends EntityMapper<FolderDTO, Folder> {

    @Mapping(source = "library.id", target = "libraryId")
    FolderDTO toDto(Folder folder);

    @Mapping(source = "libraryId", target = "library")
    Folder toEntity(FolderDTO folderDTO);

    default Folder fromId(Long id) {
        if (id == null) {
            return null;
        }
        Folder folder = new Folder();
        folder.setId(id);
        return folder;
    }
}

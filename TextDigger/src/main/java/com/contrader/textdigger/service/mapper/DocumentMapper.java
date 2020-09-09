package com.contrader.textdigger.service.mapper;


import com.contrader.textdigger.domain.*;
import com.contrader.textdigger.service.dto.DocumentDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Document} and its DTO {@link DocumentDTO}.
 */
@Mapper(componentModel = "spring", uses = {UtenteMapper.class, FolderMapper.class})
public interface DocumentMapper extends EntityMapper<DocumentDTO, Document> {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "folder.id", target = "folderId")
    DocumentDTO toDto(Document document);

    @Mapping(source = "userId", target = "user")
    @Mapping(source = "folderId", target = "folder")
    Document toEntity(DocumentDTO documentDTO);

    default Document fromId(Long id) {
        if (id == null) {
            return null;
        }
        Document document = new Document();
        document.setId(id);
        return document;
    }
}

package com.contrader.textdigger.service.mapper;


import com.contrader.textdigger.domain.*;
import com.contrader.textdigger.service.dto.LibraryDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Library} and its DTO {@link LibraryDTO}.
 */
@Mapper(componentModel = "spring", uses = {InterestMapper.class})
public interface LibraryMapper extends EntityMapper<LibraryDTO, Library> {

    @Mapping(source = "interest.id", target = "interestId")
    LibraryDTO toDto(Library library);

    @Mapping(source = "interestId", target = "interest")
    Library toEntity(LibraryDTO libraryDTO);

    default Library fromId(Long id) {
        if (id == null) {
            return null;
        }
        Library library = new Library();
        library.setId(id);
        return library;
    }
}

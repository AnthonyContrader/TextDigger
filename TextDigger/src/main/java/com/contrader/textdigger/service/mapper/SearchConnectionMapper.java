package com.contrader.textdigger.service.mapper;


import com.contrader.textdigger.domain.*;
import com.contrader.textdigger.service.dto.SearchConnectionDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link SearchConnection} and its DTO {@link SearchConnectionDTO}.
 */
@Mapper(componentModel = "spring", uses = {TagMapper.class, DocumentMapper.class})
public interface SearchConnectionMapper extends EntityMapper<SearchConnectionDTO, SearchConnection> {

    @Mapping(source = "tag.id", target = "tagId")
    @Mapping(source = "document.id", target = "documentId")
    SearchConnectionDTO toDto(SearchConnection searchConnection);

    @Mapping(source = "tagId", target = "tag")
    @Mapping(source = "documentId", target = "document")
    SearchConnection toEntity(SearchConnectionDTO searchConnectionDTO);

    default SearchConnection fromId(Long id) {
        if (id == null) {
            return null;
        }
        SearchConnection searchConnection = new SearchConnection();
        searchConnection.setId(id);
        return searchConnection;
    }
}

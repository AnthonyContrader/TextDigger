package com.contrader.textdigger.service.mapper;


import com.contrader.textdigger.domain.*;
import com.contrader.textdigger.service.dto.InterestGroupDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link InterestGroup} and its DTO {@link InterestGroupDTO}.
 */
@Mapper(componentModel = "spring", uses = {InterestMapper.class})
public interface InterestGroupMapper extends EntityMapper<InterestGroupDTO, InterestGroup> {

    @Mapping(source = "interest.id", target = "interestId")
    InterestGroupDTO toDto(InterestGroup interestGroup);

    @Mapping(source = "interestId", target = "interest")
    InterestGroup toEntity(InterestGroupDTO interestGroupDTO);

    default InterestGroup fromId(Long id) {
        if (id == null) {
            return null;
        }
        InterestGroup interestGroup = new InterestGroup();
        interestGroup.setId(id);
        return interestGroup;
    }
}

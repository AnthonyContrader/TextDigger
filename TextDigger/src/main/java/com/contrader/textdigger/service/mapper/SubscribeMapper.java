package com.contrader.textdigger.service.mapper;


import com.contrader.textdigger.domain.*;
import com.contrader.textdigger.service.dto.SubscribeDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Subscribe} and its DTO {@link SubscribeDTO}.
 */
@Mapper(componentModel = "spring", uses = {UtenteMapper.class, InterestGroupMapper.class})
public interface SubscribeMapper extends EntityMapper<SubscribeDTO, Subscribe> {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "interestgroup.id", target = "interestgroupId")
    SubscribeDTO toDto(Subscribe subscribe);

    @Mapping(source = "userId", target = "user")
    @Mapping(source = "interestgroupId", target = "interestgroup")
    Subscribe toEntity(SubscribeDTO subscribeDTO);

    default Subscribe fromId(Long id) {
        if (id == null) {
            return null;
        }
        Subscribe subscribe = new Subscribe();
        subscribe.setId(id);
        return subscribe;
    }
}

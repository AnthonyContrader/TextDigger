package com.contrader.textdigger.service.mapper;


import com.contrader.textdigger.domain.*;
import com.contrader.textdigger.service.dto.UtenteDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Utente} and its DTO {@link UtenteDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface UtenteMapper extends EntityMapper<UtenteDTO, Utente> {



    default Utente fromId(Long id) {
        if (id == null) {
            return null;
        }
        Utente utente = new Utente();
        utente.setId(id);
        return utente;
    }
}

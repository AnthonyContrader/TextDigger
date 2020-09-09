package com.contrader.textdigger.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class UtenteMapperTest {

    private UtenteMapper utenteMapper;

    @BeforeEach
    public void setUp() {
        utenteMapper = new UtenteMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(utenteMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(utenteMapper.fromId(null)).isNull();
    }
}

package com.contrader.textdigger.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchConnectionMapperTest {

    private SearchConnectionMapper searchConnectionMapper;

    @BeforeEach
    public void setUp() {
        searchConnectionMapper = new SearchConnectionMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(searchConnectionMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(searchConnectionMapper.fromId(null)).isNull();
    }
}

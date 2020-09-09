package com.contrader.textdigger.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class InterestMapperTest {

    private InterestMapper interestMapper;

    @BeforeEach
    public void setUp() {
        interestMapper = new InterestMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(interestMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(interestMapper.fromId(null)).isNull();
    }
}

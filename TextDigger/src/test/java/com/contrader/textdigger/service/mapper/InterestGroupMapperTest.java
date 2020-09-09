package com.contrader.textdigger.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class InterestGroupMapperTest {

    private InterestGroupMapper interestGroupMapper;

    @BeforeEach
    public void setUp() {
        interestGroupMapper = new InterestGroupMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(interestGroupMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(interestGroupMapper.fromId(null)).isNull();
    }
}

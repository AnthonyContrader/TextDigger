package com.contrader.textdigger.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SubscribeMapperTest {

    private SubscribeMapper subscribeMapper;

    @BeforeEach
    public void setUp() {
        subscribeMapper = new SubscribeMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(subscribeMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(subscribeMapper.fromId(null)).isNull();
    }
}

package com.contrader.textdigger.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.contrader.textdigger.web.rest.TestUtil;

public class SubscribeDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(SubscribeDTO.class);
        SubscribeDTO subscribeDTO1 = new SubscribeDTO();
        subscribeDTO1.setId(1L);
        SubscribeDTO subscribeDTO2 = new SubscribeDTO();
        assertThat(subscribeDTO1).isNotEqualTo(subscribeDTO2);
        subscribeDTO2.setId(subscribeDTO1.getId());
        assertThat(subscribeDTO1).isEqualTo(subscribeDTO2);
        subscribeDTO2.setId(2L);
        assertThat(subscribeDTO1).isNotEqualTo(subscribeDTO2);
        subscribeDTO1.setId(null);
        assertThat(subscribeDTO1).isNotEqualTo(subscribeDTO2);
    }
}

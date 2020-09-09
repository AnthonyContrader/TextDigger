package com.contrader.textdigger.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.contrader.textdigger.web.rest.TestUtil;

public class InterestGroupDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(InterestGroupDTO.class);
        InterestGroupDTO interestGroupDTO1 = new InterestGroupDTO();
        interestGroupDTO1.setId(1L);
        InterestGroupDTO interestGroupDTO2 = new InterestGroupDTO();
        assertThat(interestGroupDTO1).isNotEqualTo(interestGroupDTO2);
        interestGroupDTO2.setId(interestGroupDTO1.getId());
        assertThat(interestGroupDTO1).isEqualTo(interestGroupDTO2);
        interestGroupDTO2.setId(2L);
        assertThat(interestGroupDTO1).isNotEqualTo(interestGroupDTO2);
        interestGroupDTO1.setId(null);
        assertThat(interestGroupDTO1).isNotEqualTo(interestGroupDTO2);
    }
}

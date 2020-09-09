package com.contrader.textdigger.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.contrader.textdigger.web.rest.TestUtil;

public class InterestGroupTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(InterestGroup.class);
        InterestGroup interestGroup1 = new InterestGroup();
        interestGroup1.setId(1L);
        InterestGroup interestGroup2 = new InterestGroup();
        interestGroup2.setId(interestGroup1.getId());
        assertThat(interestGroup1).isEqualTo(interestGroup2);
        interestGroup2.setId(2L);
        assertThat(interestGroup1).isNotEqualTo(interestGroup2);
        interestGroup1.setId(null);
        assertThat(interestGroup1).isNotEqualTo(interestGroup2);
    }
}

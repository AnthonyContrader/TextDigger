package com.contrader.textdigger.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.contrader.textdigger.web.rest.TestUtil;

public class SearchConnectionDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(SearchConnectionDTO.class);
        SearchConnectionDTO searchConnectionDTO1 = new SearchConnectionDTO();
        searchConnectionDTO1.setId(1L);
        SearchConnectionDTO searchConnectionDTO2 = new SearchConnectionDTO();
        assertThat(searchConnectionDTO1).isNotEqualTo(searchConnectionDTO2);
        searchConnectionDTO2.setId(searchConnectionDTO1.getId());
        assertThat(searchConnectionDTO1).isEqualTo(searchConnectionDTO2);
        searchConnectionDTO2.setId(2L);
        assertThat(searchConnectionDTO1).isNotEqualTo(searchConnectionDTO2);
        searchConnectionDTO1.setId(null);
        assertThat(searchConnectionDTO1).isNotEqualTo(searchConnectionDTO2);
    }
}

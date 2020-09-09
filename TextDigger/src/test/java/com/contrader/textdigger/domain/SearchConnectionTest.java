package com.contrader.textdigger.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.contrader.textdigger.web.rest.TestUtil;

public class SearchConnectionTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SearchConnection.class);
        SearchConnection searchConnection1 = new SearchConnection();
        searchConnection1.setId(1L);
        SearchConnection searchConnection2 = new SearchConnection();
        searchConnection2.setId(searchConnection1.getId());
        assertThat(searchConnection1).isEqualTo(searchConnection2);
        searchConnection2.setId(2L);
        assertThat(searchConnection1).isNotEqualTo(searchConnection2);
        searchConnection1.setId(null);
        assertThat(searchConnection1).isNotEqualTo(searchConnection2);
    }
}

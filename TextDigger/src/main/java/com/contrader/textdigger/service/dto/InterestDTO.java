package com.contrader.textdigger.service.dto;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;

/**
 * A DTO for the {@link com.contrader.textdigger.domain.Interest} entity.
 */
@ApiModel(description = "Task entity.\n@author The JHipster team.")
public class InterestDTO implements Serializable {
    
    private Long id;

    private String interest;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InterestDTO)) {
            return false;
        }

        return id != null && id.equals(((InterestDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "InterestDTO{" +
            "id=" + getId() +
            ", interest='" + getInterest() + "'" +
            "}";
    }
}

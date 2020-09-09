package com.contrader.textdigger.service.dto;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;

/**
 * A DTO for the {@link com.contrader.textdigger.domain.InterestGroup} entity.
 */
@ApiModel(description = "The Employee entity.")
public class InterestGroupDTO implements Serializable {
    
    private Long id;

    private String interestGroup;


    private Long interestId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInterestGroup() {
        return interestGroup;
    }

    public void setInterestGroup(String interestGroup) {
        this.interestGroup = interestGroup;
    }

    public Long getInterestId() {
        return interestId;
    }

    public void setInterestId(Long interestId) {
        this.interestId = interestId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InterestGroupDTO)) {
            return false;
        }

        return id != null && id.equals(((InterestGroupDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "InterestGroupDTO{" +
            "id=" + getId() +
            ", interestGroup='" + getInterestGroup() + "'" +
            ", interestId=" + getInterestId() +
            "}";
    }
}

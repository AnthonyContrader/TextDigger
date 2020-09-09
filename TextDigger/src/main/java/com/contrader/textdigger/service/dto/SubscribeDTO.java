package com.contrader.textdigger.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link com.contrader.textdigger.domain.Subscribe} entity.
 */
public class SubscribeDTO implements Serializable {
    
    private Long id;


    private Long userId;

    private Long interestgroupId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long utenteId) {
        this.userId = utenteId;
    }

    public Long getInterestgroupId() {
        return interestgroupId;
    }

    public void setInterestgroupId(Long interestGroupId) {
        this.interestgroupId = interestGroupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SubscribeDTO)) {
            return false;
        }

        return id != null && id.equals(((SubscribeDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SubscribeDTO{" +
            "id=" + getId() +
            ", userId=" + getUserId() +
            ", interestgroupId=" + getInterestgroupId() +
            "}";
    }
}

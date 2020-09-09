package com.contrader.textdigger.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link com.contrader.textdigger.domain.Library} entity.
 */
public class LibraryDTO implements Serializable {
    
    private Long id;

    private String libraryName;


    private Long interestId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
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
        if (!(o instanceof LibraryDTO)) {
            return false;
        }

        return id != null && id.equals(((LibraryDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "LibraryDTO{" +
            "id=" + getId() +
            ", libraryName='" + getLibraryName() + "'" +
            ", interestId=" + getInterestId() +
            "}";
    }
}

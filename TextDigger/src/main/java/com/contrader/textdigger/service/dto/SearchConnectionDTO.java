package com.contrader.textdigger.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link com.contrader.textdigger.domain.SearchConnection} entity.
 */
public class SearchConnectionDTO implements Serializable {
    
    private Long id;


    private Long tagId;

    private Long documentId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SearchConnectionDTO)) {
            return false;
        }

        return id != null && id.equals(((SearchConnectionDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SearchConnectionDTO{" +
            "id=" + getId() +
            ", tagId=" + getTagId() +
            ", documentId=" + getDocumentId() +
            "}";
    }
}

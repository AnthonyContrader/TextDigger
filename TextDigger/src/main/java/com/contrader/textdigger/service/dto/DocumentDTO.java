package com.contrader.textdigger.service.dto;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;

/**
 * A DTO for the {@link com.contrader.textdigger.domain.Document} entity.
 */
@ApiModel(description = "not an ignored comment")
public class DocumentDTO implements Serializable {
    
    private Long id;

    private String text;


    private Long userId;

    private Long folderId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long utenteId) {
        this.userId = utenteId;
    }

    public Long getFolderId() {
        return folderId;
    }

    public void setFolderId(Long folderId) {
        this.folderId = folderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DocumentDTO)) {
            return false;
        }

        return id != null && id.equals(((DocumentDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DocumentDTO{" +
            "id=" + getId() +
            ", text='" + getText() + "'" +
            ", userId=" + getUserId() +
            ", folderId=" + getFolderId() +
            "}";
    }
}

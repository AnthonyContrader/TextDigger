package com.contrader.textdigger.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link com.contrader.textdigger.domain.Folder} entity.
 */
public class FolderDTO implements Serializable {
    
    private Long id;

    private String folderName;


    private Long libraryId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public Long getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Long libraryId) {
        this.libraryId = libraryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FolderDTO)) {
            return false;
        }

        return id != null && id.equals(((FolderDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "FolderDTO{" +
            "id=" + getId() +
            ", folderName='" + getFolderName() + "'" +
            ", libraryId=" + getLibraryId() +
            "}";
    }
}

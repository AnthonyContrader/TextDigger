package com.contrader.textdigger.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;

/**
 * A Folder.
 */
@Entity
@Table(name = "folder")
public class Folder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "folder_name")
    private String folderName;

    @ManyToOne
    @JsonIgnoreProperties(value = "folders", allowSetters = true)
    private Library library;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFolderName() {
        return folderName;
    }

    public Folder folderName(String folderName) {
        this.folderName = folderName;
        return this;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public Library getLibrary() {
        return library;
    }

    public Folder library(Library library) {
        this.library = library;
        return this;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Folder)) {
            return false;
        }
        return id != null && id.equals(((Folder) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Folder{" +
            "id=" + getId() +
            ", folderName='" + getFolderName() + "'" +
            "}";
    }
}

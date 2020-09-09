package com.contrader.textdigger.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;

/**
 * A Library.
 */
@Entity
@Table(name = "library")
public class Library implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "library_name")
    private String libraryName;

    @ManyToOne
    @JsonIgnoreProperties(value = "libraries", allowSetters = true)
    private Interest interest;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public Library libraryName(String libraryName) {
        this.libraryName = libraryName;
        return this;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public Interest getInterest() {
        return interest;
    }

    public Library interest(Interest interest) {
        this.interest = interest;
        return this;
    }

    public void setInterest(Interest interest) {
        this.interest = interest;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Library)) {
            return false;
        }
        return id != null && id.equals(((Library) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Library{" +
            "id=" + getId() +
            ", libraryName='" + getLibraryName() + "'" +
            "}";
    }
}

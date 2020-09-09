package com.contrader.textdigger.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;

/**
 * not an ignored comment
 */
@Entity
@Table(name = "document")
public class Document implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "text")
    private String text;

    @ManyToOne
    @JsonIgnoreProperties(value = "documents", allowSetters = true)
    private Utente user;

    @ManyToOne
    @JsonIgnoreProperties(value = "documents", allowSetters = true)
    private Folder folder;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public Document text(String text) {
        this.text = text;
        return this;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Utente getUser() {
        return user;
    }

    public Document user(Utente utente) {
        this.user = utente;
        return this;
    }

    public void setUser(Utente utente) {
        this.user = utente;
    }

    public Folder getFolder() {
        return folder;
    }

    public Document folder(Folder folder) {
        this.folder = folder;
        return this;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Document)) {
            return false;
        }
        return id != null && id.equals(((Document) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Document{" +
            "id=" + getId() +
            ", text='" + getText() + "'" +
            "}";
    }
}

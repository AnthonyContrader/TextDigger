package com.contrader.textdigger.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;

/**
 * A Subscribe.
 */
@Entity
@Table(name = "subscribe")
public class Subscribe implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties(value = "subscribes", allowSetters = true)
    private Utente user;

    @ManyToOne
    @JsonIgnoreProperties(value = "subscribes", allowSetters = true)
    private InterestGroup interestgroup;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utente getUser() {
        return user;
    }

    public Subscribe user(Utente utente) {
        this.user = utente;
        return this;
    }

    public void setUser(Utente utente) {
        this.user = utente;
    }

    public InterestGroup getInterestgroup() {
        return interestgroup;
    }

    public Subscribe interestgroup(InterestGroup interestGroup) {
        this.interestgroup = interestGroup;
        return this;
    }

    public void setInterestgroup(InterestGroup interestGroup) {
        this.interestgroup = interestGroup;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Subscribe)) {
            return false;
        }
        return id != null && id.equals(((Subscribe) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Subscribe{" +
            "id=" + getId() +
            "}";
    }
}

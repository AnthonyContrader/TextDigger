package com.contrader.textdigger.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;

/**
 * The Employee entity.
 */
@Entity
@Table(name = "interest_group")
public class InterestGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "interest_group")
    private String interestGroup;

    @ManyToOne
    @JsonIgnoreProperties(value = "interestGroups", allowSetters = true)
    private Interest interest;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInterestGroup() {
        return interestGroup;
    }

    public InterestGroup interestGroup(String interestGroup) {
        this.interestGroup = interestGroup;
        return this;
    }

    public void setInterestGroup(String interestGroup) {
        this.interestGroup = interestGroup;
    }

    public Interest getInterest() {
        return interest;
    }

    public InterestGroup interest(Interest interest) {
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
        if (!(o instanceof InterestGroup)) {
            return false;
        }
        return id != null && id.equals(((InterestGroup) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "InterestGroup{" +
            "id=" + getId() +
            ", interestGroup='" + getInterestGroup() + "'" +
            "}";
    }
}

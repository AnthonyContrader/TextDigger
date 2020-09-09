package com.contrader.textdigger.domain;


import javax.persistence.*;

import java.io.Serializable;

/**
 * Task entity.\n@author The JHipster team.
 */
@Entity
@Table(name = "interest")
public class Interest implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "interest")
    private String interest;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInterest() {
        return interest;
    }

    public Interest interest(String interest) {
        this.interest = interest;
        return this;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Interest)) {
            return false;
        }
        return id != null && id.equals(((Interest) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Interest{" +
            "id=" + getId() +
            ", interest='" + getInterest() + "'" +
            "}";
    }
}

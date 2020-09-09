package com.contrader.textdigger.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

import com.contrader.textdigger.domain.enumeration.Usertype;

/**
 * JHipster JDL model for myApp
 */
@Entity
@Table(name = "utente")
public class Utente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "username")
    private String username;

    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "usertype")
    private Usertype usertype;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public Utente username(String username) {
        this.username = username;
        return this;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public Utente password(String password) {
        this.password = password;
        return this;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usertype getUsertype() {
        return usertype;
    }

    public Utente usertype(Usertype usertype) {
        this.usertype = usertype;
        return this;
    }

    public void setUsertype(Usertype usertype) {
        this.usertype = usertype;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Utente)) {
            return false;
        }
        return id != null && id.equals(((Utente) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Utente{" +
            "id=" + getId() +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", usertype='" + getUsertype() + "'" +
            "}";
    }
}

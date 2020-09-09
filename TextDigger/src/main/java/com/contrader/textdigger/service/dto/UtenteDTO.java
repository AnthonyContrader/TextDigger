package com.contrader.textdigger.service.dto;

import io.swagger.annotations.ApiModel;
import javax.validation.constraints.*;
import java.io.Serializable;
import com.contrader.textdigger.domain.enumeration.Usertype;

/**
 * A DTO for the {@link com.contrader.textdigger.domain.Utente} entity.
 */
@ApiModel(description = "JHipster JDL model for myApp")
public class UtenteDTO implements Serializable {
    
    private Long id;

    private String username;

    @NotNull
    private String password;

    private Usertype usertype;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usertype getUsertype() {
        return usertype;
    }

    public void setUsertype(Usertype usertype) {
        this.usertype = usertype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UtenteDTO)) {
            return false;
        }

        return id != null && id.equals(((UtenteDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UtenteDTO{" +
            "id=" + getId() +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", usertype='" + getUsertype() + "'" +
            "}";
    }
}

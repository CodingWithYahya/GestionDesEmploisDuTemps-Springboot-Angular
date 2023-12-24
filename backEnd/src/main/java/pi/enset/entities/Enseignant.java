package pi.enset.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collection;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("PROF")
public class Enseignant extends Person {
    private String specialite;
    @ToString.Exclude
    @OneToMany(mappedBy = "enseignant", fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<NonDisponibilite> nonDisponibilites = new ArrayList<>();
    @ToString.Exclude
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "enseignant")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<ElementDeModule> elementDeModules = new ArrayList<>();

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public Collection<NonDisponibilite> getNonDisponibilites() {
        return nonDisponibilites;
    }

    public void setNonDisponibilites(Collection<NonDisponibilite> nonDisponibilites) {
        this.nonDisponibilites = nonDisponibilites;
    }

    public Collection<ElementDeModule> getElementDeModules() {
        return elementDeModules;
    }

    public void setElementDeModules(Collection<ElementDeModule> elementDeModules) {
        this.elementDeModules = elementDeModules;
    }
}

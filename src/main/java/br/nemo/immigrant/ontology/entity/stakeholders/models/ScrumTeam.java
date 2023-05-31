package br.nemo.immigrant.ontology.entity.stakeholders.models;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import br.nemo.immigrant.ontology.entity.scrumprocess.models.ScrumProject;

import br.nemo.immigrant.ontology.entity.standarddefinition.models.CommonConcept;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "scrumteam")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public  class ScrumTeam extends CommonConcept implements Serializable {




  @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "scrumteam")
  @Builder.Default
  private teammembership teammembership = null;

  @OneToOne
  @JoinColumn(name = "scrumproject_id", referencedColumnName = "id")
  private ScrumProject scrumproject;

  @Builder.Default
  private LocalDateTime createdAt = LocalDateTime.now();

  @Override
  public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || this.getClass() != o.getClass()) return false;

        ScrumTeam elem = (ScrumTeam) o;
        return getId().equals(elem.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  @Override
  public String toString() {
      return "ScrumTeam {" +
         "id="+this.id+

          ", name='"+this.name+"'"+
          ", description='"+this.description+"'"+
          ", startDate='"+this.startDate+"'"+
          ", endDate='"+this.endDate+"'"+
          ", externalId='"+this.externalId+"'"+
          ", internalId='"+this.internalId+"'"+

      '}';
  }
}

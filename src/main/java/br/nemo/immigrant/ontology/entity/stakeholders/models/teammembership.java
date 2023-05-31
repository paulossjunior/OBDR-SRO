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


import br.nemo.immigrant.ontology.entity.standarddefinition.models.CommonConcept;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teammembership")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public  class teammembership extends CommonConcept implements Serializable {




  @OneToOne
  @JoinColumn(name = "person_id", referencedColumnName = "id")
  private Person person;

  @OneToOne
  @JoinColumn(name = "scrumteam_id", referencedColumnName = "id")
  private ScrumTeam scrumteam;


  @Builder.Default
  @Enumerated(EnumType.STRING)
  private ScrumRole scrumrole = ScrumRole.DEVELOPER;


  @Builder.Default
  private LocalDateTime createdAt = LocalDateTime.now();

  @Override
  public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || this.getClass() != o.getClass()) return false;

        teammembership elem = (teammembership) o;
        return getId().equals(elem.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  @Override
  public String toString() {
      return "teammembership {" +
         "id="+this.id+

          ", name='"+this.name+"'"+
          ", description='"+this.description+"'"+
          ", startDate='"+this.startDate+"'"+
          ", endDate='"+this.endDate+"'"+
          ", externalId='"+this.externalId+"'"+
          ", internalId='"+this.internalId+"'"+
          ", scrumrole='"+this.scrumrole+"'"+
      '}';
  }
}

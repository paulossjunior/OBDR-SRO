package br.nemo.immigrant.ontology.entity.scrumprocess.models;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.HashSet;
import java.util.Objects;

import br.nemo.immigrant.ontology.entity.productsprintbacklog.models.SprintBacklog;
import br.nemo.immigrant.ontology.entity.stakeholders.models.Person;

import br.nemo.immigrant.ontology.entity.standarddefinition.models.CommonConcept;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ceremony")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public  class Ceremony extends CommonConcept implements Serializable {




  @ManyToOne
  @JoinColumn(name = "sprint_id")
  private Sprint sprint;

  @OneToOne
  @JoinColumn(name = "sprintbacklog_id", referencedColumnName = "id")
  private SprintBacklog sprintbacklog;

  @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "ceremony")
  @Builder.Default
  Set<Person> persons = new HashSet<>();


  @Builder.Default
  @Enumerated(EnumType.STRING)
  private CeremonyType type = CeremonyType.PLANNING;


  @Builder.Default
  private LocalDateTime createdAt = LocalDateTime.now();

  @Override
  public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || this.getClass() != o.getClass()) return false;

        Ceremony elem = (Ceremony) o;
        return getId().equals(elem.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  @Override
  public String toString() {
      return "Ceremony {" +
         "id="+this.id+

          ", name='"+this.name+"'"+
          ", description='"+this.description+"'"+
          ", startDate='"+this.startDate+"'"+
          ", endDate='"+this.endDate+"'"+
          ", externalId='"+this.externalId+"'"+
          ", internalId='"+this.internalId+"'"+
          ", type='"+this.type+"'"+
      '}';
  }
}

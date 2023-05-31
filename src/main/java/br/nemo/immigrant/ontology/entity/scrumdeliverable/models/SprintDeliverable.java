package br.nemo.immigrant.ontology.entity.scrumdeliverable.models;

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

import br.nemo.immigrant.ontology.entity.scrumprocess.models.Sprint;

import br.nemo.immigrant.ontology.entity.standarddefinition.models.CommonConcept;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sprintdeliverable")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public  class SprintDeliverable extends CommonConcept implements Serializable {




  @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "sprintdeliverable")
  @Builder.Default
  Set<Deliverable> deliverables = new HashSet<>();

  @OneToOne
  @JoinColumn(name = "sprint_id", referencedColumnName = "id")
  private Sprint sprint;

  @ManyToOne
  @JoinColumn(name = "scrumprojectdeliverable_id")
  private ScrumProjectDeliverable scrumprojectdeliverable;





  @Builder.Default
  private LocalDateTime createdAt = LocalDateTime.now();

  @Override
  public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || this.getClass() != o.getClass()) return false;

        SprintDeliverable elem = (SprintDeliverable) o;
        return getId().equals(elem.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  @Override
  public String toString() {
      return "SprintDeliverable {" +
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

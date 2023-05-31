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

import br.nemo.immigrant.ontology.entity.scrumprocess.models.ScrumProcess;

import br.nemo.immigrant.ontology.entity.standarddefinition.models.CommonConcept;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "scrumprojectdeliverable")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public  class ScrumProjectDeliverable extends CommonConcept implements Serializable {




  @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "scrumprojectdeliverable")
  @Builder.Default
  Set<SprintDeliverable> sprintdeliverables = new HashSet<>();

  @OneToOne
  @JoinColumn(name = "scrumprocess_id", referencedColumnName = "id")
  private ScrumProcess scrumprocess;





  @Builder.Default
  private LocalDateTime createdAt = LocalDateTime.now();

  @Override
  public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || this.getClass() != o.getClass()) return false;

        ScrumProjectDeliverable elem = (ScrumProjectDeliverable) o;
        return getId().equals(elem.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  @Override
  public String toString() {
      return "ScrumProjectDeliverable {" +
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

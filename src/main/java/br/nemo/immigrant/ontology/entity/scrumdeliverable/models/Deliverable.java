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

import br.nemo.immigrant.ontology.entity.productsprintbacklog.models.UserStory;

import br.nemo.immigrant.ontology.entity.standarddefinition.models.CommonConcept;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "deliverable")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public  class Deliverable extends CommonConcept implements Serializable {




  @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "deliverable")
  @Builder.Default
  Set<UserStory> userstorys = new HashSet<>();

  @ManyToOne
  @JoinColumn(name = "sprintdeliverable_id")
  private SprintDeliverable sprintdeliverable;


  @Builder.Default
  @Enumerated(EnumType.STRING)
  private DeliverableType type = DeliverableType.NOTACCEPTEDDELIVERABLE;


  @Builder.Default
  private LocalDateTime createdAt = LocalDateTime.now();

  @Override
  public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || this.getClass() != o.getClass()) return false;

        Deliverable elem = (Deliverable) o;
        return getId().equals(elem.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  @Override
  public String toString() {
      return "Deliverable {" +
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

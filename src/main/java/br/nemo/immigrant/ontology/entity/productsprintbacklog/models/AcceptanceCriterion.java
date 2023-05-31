package br.nemo.immigrant.ontology.entity.productsprintbacklog.models;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.time.LocalDate;


import br.nemo.immigrant.ontology.entity.standarddefinition.models.CommonConcept;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "acceptancecriterion")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public  class AcceptanceCriterion extends CommonConcept implements Serializable {




  private LocalDate createdtDate;

  @ManyToOne
  @JoinColumn(name = "userstory_id")
  private UserStory userstory;


  @Builder.Default
  @Enumerated(EnumType.STRING)
  private AcceptanceCriterionType type = AcceptanceCriterionType.FUNCTIONALACCEPTANCECRITERION;


  @Builder.Default
  private LocalDateTime createdAt = LocalDateTime.now();

  @Override
  public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || this.getClass() != o.getClass()) return false;

        AcceptanceCriterion elem = (AcceptanceCriterion) o;
        return getId().equals(elem.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  @Override
  public String toString() {
      return "AcceptanceCriterion {" +
         "id="+this.id+
          ", createdtDate='"+this.createdtDate+"'"+
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

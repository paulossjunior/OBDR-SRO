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

import br.nemo.immigrant.ontology.entity.scrumprocess.models.Ceremony;

import br.nemo.immigrant.ontology.entity.standarddefinition.models.CommonConcept;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public  class Person extends CommonConcept implements Serializable {




  private String email;

  @ManyToOne
  @JoinColumn(name = "ceremony_id")
  private Ceremony ceremony;

  @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "person")
  @Builder.Default
  private teammembership teammembership = null;





  @Builder.Default
  private LocalDateTime createdAt = LocalDateTime.now();

  @Override
  public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || this.getClass() != o.getClass()) return false;

        Person elem = (Person) o;
        return getId().equals(elem.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  @Override
  public String toString() {
      return "Person {" +
         "id="+this.id+
          ", email='"+this.email+"'"+
          ", name='"+this.name+"'"+
          ", description='"+this.description+"'"+
          ", startDate='"+this.startDate+"'"+
          ", endDate='"+this.endDate+"'"+
          ", externalId='"+this.externalId+"'"+
          ", internalId='"+this.internalId+"'"+

      '}';
  }
}

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

import br.nemo.immigrant.ontology.entity.scrumdeliverable.models.ScrumProjectDeliverable;

import br.nemo.immigrant.ontology.entity.standarddefinition.models.CommonConcept;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "scrumprocess")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public  class ScrumProcess extends CommonConcept implements Serializable {




  @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "scrumprocess")
  @Builder.Default
  private ScrumProject scrumproject = null;

  @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "scrumprocess")
  @Builder.Default
  Set<Sprint> sprints = new HashSet<>();

  @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "scrumprocess")
  @Builder.Default
  private ScrumProjectDeliverable scrumprojectdeliverable = null;


  @Builder.Default
  private LocalDateTime createdAt = LocalDateTime.now();

  @Override
  public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || this.getClass() != o.getClass()) return false;

        ScrumProcess elem = (ScrumProcess) o;
        return getId().equals(elem.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  @Override
  public String toString() {
      return "ScrumProcess {" +
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

package br.nemo.immigrant.ontology.entity.productsprintbacklog.models;

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
import java.time.LocalDate;

import br.nemo.immigrant.ontology.entity.scrumprocess.models.Sprint;
import br.nemo.immigrant.ontology.entity.scrumprocess.models.Ceremony;
import br.nemo.immigrant.ontology.entity.scrumprocess.models.ScrumDevelopmentTask;

import br.nemo.immigrant.ontology.entity.standarddefinition.models.CommonConcept;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sprintbacklog")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public  class SprintBacklog extends CommonConcept implements Serializable {




  private LocalDate createdtDate;

  @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "sprintbacklog")
  @Builder.Default
  private Sprint sprint = null;

  @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "sprintbacklog")
  @Builder.Default
  private Ceremony ceremony = null;

  @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "sprintbacklog")
  @Builder.Default
  Set<UserStory> userstorys = new HashSet<>();

  @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "sprintbacklog")
  @Builder.Default
  Set<ScrumDevelopmentTask> scrumdevelopmenttasks = new HashSet<>();





  @Builder.Default
  private LocalDateTime createdAt = LocalDateTime.now();

  @Override
  public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || this.getClass() != o.getClass()) return false;

        SprintBacklog elem = (SprintBacklog) o;
        return getId().equals(elem.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  @Override
  public String toString() {
      return "SprintBacklog {" +
         "id="+this.id+
          ", createdtDate='"+this.createdtDate+"'"+
          ", name='"+this.name+"'"+
          ", description='"+this.description+"'"+
          ", startDate='"+this.startDate+"'"+
          ", endDate='"+this.endDate+"'"+
          ", externalId='"+this.externalId+"'"+
          ", internalId='"+this.internalId+"'"+

      '}';
  }
}

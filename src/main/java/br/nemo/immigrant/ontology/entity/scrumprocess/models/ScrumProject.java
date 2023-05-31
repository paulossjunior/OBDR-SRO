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

import br.nemo.immigrant.ontology.entity.stakeholders.models.ScrumTeam;

import br.nemo.immigrant.ontology.entity.standarddefinition.models.CommonConcept;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "scrumproject")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public  class ScrumProject extends CommonConcept implements Serializable {

  @OneToOne
  @JoinColumn(name = "scrumprocess_id", referencedColumnName = "id")
  private ScrumProcess scrumprocess;

  @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "scrumproject")
  @Builder.Default
  private ScrumTeam scrumteam = null;

  @ManyToOne
  @JoinColumn(name = "scrumproject_id")
  private ScrumProject scrumproject;

  @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "scrumproject")
  @Builder.Default
  Set<ScrumProject> scrumprojects = new HashSet<>();


  @Builder.Default
  @Enumerated(EnumType.STRING)
  private ScrumProjectType type = ScrumProjectType.SCRUMATOMICPROJECT;


  @Builder.Default
  private LocalDateTime createdAt = LocalDateTime.now();

  @Override
  public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || this.getClass() != o.getClass()) return false;

        ScrumProject elem = (ScrumProject) o;
        return getId().equals(elem.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  @Override
  public String toString() {
      return "ScrumProject {" +
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

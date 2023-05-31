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

import br.nemo.immigrant.ontology.entity.productsprintbacklog.models.UserStory;
import br.nemo.immigrant.ontology.entity.productsprintbacklog.models.SprintBacklog;

import br.nemo.immigrant.ontology.entity.standarddefinition.models.CommonConcept;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "scrumdevelopmenttask")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public  class ScrumDevelopmentTask extends CommonConcept implements Serializable {

  @ManyToMany(mappedBy = "scrumdevelopmenttasks")
  @Builder.Default
  private Set<Sprint> sprints = new HashSet<>();

  @ManyToOne
  @JoinColumn(name = "scrumdevelopmenttask_id")
  private ScrumDevelopmentTask scrumdevelopmenttask;

  @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "scrumdevelopmenttask")
  @Builder.Default
  Set<ScrumDevelopmentTask> scrumdevelopmenttasks = new HashSet<>();

  @OneToOne
  @JoinColumn(name = "userstory_id", referencedColumnName = "id")
  private UserStory userstory;

  @ManyToOne
  @JoinColumn(name = "sprintbacklog_id")
  private SprintBacklog sprintbacklog;


  @Builder.Default
  @Enumerated(EnumType.STRING)
  private ScrumDevelopmentTaskType type = ScrumDevelopmentTaskType.PERFORMED;
  @Builder.Default
  @Enumerated(EnumType.STRING)
  private SucessfullyPerformedType sucessfully = SucessfullyPerformedType.NONSUCESSFULLY;


  @Builder.Default
  private LocalDateTime createdAt = LocalDateTime.now();

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || this.getClass() != o.getClass()) return false;

    ScrumDevelopmentTask elem = (ScrumDevelopmentTask) o;
    return getId().equals(elem.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  @Override
  public String toString() {
    return "ScrumDevelopmentTask {" +
            "id="+this.id+

            ", name='"+this.name+"'"+
            ", description='"+this.description+"'"+
            ", startDate='"+this.startDate+"'"+
            ", endDate='"+this.endDate+"'"+
            ", url='"+this.url+"'"+
            ", externalId='"+this.externalId+"'"+
            ", internalId='"+this.internalId+"'"+
            ", type='"+this.type+"'"+
            ", sucessfully='"+this.sucessfully+"'"+
            '}';
  }
}

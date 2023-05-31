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
import br.nemo.immigrant.ontology.entity.scrumdeliverable.models.SprintDeliverable;

import br.nemo.immigrant.ontology.entity.standarddefinition.models.CommonConcept;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sprint")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public  class Sprint extends CommonConcept implements Serializable {




  @ManyToOne
  @JoinColumn(name = "scrumprocess_id")
  private ScrumProcess scrumprocess;

  @OneToOne
  @JoinColumn(name = "sprintbacklog_id", referencedColumnName = "id")
  private SprintBacklog sprintbacklog;

  @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "sprint")
  @Builder.Default
  Set<Ceremony> ceremonys = new HashSet<>();

  @ManyToMany
  @JoinTable(
          name = "sprint_scrumdevelopmenttask",
          joinColumns = @JoinColumn(name = "sprint_id"),
          inverseJoinColumns = @JoinColumn(name = "scrumdevelopmenttask_id")
  )
  @Builder.Default
  private Set<ScrumDevelopmentTask> scrumdevelopmenttasks = new HashSet<>();

  @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "sprint")
  @Builder.Default
  private SprintDeliverable sprintdeliverable = null;





  @Builder.Default
  private LocalDateTime createdAt = LocalDateTime.now();

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || this.getClass() != o.getClass()) return false;

    Sprint elem = (Sprint) o;
    return getId().equals(elem.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  @Override
  public String toString() {
    return "Sprint {" +
            "id="+this.id+

            ", name='"+this.name+"'"+
            ", description='"+this.description+"'"+
            ", startDate='"+this.startDate+"'"+
            ", endDate='"+this.endDate+"'"+
            ", url='"+this.url+"'"+
            ", externalId='"+this.externalId+"'"+
            ", internalId='"+this.internalId+"'"+

            '}';
  }
}

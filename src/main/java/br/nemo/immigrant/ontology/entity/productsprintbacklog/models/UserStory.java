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

import br.nemo.immigrant.ontology.entity.scrumprocess.models.ScrumDevelopmentTask;
import br.nemo.immigrant.ontology.entity.scrumdeliverable.models.Deliverable;

import br.nemo.immigrant.ontology.entity.standarddefinition.models.CommonConcept;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "userstory")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public  class UserStory extends CommonConcept implements Serializable {




  private String importance;


  private String effort;


  private LocalDate createdDate;


  private LocalDate updateDate;

  @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "userstory")
  @Builder.Default
  private ScrumDevelopmentTask scrumdevelopmenttask = null;

  @ManyToOne
  @JoinColumn(name = "userstory_id")
  private UserStory userstory;

  @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "userstory")
  @Builder.Default
  Set<UserStory> userstorys = new HashSet<>();

  @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "userstory")
  @Builder.Default
  Set<AcceptanceCriterion> acceptancecriterions = new HashSet<>();

  @ManyToOne
  @JoinColumn(name = "productbacklog_id")
  private ProductBacklog productbacklog;

  @ManyToOne
  @JoinColumn(name = "sprintbacklog_id")
  private SprintBacklog sprintbacklog;

  @ManyToOne
  @JoinColumn(name = "deliverable_id")
  private Deliverable deliverable;


  @Builder.Default
  @Enumerated(EnumType.STRING)
  private UserStoryType type = UserStoryType.EPIC;


  @Builder.Default
  private LocalDateTime createdAt = LocalDateTime.now();

  @Override
  public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || this.getClass() != o.getClass()) return false;

        UserStory elem = (UserStory) o;
        return getId().equals(elem.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  @Override
  public String toString() {
      return "UserStory {" +
         "id="+this.id+
          ", importance='"+this.importance+"'"+
          ", effort='"+this.effort+"'"+
          ", createdDate='"+this.createdDate+"'"+
          ", updateDate='"+this.updateDate+"'"+
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

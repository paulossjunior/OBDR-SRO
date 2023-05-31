package br.nemo.immigrant.ontology.entity.standarddefinition.models;

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


@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class CommonConcept  implements Serializable {


        @Id
        protected @GeneratedValue (strategy=GenerationType.IDENTITY)
        Long id;



  protected String name;


  protected String description;

  protected String url;


  protected LocalDate startDate;


  protected LocalDate endDate;

  @Column(unique=true)
  protected String externalId;

  @Column(unique=true)
  protected String internalId;





  @Builder.Default
  private LocalDateTime createdAt = LocalDateTime.now();

  @Override
  public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || this.getClass() != o.getClass()) return false;

        CommonConcept elem = (CommonConcept) o;
        return getId().equals(elem.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  @Override
  public String toString() {
      return "CommonConcept {" +
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

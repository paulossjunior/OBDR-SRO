package br.nemo.immigrant.ontology.entity.scrumprocess.repositories;

import br.nemo.immigrant.ontology.entity.scrumprocess.models.Sprint;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.ListCrudRepository;



public interface SprintRepository extends PagingAndSortingRepository<Sprint, Long>, ListCrudRepository<Sprint, Long> {

}

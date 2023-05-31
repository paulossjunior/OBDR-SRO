package br.nemo.immigrant.ontology.entity.scrumdeliverable.repositories;

import br.nemo.immigrant.ontology.entity.scrumdeliverable.models.SprintDeliverable;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.ListCrudRepository;


public interface SprintDeliverableRepository extends PagingAndSortingRepository<SprintDeliverable, Long>, ListCrudRepository<SprintDeliverable, Long> {

}

package br.nemo.immigrant.ontology.entity.scrumdeliverable.repositories;

import br.nemo.immigrant.ontology.entity.scrumdeliverable.models.ScrumProjectDeliverable;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.ListCrudRepository;


public interface ScrumProjectDeliverableRepository extends PagingAndSortingRepository<ScrumProjectDeliverable, Long>, ListCrudRepository<ScrumProjectDeliverable, Long> {

}

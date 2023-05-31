package br.nemo.immigrant.ontology.entity.scrumdeliverable.repositories;

import br.nemo.immigrant.ontology.entity.scrumdeliverable.models.Deliverable;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.ListCrudRepository;


public interface DeliverableRepository extends PagingAndSortingRepository<Deliverable, Long>, ListCrudRepository<Deliverable, Long> {

}

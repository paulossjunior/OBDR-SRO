package br.nemo.immigrant.ontology.entity.stakeholders.repositories;

import br.nemo.immigrant.ontology.entity.stakeholders.models.teammembership;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.ListCrudRepository;


public interface teammembershipRepository extends PagingAndSortingRepository<teammembership, Long>, ListCrudRepository<teammembership, Long> {

}

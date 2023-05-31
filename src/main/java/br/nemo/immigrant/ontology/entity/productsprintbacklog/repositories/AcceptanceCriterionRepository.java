package br.nemo.immigrant.ontology.entity.productsprintbacklog.repositories;

import br.nemo.immigrant.ontology.entity.productsprintbacklog.models.AcceptanceCriterion;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.ListCrudRepository;



public interface AcceptanceCriterionRepository extends PagingAndSortingRepository<AcceptanceCriterion, Long>, ListCrudRepository<AcceptanceCriterion, Long> {



}

package br.nemo.immigrant.ontology.entity.scrumprocess.repositories;

import br.nemo.immigrant.ontology.entity.scrumprocess.models.ProductBacklogDefinition;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface ProductBacklogDefinitionRepository extends PagingAndSortingRepository<ProductBacklogDefinition, Long>, ListCrudRepository<ProductBacklogDefinition, Long> {

}

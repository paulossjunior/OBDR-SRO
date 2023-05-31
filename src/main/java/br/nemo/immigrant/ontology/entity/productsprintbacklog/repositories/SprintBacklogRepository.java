package br.nemo.immigrant.ontology.entity.productsprintbacklog.repositories;

import br.nemo.immigrant.ontology.entity.productsprintbacklog.models.SprintBacklog;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.ListCrudRepository;


public interface SprintBacklogRepository extends PagingAndSortingRepository<SprintBacklog, Long>, ListCrudRepository<SprintBacklog, Long> {

}

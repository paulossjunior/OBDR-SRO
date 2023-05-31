package br.nemo.immigrant.ontology.entity.scrumprocess.repositories;

import br.nemo.immigrant.ontology.entity.scrumprocess.models.ScrumProcess;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.ListCrudRepository;


public interface ScrumProcessRepository extends PagingAndSortingRepository<ScrumProcess, Long>, ListCrudRepository<ScrumProcess, Long> {

}

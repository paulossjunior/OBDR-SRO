package br.nemo.immigrant.ontology.entity.scrumprocess.repositories;

import br.nemo.immigrant.ontology.entity.scrumprocess.models.ScrumDevelopmentTask;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.ListCrudRepository;


public interface ScrumDevelopmentTaskRepository extends PagingAndSortingRepository<ScrumDevelopmentTask, Long>, ListCrudRepository<ScrumDevelopmentTask, Long> {

}

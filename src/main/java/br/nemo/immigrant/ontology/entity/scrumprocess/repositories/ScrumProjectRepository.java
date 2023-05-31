package br.nemo.immigrant.ontology.entity.scrumprocess.repositories;

import br.nemo.immigrant.ontology.entity.scrumprocess.models.ScrumProject;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.ListCrudRepository;


public interface ScrumProjectRepository extends PagingAndSortingRepository<ScrumProject, Long>, ListCrudRepository<ScrumProject, Long> {

}

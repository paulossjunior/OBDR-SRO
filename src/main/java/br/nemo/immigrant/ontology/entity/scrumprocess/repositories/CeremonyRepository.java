package br.nemo.immigrant.ontology.entity.scrumprocess.repositories;

import br.nemo.immigrant.ontology.entity.scrumprocess.models.Ceremony;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.ListCrudRepository;


public interface CeremonyRepository extends PagingAndSortingRepository<Ceremony, Long>, ListCrudRepository<Ceremony, Long> {

}

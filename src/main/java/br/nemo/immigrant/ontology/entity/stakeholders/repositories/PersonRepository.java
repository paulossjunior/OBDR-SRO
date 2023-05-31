package br.nemo.immigrant.ontology.entity.stakeholders.repositories;

import br.nemo.immigrant.ontology.entity.stakeholders.models.Person;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.ListCrudRepository;
public interface PersonRepository extends PagingAndSortingRepository<Person, Long>, ListCrudRepository<Person, Long> {

}

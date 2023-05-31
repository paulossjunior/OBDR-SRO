package br.nemo.immigrant.ontology.entity.productsprintbacklog.repositories;

import br.nemo.immigrant.ontology.entity.productsprintbacklog.models.UserStory;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface UserStoryRepository extends PagingAndSortingRepository<UserStory, Long>, ListCrudRepository<UserStory, Long> {

}

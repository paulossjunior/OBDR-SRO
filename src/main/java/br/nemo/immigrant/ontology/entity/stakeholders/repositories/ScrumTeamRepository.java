package br.nemo.immigrant.ontology.entity.stakeholders.repositories;

import br.nemo.immigrant.ontology.entity.stakeholders.models.ScrumTeam;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface ScrumTeamRepository extends PagingAndSortingRepository<ScrumTeam, Long>, ListCrudRepository<ScrumTeam, Long> {

}

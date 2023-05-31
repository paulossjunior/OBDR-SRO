package br.nemo.immigrant.ontology.entity.productsprintbacklog.repositories;

import br.nemo.immigrant.ontology.entity.productsprintbacklog.models.ProductBacklog;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.ListCrudRepository;



public interface ProductBacklogRepository extends PagingAndSortingRepository<ProductBacklog, Long>, ListCrudRepository<ProductBacklog, Long> {

}

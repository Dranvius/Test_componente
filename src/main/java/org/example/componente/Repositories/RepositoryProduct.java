package org.example.componente.Repositories;

import org.example.componente.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface RepositoryProduct extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
}

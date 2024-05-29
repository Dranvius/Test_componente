package org.example.componente.Repositories;

import org.example.componente.Entities.Provedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface RepositoryProvedor extends JpaRepository<Provedor, Long>, JpaSpecificationExecutor<Provedor>{
}

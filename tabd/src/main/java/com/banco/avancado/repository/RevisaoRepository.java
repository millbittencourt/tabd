package com.banco.avancado.repository;

import com.banco.avancado.model.Revisao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevisaoRepository extends JpaRepository<Revisao, Long> {
}

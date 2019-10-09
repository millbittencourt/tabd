package com.banco.avancado.repository;

import com.banco.avancado.model.Participante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipanteRepository  extends JpaRepository<Participante, Long> {
}

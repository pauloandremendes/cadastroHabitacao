package com.cadastroHabitacao.repository;

import com.cadastroHabitacao.model.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}

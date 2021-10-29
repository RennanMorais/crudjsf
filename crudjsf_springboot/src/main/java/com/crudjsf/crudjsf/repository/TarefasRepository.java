package com.crudjsf.crudjsf.repository;

import com.crudjsf.crudjsf.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefasRepository extends JpaRepository<Tarefa, Long> {
}

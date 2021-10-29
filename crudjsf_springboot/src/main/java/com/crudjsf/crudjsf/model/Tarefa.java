package com.crudjsf.crudjsf.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="tarefas")
@Data
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tarefa;

}

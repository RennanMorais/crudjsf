package com.crudjsf.crudjsf.dto;

import com.crudjsf.crudjsf.model.Tarefa;
import lombok.Data;

@Data
public class TarefaDto {

    private Long id;
    private String tarefa;

    public Tarefa toTarefa() {
        Tarefa t = new Tarefa();
        t.setTarefa(tarefa);
        return t;
    }

}

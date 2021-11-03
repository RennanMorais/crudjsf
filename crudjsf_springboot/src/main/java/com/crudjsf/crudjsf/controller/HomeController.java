package com.crudjsf.crudjsf.controller;

import com.crudjsf.crudjsf.dto.TarefaDto;
import com.crudjsf.crudjsf.model.Tarefa;
import com.crudjsf.crudjsf.repository.TarefasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class HomeController {

    @Autowired
    TarefasRepository tarefasRepository;

    @GetMapping
    public List<Tarefa> getTarefas() {
        List<Tarefa> tarefas = tarefasRepository.findAll();
        return tarefas;
    }

    @PostMapping("/add")
    public String add(@RequestBody TarefaDto request) {
        Tarefa t = request.toTarefa();

        if(t.getTarefa().isEmpty()) {
            return "Não salvo!";
        }

        tarefasRepository.save(t);
        return "Salvo!";
    }

}

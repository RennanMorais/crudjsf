package com.crudjsf.crudjsf.controller;

import com.crudjsf.crudjsf.model.Tarefa;
import com.crudjsf.crudjsf.repository.TarefasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

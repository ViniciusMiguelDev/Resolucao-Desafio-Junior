package br.com.picpay1.picpay1.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.picpay1.picpay1.entity.Todo;
import br.com.picpay1.picpay1.service.TodoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService service;

    @PostMapping
    List<Todo> create(@RequestBody @Valid Todo todo) {
        return service.create(todo);
    }

    @GetMapping
    List<Todo> read() {
        return service.read();
    }

    @PutMapping
    List<Todo> update(@RequestBody Todo todo) {
        return service.update(todo);
    }

    @DeleteMapping("{id}")
    List<Todo> delete(@PathVariable("id") UUID id) {
        return service.delete(id);
    }

}

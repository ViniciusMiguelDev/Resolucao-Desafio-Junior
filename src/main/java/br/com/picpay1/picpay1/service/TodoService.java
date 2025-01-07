package br.com.picpay1.picpay1.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.picpay1.picpay1.entity.Todo;
import br.com.picpay1.picpay1.repository.TodoRepository;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public List<Todo> create(Todo todo) {
        repository.save(todo);
        return read();
    }

    public List<Todo> read() {
        Sort sort = Sort.by("prioridade").descending().and(Sort.by("nome")).ascending();
        return repository.findAll(sort);
    }

    public List<Todo> update(Todo todo) {
        repository.save(todo);
        return read();
    }

    public List<Todo> delete(UUID id) {
        repository.deleteById(id);
        return read();
    }
}

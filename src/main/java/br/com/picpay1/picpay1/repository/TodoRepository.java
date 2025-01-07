package br.com.picpay1.picpay1.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.picpay1.picpay1.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, UUID>{

}

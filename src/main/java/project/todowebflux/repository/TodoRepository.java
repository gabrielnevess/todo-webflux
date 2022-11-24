package project.todowebflux.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import project.todowebflux.domain.Todo;

@Repository
public interface TodoRepository extends ReactiveCrudRepository<Todo, Integer> {}

package project.todowebflux.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import project.todowebflux.domain.Todo;
import project.todowebflux.repository.TodoRepository;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class TodoService {
    private final TodoRepository todoRepository;

    public Mono<Todo> save(Todo todo) {
        return todoRepository.save(todo);
    }

    public Mono<Todo> findById(Integer id) {
        return todoRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Todo not found with id %d", id))));
    }

}

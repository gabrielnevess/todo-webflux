package project.todowebflux.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import project.todowebflux.domain.Todo;
import project.todowebflux.domain.dto.TodoDTO;
import project.todowebflux.domain.mapper.TodoMapper;
import project.todowebflux.repository.TodoRepository;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class TodoService {

    private final TodoMapper mapper;
    private final TodoRepository todoRepository;

    public Mono<Todo> save(TodoDTO todoDTO) {
        return this.todoRepository.save(mapper.toDomain(todoDTO));
    }

    public Mono<Todo> findById(Integer id) {
        return this.todoRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Todo not found with id %d", id))));
    }

    public Mono<Todo> update(Todo todo) {
        return this.findById(todo.getId())
                .map(t -> {
                    t.setName(todo.getName());
                    t.setDescription(todo.getDescription());
                    return t;
                })
                .flatMap(todoRepository::save);
    }

    public Mono<Void> delete(Integer id) {
        return this.findById(id)
                .flatMap(this.todoRepository::delete)
                .then();
    }

}

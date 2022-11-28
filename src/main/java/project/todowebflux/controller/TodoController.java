package project.todowebflux.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import project.todowebflux.domain.Todo;
import project.todowebflux.domain.dto.TodoDTO;
import project.todowebflux.service.TodoService;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class TodoController {
    private final TodoService todoService;

    @PostMapping(value = "/todo")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Todo> save(@Valid @RequestBody TodoDTO todoDTO) {
        return todoService.save(todoDTO);
    }

    @GetMapping(value = "/todo/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Todo> findById(@PathVariable(value = "id") Integer id) {
        return todoService.findById(id);
    }

    @PutMapping(value = "/todo")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Todo> update(@Valid @RequestBody Todo todo) {
        return todoService.update(todo);
    }

    @DeleteMapping(value = "/todo/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> delete(@PathVariable(value = "id") Integer id) {
        return todoService.delete(id);
    }

}

package project.todowebflux.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import project.todowebflux.domain.Todo;
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
    public Mono<Todo> save(@Valid @RequestBody Todo todo) {
        return todoService.save(todo);
    }

    @GetMapping(value = "/todo/{id}")
    public Mono<Todo> findById(@PathVariable(value = "id") Integer id) {
        return todoService.findById(id);
    }

}

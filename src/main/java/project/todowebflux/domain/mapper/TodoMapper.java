package project.todowebflux.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import project.todowebflux.domain.Todo;
import project.todowebflux.domain.dto.TodoDTO;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    TodoMapper INSTANCE = Mappers.getMapper(TodoMapper.class);

    public Todo toDomain(TodoDTO todoDTO);
    public TodoDTO toDTO(Todo todo);

}

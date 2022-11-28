package project.todowebflux.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.relational.core.mapping.Column;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class TodoDTO {
    @JsonProperty(value = "name")
    @NotBlank(message = "name is required")
    @Size(min = 5, max = 255, message = "name must have a minimum of {min} characters and a maximum of {max} characters")
    @Column("name")
    private String name;

    @JsonProperty(value = "description")
    @NotBlank(message = "description is required")
    @Size(min = 5, max = 1000, message = "description must have a minimum of {min} characters and a maximum of {max} characters")
    @Column("description")
    private String description;
}

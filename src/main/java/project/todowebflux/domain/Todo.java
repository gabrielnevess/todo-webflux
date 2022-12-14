package project.todowebflux.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Table("tb_todo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Todo {
    @JsonProperty(value = "id")
    @Id
    @Column("id")
    private Integer id;

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

    @JsonProperty(value = "createdAt")
    @CreatedDate
    @Column("created_at")
    private Timestamp createdAt;

    @JsonProperty(value = "updatedAt")
    @LastModifiedDate
    @Column("updated_at")
    private Timestamp updatedAt;
}

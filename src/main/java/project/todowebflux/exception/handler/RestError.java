package project.todowebflux.exception.handler;

import java.util.Date;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class RestError {
    private String field;
    private Date timestamp;
    private String message;
    private String details;
}
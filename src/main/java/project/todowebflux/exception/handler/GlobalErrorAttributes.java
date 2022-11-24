package project.todowebflux.exception.handler;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.Optional;

@Component
public class GlobalErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(ServerRequest request, ErrorAttributeOptions options) {
        Map<String, Object> errorAttributesMap = super.getErrorAttributes(request, options);
        Throwable throwable = getError(request);
        if (throwable instanceof ResponseStatusException) {
            ResponseStatusException ex = (ResponseStatusException) throwable;
            errorAttributesMap.put("message", Optional.ofNullable(ex.getReason()));
            return errorAttributesMap;
        }
        return errorAttributesMap;
    }

}
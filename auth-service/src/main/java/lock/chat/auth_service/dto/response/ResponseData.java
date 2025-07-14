package lock.chat.auth_service.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
public class ResponseData<T> implements Serializable {

    private int status;

    private String message;

    private boolean success;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
}

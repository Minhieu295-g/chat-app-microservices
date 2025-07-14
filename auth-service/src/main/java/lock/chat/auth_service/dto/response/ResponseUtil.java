package lock.chat.auth_service.dto.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {

    // Success with data
    public static <T> ResponseEntity<ResponseData<T>> success(T data) {
        return ResponseEntity.ok(
                ResponseData.<T>builder()
                        .status(HttpStatus.OK.value())
                        .message("Success")
                        .success(true)
                        .data(data)
                        .build()
        );
    }
    // Success with custom message
    public static <T> ResponseEntity<ResponseData<T>> success(String message, T data) {
        return ResponseEntity.ok(
                ResponseData.<T>builder()
                        .status(HttpStatus.OK.value())
                        .message(message)
                        .success(true)
                        .data(data)
                        .build()
        );
    }

    // Success without data
    public static ResponseEntity<ResponseData<Object>> success() {
        return ResponseEntity.ok(
                ResponseData.builder()
                        .status(HttpStatus.OK.value())
                        .message("Success")
                        .success(true)
                        .build()
        );
    }

    // Error with custom message
    public static ResponseEntity<ResponseData<Object>> error(String message) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ResponseData.builder()
                        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .message(message)
                        .success(false)
                        .build()
                );
    }

    // Error with data
    public static <T> ResponseEntity<ResponseData<T>> error(String message, T data) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ResponseData.<T>builder()
                        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .message(message)
                        .success(false)
                        .data(data)
                        .build()
                );
    }

    // Bad Request
    public static ResponseEntity<ResponseData<?>> badRequest(String message) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ResponseData.builder()
                        .status(HttpStatus.BAD_REQUEST.value())
                        .message(message)
                        .success(false)
                        .build()
                );
    }

    // Unauthorized
    public static ResponseEntity<ResponseData<?>> unauthorized(String message) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(ResponseData.builder()
                        .status(HttpStatus.UNAUTHORIZED.value())
                        .message(message)
                        .success(false)
                        .build()
                );
    }

    // Forbidden
    public static ResponseEntity<ResponseData<?>> forbidden(String message) {
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(ResponseData.builder()
                        .status(HttpStatus.FORBIDDEN.value())
                        .message(message)
                        .success(false)
                        .build()
                );
    }


}

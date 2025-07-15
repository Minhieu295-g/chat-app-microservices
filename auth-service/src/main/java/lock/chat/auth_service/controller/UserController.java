package lock.chat.auth_service.controller;

import jakarta.validation.Valid;
import lock.chat.auth_service.dto.request.UserRequestDTO;
import lock.chat.auth_service.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static lock.chat.auth_service.dto.response.ResponseUtil.success;

@RestController
@Validated
@Slf4j
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> getAllUsers(@RequestBody @Valid UserRequestDTO userRequest) {
        return success(userService.createUser(userRequest));
    }

}

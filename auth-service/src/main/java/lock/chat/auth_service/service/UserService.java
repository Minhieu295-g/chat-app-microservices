package lock.chat.auth_service.service;

import lock.chat.auth_service.dto.request.UserRequestDTO;
import lock.chat.auth_service.model.User;

public interface UserService {

    String createUser(UserRequestDTO userRequest);

    void updateUser(String id ,UserRequestDTO userRequest);

    void deleteUser(String id);

    User getUserById(String id);

}

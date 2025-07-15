package lock.chat.auth_service.service.impl;

import lock.chat.auth_service.dto.request.UserRequestDTO;
import lock.chat.auth_service.kafka.dto.request.UserProfileRequest;
import lock.chat.auth_service.kafka.producer.EventPushliser;
import lock.chat.auth_service.kafka.producer.Producer;
import lock.chat.auth_service.kafka.producer.UserProfileProducer;
import lock.chat.auth_service.model.User;
import lock.chat.auth_service.repository.UserRepository;
import lock.chat.auth_service.service.UserService;
import lock.chat.auth_service.util.UserStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserProfileProducer userProfileProducer;

    @Override
    public String createUser(UserRequestDTO userRequest) {
        User user = User.builder()
                .username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .status(UserStatus.INACTIVE)
                .email(userRequest.getEmail())
                .build();
        userRepository.save(user);
        UserProfileRequest request = UserProfileRequest.builder()
                .id(user.getId())
                .fullName(userRequest.getFullName())
                .gender(userRequest.isGender())
                .numberPhone(userRequest.getNumberPhone())
                .build();
        userProfileProducer.publish(user.getId(), request);
        return user.getId();
    }

    @Override
    public void updateUser(String id, UserRequestDTO userRequest) {

    }

    @Override
    public void deleteUser(String id) {

    }

    @Override
    public User getUserById(String id) {
        return null;
    }
}

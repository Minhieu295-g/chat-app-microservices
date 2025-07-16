package lock.chat.profile_service.kafka.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lock.chat.profile_service.kafka.dto.BaseMessage;
import lock.chat.profile_service.kafka.dto.response.UserProfileDTO;
import lock.chat.profile_service.model.UserProfile;
import lock.chat.profile_service.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class Listener {

    private final UserProfileService userProfileService;
    private final ObjectMapper objectMapper;


    @KafkaListener(topics = "user.profile", groupId = "user-profile-group")
    public void listen(Map<String, Object> record){
        BaseMessage<?> message = objectMapper.convertValue(record, BaseMessage.class);
        System.out.println( "Received: " + message);

        UserProfileDTO payload = objectMapper.convertValue(message.getPayload(), UserProfileDTO.class);

        userProfileService.createUserProfile(payload);
    }
}

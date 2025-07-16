package lock.chat.auth_service.kafka.producer;

import lock.chat.auth_service.kafka.dto.BaseMessage;
import lock.chat.auth_service.kafka.dto.request.UserProfileDTO;
import lock.chat.auth_service.kafka.util.MessageUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserProfileProducer implements EventPushliser<UserProfileDTO>{

    private final KafkaTemplate<String, Object> kafkaTemplate;

    private static final String TOPIC = "user.profile";

    @Override
    public void publish(String topic, String key, UserProfileDTO dto) {

    }
    @Override
    public void publish(String key, UserProfileDTO dto) {
        BaseMessage<UserProfileDTO> base = MessageUtil.wrap(dto, "auth-service", "UserProfile");
        log.info("send topic {}", TOPIC);
        log.info("send message {}", base);
        kafkaTemplate.send(TOPIC, key, base);

    }

}

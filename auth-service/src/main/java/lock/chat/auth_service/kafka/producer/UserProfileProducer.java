package lock.chat.auth_service.kafka.producer;

import lock.chat.auth_service.kafka.dto.BaseMessage;
import lock.chat.auth_service.kafka.dto.request.UserProfileRequest;
import lock.chat.auth_service.kafka.util.MessageUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserProfileProducer implements EventPushliser<UserProfileRequest>{

    private final KafkaTemplate<String, Object> kafkaTemplate;

    private static final String TOPIC = "user.profile";

    @Override
    public void publish(String topic, String key, UserProfileRequest dto) {

    }
    @Override
    public void publish(String key, UserProfileRequest dto) {
        BaseMessage<UserProfileRequest> base = MessageUtil.wrap(dto, "auth-service", "UserProfile");
        log.info("send topic {}", TOPIC);
        log.info("send message {}", base);
        kafkaTemplate.send(TOPIC, key, base);

    }

}

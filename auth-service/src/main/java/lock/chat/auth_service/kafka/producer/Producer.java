package lock.chat.auth_service.kafka.producer;

import lock.chat.auth_service.kafka.dto.BaseMessage;
import lock.chat.auth_service.kafka.dto.request.UserProfileRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class Producer {

    private final KafkaTemplate<String, BaseMessage<?>> kafkaTemplate;

    public void send(String topic, UserProfileRequest dto) {
        BaseMessage<UserProfileRequest> base = wrap(dto, "UserProfile");
        log.info("send topic {}", topic);
        log.info("send message {}", base);
        kafkaTemplate.send(topic, base);
    }

    private <T> BaseMessage<T> wrap(T payload, String type) {
        BaseMessage<T> msg = new BaseMessage<>();
        msg.setType(type);
        msg.setPayload(payload);
        msg.setTraceId(UUID.randomUUID().toString());
        msg.setSource("message-api");
        msg.setId(UUID.randomUUID().toString());
        return msg;
    }
}

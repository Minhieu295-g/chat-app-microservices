package lock.chat.auth_service.kafka.producer;

import lock.chat.auth_service.kafka.dto.BaseMessage;

public interface EventPushliser<T> {
    void publish(String topic, String key, T message);
    void publish(String key, T message);
}

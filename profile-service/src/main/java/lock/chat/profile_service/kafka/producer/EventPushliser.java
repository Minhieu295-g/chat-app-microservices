package lock.chat.profile_service.kafka.producer;

public interface EventPushliser<T> {
    void publish(String topic, String key, T message);
    void publish(String key, T message);
}

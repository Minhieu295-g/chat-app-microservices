package lock.chat.auth_service.kafka.consumer;

import lock.chat.auth_service.kafka.dto.BaseMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {
    @KafkaListener(topics = "auth-topic", groupId = "auth-group")
    public void listen(BaseMessage<?> message){
        System.out.println( "Received: " + message);
    }

}

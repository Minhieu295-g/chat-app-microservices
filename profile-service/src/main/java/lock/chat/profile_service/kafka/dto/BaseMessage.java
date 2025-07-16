package lock.chat.profile_service.kafka.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class BaseMessage<T> {
    String id;
    String type;
    String source;
    Instant timestamp = Instant.now();
    String traceId;
    T payload;
}

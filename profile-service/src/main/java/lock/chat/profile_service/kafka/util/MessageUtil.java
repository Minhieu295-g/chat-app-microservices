package lock.chat.profile_service.kafka.util;


import lock.chat.profile_service.kafka.dto.BaseMessage;

import java.util.UUID;

public class MessageUtil {

    public static  <T> BaseMessage<T> wrap(T payload, String source , String type) {
        BaseMessage<T> msg = new BaseMessage<>();
        msg.setType(type);
        msg.setPayload(payload);
        msg.setTraceId(UUID.randomUUID().toString());
        msg.setSource(source);
        msg.setId(UUID.randomUUID().toString());
        return msg;
    }

}

package lock.chat.auth_service.kafka.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserProfileRequest implements Serializable {

    String id;

    String numberPhone;

    String fullName;

    boolean gender;

}

package lock.chat.auth_service.kafka.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import java.io.Serializable;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserProfileDTO implements Serializable {

    String userId;

    String numberPhone;

    String fullName;

    boolean gender;

}

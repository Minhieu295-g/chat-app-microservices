package lock.chat.profile_service.kafka.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserProfileDTO implements Serializable {

    UUID userId;

    String numberPhone;

    String fullName;

    boolean gender;

}

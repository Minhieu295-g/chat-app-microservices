package lock.chat.auth_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lock.chat.auth_service.dto.validator.Email;
import lock.chat.auth_service.dto.validator.Password;
import lock.chat.auth_service.dto.validator.PhoneNumber;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequestDTO implements Serializable {

    @NotBlank(message = "username must be not blank")
    @Length(min = 8, message = "username must be at least 8 character long")
    String username;

    @Email
    String email;

    @Password
    @NotBlank(message = "password not be not blank")
    String password;

    @PhoneNumber
    String numberPhone;

    @NotBlank(message = "Full name must be not blank")
    String fullName;

    boolean gender;

}

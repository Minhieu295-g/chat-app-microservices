package lock.chat.auth_service.model;

import jakarta.persistence.*;
import lock.chat.auth_service.util.UserStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.Instant;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "users")
@Entity
public class User extends AbsEntity{

    @Column(name = "username", unique = true, nullable = false)
    String username;

    @Column(name = "email", unique = true, nullable = false)
    String email;

    @Column(name = "password", nullable = false)
    String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    UserStatus status = UserStatus.INACTIVE;

    @Column(name = "reset_token")
    private String resetToken;

    @Column(name = "reset_token_expiry")
    private Instant resetTokenExpiry;
}

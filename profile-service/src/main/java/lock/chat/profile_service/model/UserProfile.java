package lock.chat.profile_service.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Node("user_profile")
public class UserProfile {

    @Id
    @GeneratedValue(generatorClass = GeneratedValue.UUIDGenerator.class)
    @Property("id")
    UUID id;

    @Property("user_id")
    String userId;

    @Property("full_name")
    String fullName;

    @Property("number_phone")
    String numberPhone;

    @Property("gender")
    boolean gender;

    @Property("created_at")
    @CreatedDate
    Date createdAt;

    @Property("updated_at")
    @LastModifiedDate
    Date updatedAt;
}

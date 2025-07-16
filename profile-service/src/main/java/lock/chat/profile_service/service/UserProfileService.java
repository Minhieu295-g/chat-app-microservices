package lock.chat.profile_service.service;

import lock.chat.profile_service.kafka.dto.response.UserProfileDTO;

public interface UserProfileService {

    String createUserProfile(UserProfileDTO userProfile);

}

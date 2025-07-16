package lock.chat.profile_service.service.impl;

import lock.chat.profile_service.kafka.dto.response.UserProfileDTO;
import lock.chat.profile_service.model.UserProfile;
import lock.chat.profile_service.repository.UserProfileRepository;
import lock.chat.profile_service.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;

    @Override
    public String createUserProfile(UserProfileDTO userProfile) {
        UserProfile userProfileEntity = UserProfile.builder()
                .fullName(userProfile.getFullName())
                .gender(userProfile.isGender())
                .numberPhone(userProfile.getNumberPhone())
                .userId(userProfile.getUserId().toString())
                .build();
        userProfileRepository.save(userProfileEntity);
        return userProfile.getUserId().toString();
    }
}

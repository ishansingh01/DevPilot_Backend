package devpilot.backend.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


public record UserResponse (
        UUID id,
        Long githubId,
        String githubUsername,
        String displayName,
        String avatarUrl
){
}

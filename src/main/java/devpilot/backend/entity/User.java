package devpilot.backend.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private Long githubId;

    @Column(nullable = false, length = 100)
    private String githubUsername;

    @Column(unique = true, length = 200)
    private String displayName;

    @Column(length = 500)
    private String avatarUrl;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String accessToken;

    @Column(length = 500)
    private String tokenScopes;

    @Column(nullable = false, updatable = false )
    private Instant createdAt;


    @PrePersist
    void onCreate(){
        if(createdAt == null){
            createdAt = Instant.now();
        }
    }

}

package org.springexmaples.SocialMediaEntity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocialProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String description;
    @OneToOne
    @JoinColumn(name = "social_users")
    @JsonIgnore
    private SocialUser socialUser;

    public void setSocialUser(SocialUser socialUser) {
        this.socialUser = socialUser;
        if (socialUser.getSocialProfile() != this)
            socialUser.setSocialProfile(this);


    }
}
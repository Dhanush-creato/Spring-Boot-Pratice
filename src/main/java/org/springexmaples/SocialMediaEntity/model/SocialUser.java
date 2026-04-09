package org.springexmaples.SocialMediaEntity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocialUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    @OneToOne(mappedBy = "socialUser",cascade = CascadeType.ALL)
    private SocialProfile socialProfile;

    @OneToMany(mappedBy = "socialUser",fetch =FetchType.EAGER)

    private List<Post> posts;

    @ManyToMany

    @JoinTable(
            name = "social_users",
            joinColumns = @JoinColumn(name = "Socila_user"),
            inverseJoinColumns = @JoinColumn(name = "Social_Group")

    )
    private Set<SocialGroup> socialGroups = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SocialUser that = (SocialUser) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setSocialProfile(SocialProfile socialProfile){
        this.socialProfile= socialProfile;
        if(socialProfile != null) {
            socialProfile.setSocialUser(this);
        }
    }

    public void addSocialGroup(SocialGroup socialGroup) {
        if (socialGroup == null) {
            return;
        }
        socialGroups.add(socialGroup);
        socialGroup.getSocialUsers().add(this);
    }
}

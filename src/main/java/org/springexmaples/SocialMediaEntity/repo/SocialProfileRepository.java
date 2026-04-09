package org.springexmaples.SocialMediaEntity.repo;


import org.springexmaples.SocialMediaEntity.model.SocialProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialProfileRepository  extends JpaRepository<SocialProfile,Long> {
}

package org.springexmaples.SocialMediaEntity.repo;


import org.springexmaples.SocialMediaEntity.model.SocialUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialUserRepository  extends JpaRepository<SocialUser,Long> {
}

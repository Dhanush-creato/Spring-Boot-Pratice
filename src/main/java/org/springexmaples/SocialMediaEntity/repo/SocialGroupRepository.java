package org.springexmaples.SocialMediaEntity.repo;


import org.springexmaples.SocialMediaEntity.model.SocialGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialGroupRepository  extends JpaRepository<SocialGroup,Long> {
}

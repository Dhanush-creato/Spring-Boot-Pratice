package org.springexmaples.SocialMediaEntity.repo;

import org.springexmaples.SocialMediaEntity.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
}

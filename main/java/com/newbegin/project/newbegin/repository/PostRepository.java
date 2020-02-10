package com.newbegin.project.newbegin.repository;

import com.newbegin.project.newbegin.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Override
    void deleteById(Long id);


    List<Post> findByTextContains(String text);

    @Query("from Post p where p.id=:id")
    Post getPostById(@Param("id") Long id);

}

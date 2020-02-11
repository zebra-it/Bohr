package com.newbegin.project.newbegin.repository;

import com.newbegin.project.newbegin.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Override
    void deleteById(Long id);


    List<Post> findByTextContains(String text);

    @Query("select count(p) from Post p")
    Integer countPostsByUsers();

    @Query("select count(distinct p.author) from Post p")
    Integer countUsersWithPosts();

    @Query("select p.postedAt from Post p group by p.postedAt order by p.postedAt desc ")
    List<String> getDate();

    @Query("select count(p) from Post p group by p.postedAt order by p asc ")
    List<Integer> countByDate();


}

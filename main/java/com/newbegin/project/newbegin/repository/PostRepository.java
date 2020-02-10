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


    @Query("select  p.createTime from Post p order by p.createTime")
    List<String> getTime();

    @Query(value = "select count(*)from posts group by create_date",
            nativeQuery = true)
    List<Integer> countPostsByDate();

    @Query(value = "select count(*)from posts group by create_time",
            nativeQuery = true)
    List<Integer> countPostsByTime();



    @Query("select  p.createDate from Post p group by p.createDate")
    List<String> datePosts();


    List<Post> findByTextContains(String text);

    @Query("from Post p where p.id=:id")
    Post getPostById(@Param("id") Long id);

}

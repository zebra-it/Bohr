package com.newbegin.project.newbegin.repository;

import com.newbegin.project.newbegin.model.Tag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {

    @Query("select distinct t.textTag from Tag t  where t.textTag!='' order by rand()")
    List<String> getAllTags();

    @Query(value = "SELECT post_id FROM test.tags where text_tag=:textTag",
            nativeQuery = true)
    List<Long> getPostId(@Param("textTag") String textTag);

    @Query(value = "SELECT count(*) FROM test.tags group by text_tag",
            nativeQuery = true)
    List<Integer> countTags();
}

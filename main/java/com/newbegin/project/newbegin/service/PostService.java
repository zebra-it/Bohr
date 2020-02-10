package com.newbegin.project.newbegin.service;

import com.newbegin.project.newbegin.model.Post;
import com.newbegin.project.newbegin.model.Tag;
import com.newbegin.project.newbegin.model.User;
import com.newbegin.project.newbegin.repository.PostRepository;
import com.newbegin.project.newbegin.repository.TagRepository;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private TagRepository tagRepository;

    public List<Post> postList() {
        return postRepository.findAll();
    }

    @Transactional
    public void delete(long id) {
        postRepository.deleteById(id);
    }

    public void addNewPost(Post post, String typeTags, User user, Model model) {

        LocalTime localTime = new LocalTime();
        String date = new LocalDate().toString();
        post.setCreateTime(localTime.getHourOfDay() + ":" + localTime.getMinuteOfHour());
        post.setCreateDate(date);
        post.setAuthor(user);
        if (typeTags != null && !typeTags.isEmpty()) {
            List<String> tagsList = Arrays.asList(typeTags.split("\\s"));

            for (String t : tagsList) {
                post.addTag(new Tag(t));
            }
        }

        model.addAttribute("post", null);
        postRepository.save(post);
    }


    public List<Post> findPostByText(String text) {
        List<Post> textContains = postRepository.findByTextContains(text);
        if (textContains.isEmpty()) {
            return null;
        }

        return textContains;
    }

    public List<String> toptags() {
        return tagRepository.getAllTags();
    }

    public List<Post> findPostsByTag(String textTag) {
        List<Long> postId = tagRepository.getPostId(textTag);
        List<Post> posts = new ArrayList<>();
        for (Long id : postId) {
            posts.add(postRepository.getPostById(id));
        }
        return posts;

    }


}

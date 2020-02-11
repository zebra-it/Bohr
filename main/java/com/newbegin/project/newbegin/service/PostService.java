package com.newbegin.project.newbegin.service;

import com.newbegin.project.newbegin.model.Post;
import com.newbegin.project.newbegin.model.Tag;
import com.newbegin.project.newbegin.model.User;
import com.newbegin.project.newbegin.repository.PostRepository;
import com.newbegin.project.newbegin.repository.TagRepository;
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
        List<Post> tagContains = findPostsByTag(text);
        List<Post> result = new ArrayList<>();

        if (textContains.isEmpty() && !tagContains.isEmpty()) {
            result.addAll(findPostsByTag(text));
        }
        if (tagContains.isEmpty() && !textContains.isEmpty()) {
            result.addAll(textContains);
        }
        result.addAll(textContains);
        result.addAll(tagContains);

        return result;
    }

    public List<String> toptags() {
        return tagRepository.getAllTags();
    }

    public List<Post> findPostsByTag(String textTag) {
        return tagRepository.findPostByTag(textTag);
    }





}
